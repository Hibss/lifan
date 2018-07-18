package com.lifan.work.model.vo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/7/13 14:19
 */
@Data
@Builder
public class CustomerVO {
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
