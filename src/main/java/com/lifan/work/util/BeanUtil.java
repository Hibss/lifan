package com.lifan.work.util;

import org.dozer.DozerBeanMapper;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/7/13 14:22
 */
public class BeanUtil {
    /**
     * 持有Dozer单例, 避免重复创建DozerMapper消耗资源.
     */
    private static DozerBeanMapper dozer = new DozerBeanMapper();

    /**
     * 基于Dozer转换对象的类型.
     */
    public static <T> T map(Object source, Class<T> destinationClass)
    {
        if (source == null)
        {
            return null;
        }
        return dozer.map(source, destinationClass);
    }
}
