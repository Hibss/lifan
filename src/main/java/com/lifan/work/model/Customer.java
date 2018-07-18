package com.lifan.work.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/7/13 11:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    protected Long id;
    protected String code;
    protected String name;
    protected String mobile;
    protected String address;
    protected Date ctime;
    protected Short sex;
    protected Integer orderCount;
    protected Date lastOrderTime;
}
