package com.binzee.fox_observer;

/**
 * 观察者
 *
 * 数据上游
 * @param <T> 返回数据类型
 * @author 狐彻
 * 2020/10/23 9:11
 */
public interface FoxObserver<T> {
    void onSubscribe();
    void onNext(T item);
    void onError(Throwable e);
    void onComplete();
}