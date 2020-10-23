package com.binzee.fox_observer.operates;

import androidx.annotation.NonNull;

import com.binzee.fox_observer.FoxObservable;
import com.binzee.fox_observer.FoxObservableOnSubscribe;
import com.binzee.fox_observer.FoxObserver;
import com.binzee.fox_observer.operates.interfaces.MapFunction;

/**
 * 转用于操作符转换的Observable
 *
 * @param <T> 来源数据类型
 * @param <R> 结果数据类型
 * @author 狐彻
 * 2020/10/23 9:26
 */
public class MapObservableOnSubscribe<T, R> implements FoxObservableOnSubscribe<R> {
    @NonNull
    private final FoxObservable<T> source;
    @NonNull
    private final MapFunction<T, R> function;

    public MapObservableOnSubscribe(@NonNull FoxObservable<T> source, @NonNull MapFunction<T, R> function) {
        this.source = source;
        this.function = function;
    }

    @Override
    public void setObserver(FoxObserver<R> downStream) {
        source.subscribe(new MapObserver<>(downStream, function));
    }

    ///////////////////////////////////////////////////////////////////////////
    // 内部类
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 中间观察者
     *
     * @author 狐彻 2020/10/23 10:48
     */
    public static class MapObserver<T, R> implements FoxObserver<T> {
        @NonNull
        private final FoxObserver<R> downStream;
        @NonNull
        private final MapFunction<T, R> function;

        public MapObserver(@NonNull FoxObserver<R> downStream, @NonNull MapFunction<T, R> function) {
            this.downStream = downStream;
            this.function = function;
        }


        @Override
        public void onSubscribe() {
            downStream.onSubscribe();
        }

        @Override
        public void onNext(T item) {
            downStream.onNext(function.map(item));
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
