package com.pince.architecture

import android.arch.lifecycle.*
import android.util.Log
import com.pince.architecture.viewmodel.BaseViewModel

val AndroidViewModel.dataErrorObserver : MutableLiveData<String>
get() = MutableLiveData<String>()

val AndroidViewModel.dataEmptyObserver : MutableLiveData<Boolean>
get() = MutableLiveData<Boolean>()


fun AndroidViewModel.observeDataError(owner: LifecycleOwner) {
    this.dataErrorObserver.observe(owner, Observer { Log.d("TAG", "need show the error toast") })
}

fun AndroidViewModel.observeDataEmpty(owner: LifecycleOwner) {
    this.observeDataEmpty(owner, Observer {
        Log.d("TAG", "empty = " + it)
    })
}

fun AndroidViewModel.observeDataEmpty(owner: LifecycleOwner, observer: Observer<Boolean>) {
    this.dataEmptyObserver.observe(owner, observer);
}
