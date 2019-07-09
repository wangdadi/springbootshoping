package com.wd.springboot.springbootshoping.split;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * ClassName:DynamicDataSource
 * Package:com.wd.springboot.springbootshoping.split
 * Description:
 * 配置数据库读写分离
 * @Date:2019/6/21 0021 0:57
 * @Author:王迪
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {

        return DynamicDataSourceHolder.getDbType();
    }

}
