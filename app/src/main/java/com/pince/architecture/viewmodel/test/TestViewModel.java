package com.pince.architecture.viewmodel.test;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.pince.architecture.model.test.TestModel;
import com.pince.network.RetrofitManager;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * 以api网络接口中确定的功能模块进行划分，一个功能模块对应一个Service，对应一个具体的ViewModel
 */
public class TestViewModel extends ViewModel {

    public static final String TAG = "HttpLog";

    private MutableLiveData<TestModel> mTestModel;
    private TestService mTestService;

    public TestViewModel() {
        mTestModel = new MutableLiveData<TestModel>();
        mTestService = RetrofitManager.getService(TestService.class);
    }

    public MutableLiveData<TestModel> getTestModel() {
        mTestService.getTestModel()
                .subscribe(new Consumer<TestModel>() {
                    @Override
                    public void accept(TestModel dataBean) throws Exception {
                        Log.d(TAG, dataBean.toString());
                        mTestModel.setValue(dataBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, throwable.getMessage());
                    }
                });
        return mTestModel;
    }

    @Override
    protected void onCleared() {
        //debug发现该disposable已经被销毁
//        if (mTestModelDisposable != null && !mTestModelDisposable.isDisposed()) {
//            mTestModelDisposable.dispose();
//        }
//        mTestModelDisposable = null;
    }
}
