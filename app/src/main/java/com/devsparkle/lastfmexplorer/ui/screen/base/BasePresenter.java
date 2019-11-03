package com.devsparkle.lastfmexplorer.ui.screen.base;


import com.devsparkle.lastfmexplorer.ui.screen.mvp.BaseMVPPresenter;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class BasePresenter<V extends BaseContract.View> extends BaseMVPPresenter<V> implements BaseContract.Presenter<V> {

    private CompositeDisposable disposable = new CompositeDisposable();


    public <T> void fetch(Single<T> single, Consumer<? super T> success, Consumer<? super Throwable> error) {
        disposable.add(
                single
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(success, error)
        );
    }

    public <T> void fetch(Maybe<T> maybe, Consumer<? super T> success, Consumer<? super Throwable> error) {
        disposable.add(
                maybe
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(success, error)
        );
    }


    public <T> void fetch(Flowable<T> flowable, Consumer<? super T> success, Consumer<? super Throwable> error) {
        disposable.add(
                flowable
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(success, error)
        );
    }


    public <T> void complete(Completable completable, Action success, Consumer<? super Throwable> error) {
        disposable.add(
                completable
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(success, error)
        );
    }


    public void clear() {
        disposable.clear();
    }

    @Override
    public void onPresenterCreate() {
        super.onPresenterCreate();
    }

    @Override
    public void onPresenterDestroy() {
        clear();
    }
}
