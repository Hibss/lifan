package com.lifan.work.util;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/7/13 15:10
 */
public class StringUtil {

    public static String formatParamMsg(String message, Object... args) {
        for(int i = 0; i < args.length; ++i) {
            message = message.replace("{" + i + "}", args[i].toString());
        }
        return message;
    }

    public static void main(String[] args) {

    }
}
