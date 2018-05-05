package com.pince.demo.viewmodel.testmodule;

import com.pince.demo.model.testmodule.TestModel;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 以业务功能进行区分，比如用户模块，行情模块等等，都拥有自己的Service接口
 */
public interface TestService {

    @GET("data/sk/101010100.html")
    Observable<TestModel> getTestModel();

}
