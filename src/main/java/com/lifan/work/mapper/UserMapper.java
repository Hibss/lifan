/*
* Copyright (c) 2017 dadeng. All rights reserved.
* Licensed under the Apache License, Version 2.0 (the "License");
*/
package com.lifan.work.mapper;

import com.lifan.work.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author dadeng, 17/3/28
 * @version 1.0, 17/3/28
 */
@Mapper
public interface UserMapper
{
    @Insert("INSERT into user(name,password) " +
            "VALUES(#{name}, #{password})")
    int insert(User user);


    @Select("select * from user where name = #{name} and password=#{password}")
    User getByName(@Param("name") String name,@Param("password") String password);
}
