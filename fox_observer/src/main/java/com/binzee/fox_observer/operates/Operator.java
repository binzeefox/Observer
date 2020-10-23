package com.binzee.fox_observer.operates;

import com.binzee.fox_observer.FoxObservable;
import com.binzee.fox_observer.operates.interfaces.MapFunction;

/**
 * 操作符
 *
 * @author 狐彻
 * 2020/10/23 10:51
 */
public interface Operator<T> {

    /**
     * 数据转换
     *
     * @author 狐彻 2020/10/23 10:53
     */
    <R> FoxObservable<R> map(MapFunction<T, R> function);
}
