package com.binzee.observer.observer;

/**
 * 观察者
 *
 * 数据下游
 * @param <T> 处理的数据类型
 * @author 狐彻
 * 2020/10/23 8:22
 */
public interface Observer<T> {
    void onSubscribe();
    void onNext(T item);
    void onError(Throwable e);
    void onComplete();
}
