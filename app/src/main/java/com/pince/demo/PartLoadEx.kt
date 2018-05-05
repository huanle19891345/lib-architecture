package com.pince.demo

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import com.pince.architecture.PartLoadLiveData


interface PartLoadCallBack {

    /**
     * 接口数据请求到最后end
     */
    fun loadMoreEnd();

    /**
     * 接口请求正常完成，请求到了指定size的数据
     */
    fun loadComplete();
}

fun <T> PartLoadLiveData<List<T>>.observePartLoad(lifecycleOwner: LifecycleOwner, observer: Observer<List<T>>,
       pageSize: Int, partLoadCallBack: PartLoadCallBack) {

    observe(lifecycleOwner, Observer {
        observer.onChanged(it);
        if (it!!.size < pageSize) {
            partLoadCallBack.loadMoreEnd();
        } else{
            partLoadCallBack.loadComplete()
            pageNum++;
        }
    });
}