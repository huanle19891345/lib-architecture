package com.pince.architecture.viewmodel.test

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log

import com.pince.architecture.model.test.TestModel
import com.pince.architecture.viewmodel.BaseViewModel
import com.pince.network.RetrofitManager

import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import com.pince.architecture.*


/**
 * 以api网络接口中确定的功能模块进行划分，一个功能模块对应一个Service，对应一个具体的ViewModel
 */
class TestViewModel(application: Application) : AndroidViewModel(application) {

    private val mTestModel: MutableLiveData<TestModel>
    private val mTestService: TestService

    val testModel: MutableLiveData<TestModel>
        get() {
            mTestService.testModel
                    .subscribe({ dataBean ->
                        Log.d(TAG, dataBean.toString())
                        mTestModel.value = dataBean
                        dataEmptyObserver.value = true;
                    }) { throwable ->
                        Log.d(TAG, throwable.message)
                        dataErrorObserver.value = throwable.message
                    }
            return mTestModel
        }

    init {
        mTestModel = MutableLiveData()
        mTestService = RetrofitManager.getService(TestService::class.java)
    }

    override fun onCleared() {
        //debug发现该disposable已经被销毁
        //        if (mTestModelDisposable != null && !mTestModelDisposable.isDisposed()) {
        //            mTestModelDisposable.dispose();
        //        }
        //        mTestModelDisposable = null;
    }

    companion object {
        val TAG = "HttpLog"
    }
}
