package com.binzee.observer.observer;

/**
 * 被观察者功能承担者
 *
 * 数据上游
 * @author 狐彻
 * 2020/10/23 8:24
 */
public interface ObservableInterface<T> {

    /**
     * 设置下游
     *
     * @author 狐彻 2020/10/23 8:26
     */
    void setObserver(Observer<T> observer);
}
