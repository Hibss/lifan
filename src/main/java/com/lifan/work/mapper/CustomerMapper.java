/*
* Copyright (c) 2017 dadeng. All rights reserved.
* Licensed under the Apache License, Version 2.0 (the "License");
*/
package com.lifan.work.mapper;

import com.lifan.work.model.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author dadeng, 17/3/28
 * @version 1.0, 17/3/28
 */
@Mapper
public interface CustomerMapper
{
    @Insert("INSERT into customer(name,mobile,address,code,ctime,sex,order_count,last_order_time) " +
            "VALUES(#{name}, #{mobile},#{address},#{code},#{ctime},#{sex},#{orderCount},#{lastOrderTime})")
    int insert(Customer customer);
    /**
     * @return
     */
    @Select("select * from customer")
    List<Customer> getPageList();

    @Select("select * from customer where id = #{id}")
    Customer getById(@Param("id") Long id);
}
