package com.binzee.fox_observer;

import com.binzee.fox_observer.operates.Operator;
import com.binzee.fox_observer.operates.interfaces.MapFunction;
import com.binzee.fox_observer.operates.MapObservableOnSubscribe;
import com.sun.istack.internal.NotNull;


/**
 * 被观察者装饰类
 *
 * @param <T> 处理的数据类型
 * @author 狐彻
 * 2020/10/23 9:16
 */
public class FoxObservable<T> implements Operator<T> {

    //上游被观察者
    @NotNull final FoxObservableOnSubscribe<T> upstream;

    /**
     * 私有化实例
     *
     * @param upstream 提供上游
     * @author 狐彻 2020/10/23 9:20
     */
    FoxObservable(FoxObservableOnSubscribe<T> upstream) {
        this.upstream = upstream;
    }

    /**
     * 订阅
     *
     * @author 狐彻 2020/10/23 9:46
     */
    public void subscribe(FoxObserver<T> downStream) {
        upstream.setObserver(downStream);
    }

    ///////////////////////////////////////////////////////////////////////////
    // 静态构造方法
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 静态构造
     *
     * @author 狐彻 2020/10/23 9:21
     */
    public static <T> FoxObservable<T> create(FoxObservableOnSubscribe<T> upstream) {
        return new FoxObservable<>(upstream);
    }

    ///////////////////////////////////////////////////////////////////////////
    // 操作符
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Map操作符
     *
     * @author 狐彻 2020/10/23 9:51
     */
    @Override
    public <R> FoxObservable<R> map(MapFunction<T, R> function) {
        return new FoxObservable<>(new MapObservableOnSubscribe<>(this, function));
    }
}
