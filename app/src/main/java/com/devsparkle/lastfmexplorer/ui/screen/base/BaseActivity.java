package com.devsparkle.lastfmexplorer.ui.screen.base;

import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;

import com.devsparkle.lastfmexplorer.ui.screen.mvp.BaseMVPActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

public abstract class BaseActivity<V extends BaseContract.View, P extends BaseContract.Presenter<V>> extends BaseMVPActivity<V, P> implements HasAndroidInjector {

    @Inject
    DispatchingAndroidInjector<Object> androidInjector;

    @CallSuper
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return androidInjector;
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideSoftKeyboard();
    }

    public void hideSoftKeyboard() {
        if (getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        }
    }

    @CallSuper
    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


}
