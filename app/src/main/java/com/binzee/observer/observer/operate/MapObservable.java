package com.binzee.observer.observer.operate;

import androidx.annotation.NonNull;

import com.binzee.observer.observer.Observable;
import com.binzee.observer.observer.ObservableInterface;
import com.binzee.observer.observer.Observer;
import com.binzee.observer.observer.interfaces.Transformer;

/**
 * 转换用Observable
 *
 * @author 狐彻 2020/10/23 8:50
 */
public class MapObservable<T, R> implements ObservableInterface<R> {
    @NonNull
    private final ObservableInterface<T> upstream;
    @NonNull
    private final Transformer transformer;

    /**
     * 构造器
     *
     * @author 狐彻 2020/10/23 8:53
     */
    public MapObservable(@NonNull ObservableInterface<T> upstream, @NonNull Transformer transformer) {
        this.upstream = upstream;
        this.transformer = transformer;
    }

    @Override
    public void setObserver(Observer<R> observer) {
//        upstream.onSubscribe();
        Observable.create(upstream)
                .setObserver(new MapObserver<>(observer, transformer));
    }

    ///////////////////////////////////////////////////////////////////////////
    // 内部类
    ///////////////////////////////////////////////////////////////////////////

    private static class MapObserver<T, R> implements Observer<T> {
        @NonNull
        private final Observer<R> downStream;
        @NonNull
        private final Transformer transformer;

        public MapObserver(@NonNull Observer<R> downStream, @NonNull Transformer transformer) {
            this.downStream = downStream;
            this.transformer = transformer;
        }

        @Override
        public void onSubscribe() {
            downStream.onSubscribe();
        }

        @Override
        public void onNext(T item) {
            R value = transformer.transform(item);
            downStream.onNext(value);
        }

        @Override
        public void onError(Throwable e) {
            downStream.onError(e);
        }

        @Override
        public void onComplete() {
            downStream.onComplete();
        }
    }
}