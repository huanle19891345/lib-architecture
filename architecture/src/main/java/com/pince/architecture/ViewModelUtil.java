package com.pince.architecture;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;

public class ViewModelUtil {


    /**
     * 快捷显示error方法
     *
     * @param baseViewModel
     */
    public static void observeDataError(LifecycleOwner owner, BaseViewModel baseViewModel, Observer<String> observer) {
        baseViewModel.getDataErrorObserver().observe(owner, observer);
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
