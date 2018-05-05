package com.pince.demo

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import com.pince.architecture.BaseViewModel


//var AndroidViewModel.dataErrorObserver: MutableLiveData<String>
//    set(value) {
//        setError(value);
//    }
//    get() {
//        return MutableLiveData()
//    }
//
//var AndroidViewModel.dataEmptyObserver: MutableLiveData<Boolean>
//    set(value) {
//        this.dataEmptyObserver = value;
//    }
//    get() {
//        return MutableLiveData()
//    }


/**
 * 快捷显示error方法
 */
fun BaseViewModel.observeDataError(owner: LifecycleOwner, observer: Observer<String>) : BaseViewModel {
    dataErrorObserver.observe(owner, observer)
    return this;
}

/**
 * 快捷显示empty方法
 */
fun BaseViewModel.observeDataEmpty(owner: LifecycleOwner, observer: Observer<Boolean>): BaseViewModel {
    dataEmptyObserver.observe(owner, observer);
    return this;
}
