package com.binzee.observer.observer;

import androidx.annotation.NonNull;

import com.binzee.observer.observer.interfaces.Transformer;
import com.binzee.observer.observer.operate.MapObservable;

/**
 * 被观察者
 *
 * 数据上游
 * @author 狐彻
 * 2020/10/23 8:21
 */
public class Observable<T> {
    // 上游
    // @author 狐彻 2020/10/23 8:38
    @NonNull
    private final ObservableInterface<T> upstream;
    private Observable(@NonNull ObservableInterface<T> upstream) {
        this.upstream = upstream;
    }

    /**
     * 静态创造
     * 
     * @author 狐彻 2020/10/23 8:38
     */
    public static <T> Observable<T> create(ObservableInterface<T> upstream) {
        return new Observable<>(upstream);
    }

    /**
     * 设置下游
     *
     * @author 狐彻 2020/10/23 8:38
     */
    public void setObserver(Observer<T> downStream) {
        upstream.setObserver(downStream);
        downStream.onSubscribe();
    }

    public <R> Observable<R> map(Transformer transformer) {
        return Observable.create(new MapObservable<T, R>(upstream, transformer));
    }

    ///////////////////////////////////////////////////////////////////////////
    // 内部类
    ///////////////////////////////////////////////////////////////////////////


}
