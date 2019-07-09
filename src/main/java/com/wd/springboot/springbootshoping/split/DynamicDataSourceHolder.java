package com.wd.springboot.springbootshoping.split;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassName:DynamicDataSourceHolder
 * Package:com.wd.springboot.springbootshoping.split
 * Description:
 *  动态返回数据源
 * @Date:2019/6/25 0025 0:33
 * @Author:王迪
 */
public class DynamicDataSourceHolder {
    private static Logger logger= LoggerFactory.getLogger(DynamicDataSourceHolder.class);
    /**
     * 使用ThreadLocal保存数据源的key
     */
    public static final String MASTER_DB="master";
    public static final String SLAVE_DB="slave";
    private static ThreadLocal<String> threadLocal=new ThreadLocal<String>();
    public static String getDbType(){
        //返回当前线程的唯一的序列
        String db=threadLocal.get();
        if (db==null){
            db=MASTER_DB;
        }
        return db;
    }

    /**
     * 设置线程的数据源
     * @param dbType
     */
    public static void setDbType(String dbType){
        logger.debug("所使用的数据源为"+dbType);
        threadLocal.set(dbType);
    }
    /**
     * 清洗数据源
     */
    public static void cleanDbType(){
        threadLocal.remove();
    }
}
