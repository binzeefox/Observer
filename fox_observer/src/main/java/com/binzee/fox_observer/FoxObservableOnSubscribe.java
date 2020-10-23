package com.binzee.fox_observer;

import androidx.annotation.RestrictTo;

/**
 * 真正功能的被观察者
 *
 * 数据下游
 * @param <T> 处理的数据类型
 * @author 狐彻
 * 2020/10/23 9:12
 */
public interface FoxObservableOnSubscribe<T> {

    /**
     * 设置下游
     *
     * @author 狐彻 2020/10/23 9:19
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP_PREFIX)
    void setObserver(FoxObserver<T> downStream);
}
