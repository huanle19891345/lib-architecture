package com.pince.architecture

import android.arch.lifecycle.MutableLiveData

class PartLoadLiveData<T>: MutableLiveData<T>() {
    var pageNum: Int = 1;
}