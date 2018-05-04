package com.pince.architecture.viewmodel;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.util.Log;

public class ViewModelUtil {


    /**
     * 快捷显示error方法
     *
     * @param baseViewModel
     */
    public static void observeDataError(LifecycleOwner owner, BaseViewModel baseViewModel) {
        baseViewModel.getDataErrorObserver().observe(owner, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Log.d("TAG", "need show the error toast");
            }
        });
    }

    /**
     * 快捷显示内容为空的方法
     *
     * @param baseViewModel
     */
    public static void observeDataEmpty(BaseViewModel baseViewModel, LifecycleOwner owner) {
        observeDataEmpty(baseViewModel, owner, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                Log.d("TAG", "empty = " + aBoolean);
            }
        });
    }

    /**
     * 快捷显示内容为空的方法
     *
     * @param baseViewModel
     */
    public static void observeDataEmpty(BaseViewModel baseViewModel, LifecycleOwner owner, Observer<Boolean> observer) {
        baseViewModel.getDataEmptyObserver().observe(owner, observer);
    }

}
