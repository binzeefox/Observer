package com.binzee.observer.observer.interfaces;

/**
 * 类型转换回调
 *
 * @author 狐彻
 * 2020/10/23 8:45
 */
public interface Transformer {

    /**
     * 类型转换工具
     *
     * @param <T> 来源数据类型
     * @param <R> 结果数据类型
     * @param value 传入数据
     * @author 狐彻 2020/10/23 8:46
     */
    <T, R> R transform(T value);
}
