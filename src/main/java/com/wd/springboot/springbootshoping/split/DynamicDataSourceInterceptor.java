package com.wd.springboot.springbootshoping.split;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.keygen.SelectKeyGenerator;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Locale;
import java.util.Properties;

/**
 * ClassName:DynamicDataSourceInterceptor
 * Package:com.wd.springboot.springbootshoping.split
 * Description:
 * 动态数据源拦截器 根据不同的Sql语句切换不同的数据源主写从读
 * @Date:2019/6/25 0025 1:14
 * @Author:王迪
 */
@Intercepts({@Signature(type = Executor.class,method = "update",args = {MappedStatement.class,Object.class}),
             @Signature(type = Executor.class,method = "query",args = {MappedStatement.class,Object.class, RowBounds.class, ResultHandler.class})})
public class DynamicDataSourceInterceptor implements Interceptor {
    private static Logger logger=LoggerFactory.getLogger(DynamicDataSourceInterceptor.class);
    private static final String REGEX=".*insert\\u0020.*|.*update\\u0020.*|.*delete\\u0020.*";
    /**
     * 拦截目标对象
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //判断是否是新事务，如果是新事务，则需要把事务属性存放到当前线程中
        boolean synchronizationActive=TransactionSynchronizationManager.isActualTransactionActive();
        //获取mybatis转换过来的CRUD参数
        Object[] objects=invocation.getArgs();
        System.out.println("转换过后的参数------"+objects);
        //MappedStatement维护了一条<select|update|delete|insert>节点的封装
        MappedStatement mappedStatement= (MappedStatement) objects[0];
        //默认主库写入操作
        String dbKey=DynamicDataSourceHolder.MASTER_DB;
        if (synchronizationActive!=true){
            /**
             * SqlCommandType.SELECT Sql的类型  select|update|insert|delete
             */
            if (mappedStatement.getSqlCommandType().equals(SqlCommandType.SELECT)){
                /**dss
                 * 有些时候数据必须从主库读取比如获取自增长主键,利用主键对数据进行update
                 * 检查一个字符串中是否包含想要查找的值，可以使用string.contains方法，
                 * 使用方法为:被查找的字符串.contains（要查找的字符串），返回类型为boolean。
                 * selectKey 为自增主键(SELECT LAST_INSERT_ID) 使用主库
                 */
                if (mappedStatement.getId().contains(SelectKeyGenerator.SELECT_KEY_SUFFIX)){
                    System.out.println("调用SELECT LAST_INSERT_ID 方法------"+SelectKeyGenerator.SELECT_KEY_SUFFIX);
                    dbKey=DynamicDataSourceHolder.MASTER_DB;
                }else {
                    /**
                     * BoundSql表示动态生成的SQL语句以及相应的参数信息
                     * getSqlSource()  sql对象中对应的sql语句
                     */
                    BoundSql boundSql=mappedStatement.getSqlSource().getBoundSql(objects[1]);
                    //将字符装换为简体中文的小写
                    String sql = boundSql.getSql().toLowerCase(Locale.CHINA).replaceAll("[\\t\\n\\r]", " ");
                    if (sql.matches(REGEX)){
                        dbKey=DynamicDataSourceHolder.MASTER_DB;
                    }else {
                        dbKey=DynamicDataSourceHolder.SLAVE_DB;
                    }
                }
            }
        }else {
            //不受事物管理的默认主库
            dbKey=DynamicDataSourceHolder.MASTER_DB;
        }
        System.out.println(mappedStatement.getId());
        System.out.println(dbKey);
        System.out.println(mappedStatement.getSqlCommandType().name());
        logger.debug("设置方法为 [{}] 使用的是 [{}], sql类型SqlCommandType [{}].. ",mappedStatement.getId(),dbKey,mappedStatement.getSqlCommandType().name());
         DynamicDataSourceHolder.setDbType(dbKey);
        //执行拦截对象真正的方法
        System.out.println("执行拦截对象真正的方法"+invocation.proceed());
         return invocation.proceed();
    }

    /**
     * 包装目标对象 为目标对象创建动态代理
     * MyBatis执行器，是MyBatis 调度的核心，负责SQL语句的生成和查询缓存的维护
     * @param target
     * @return
     */
    @Override
    public Object plugin(Object target) {
        System.out.println("目标对象------"+target);
        if (target instanceof Executor){
            System.out.println("创建的代理对象------"+target);
            return Plugin.wrap(target,this);
        }else {
            return target;
        }

    }

    /**
     * 获取插件初始化参数
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {

    }
}
