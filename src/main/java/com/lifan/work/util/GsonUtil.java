package com.lifan.work.util;

import com.google.gson.Gson;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/7/13 15:26
 */
public class GsonUtil {

    private  static Gson gson = new Gson();

    public static String toJson(Object o){
        return gson.toJson(o);
    }
}
