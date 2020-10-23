package com.binzee.fox_observer.operates.interfaces;

/**
 * 类型转换
 *
 * @param <T> 来源数据类型
 * @param <R> 结果数据类型
 * @author 狐彻
 * 2020/10/23 9:24
 */
public interface MapFunction<T, R> {

    /**
     * 处理
     *
     * @author 狐彻 2020/10/23 9:25
     */
    R map(T item);
}
