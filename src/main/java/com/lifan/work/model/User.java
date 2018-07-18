package com.lifan.work.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/7/17 14:22
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    protected Long id;
    protected String name;
    protected String password;
}
