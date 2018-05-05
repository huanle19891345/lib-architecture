package com.pince.architecture;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

/**
 * 拓展dataError和dataEmpty两个字段
 */
public class BaseViewModel extends AndroidViewModel{

    protected MutableLiveData<String> dataErrorObserver;

    protected MutableLiveData<Boolean> dataEmptyObserver;

    public BaseViewModel(@NonNull Application application) {
        super(application);

        dataEmptyObserver = new MutableLiveData<>();
        dataErrorObserver = new MutableLiveData<>();
    }

    public MutableLiveData<String> getDataErrorObserver() {
        return dataErrorObserver;
    }

    public MutableLiveData<Boolean> getDataEmptyObserver() {
        return dataEmptyObserver;
    }
}
