package com.pince.demo

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.pince.architecture.R
import com.pince.demo.viewmodel.testmodule.TestViewModel


class MainActivity : AppCompatActivity() {

    private var mModel: TestViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the ViewModel.
        mModel = ViewModelProviders.of(this).get(TestViewModel::class.java)

        //如果用kotlin，则这样调用控制错误和数据为空;如果用java,则使用ViewModelUtil中的static方法
        mModel?.observeDataError(this, Observer<String> { Toast.makeText(this, it, Toast.LENGTH_LONG).show() });
        mModel?.observeDataEmpty(this, Observer<Boolean> { Toast.makeText(this, "".plus(it), Toast.LENGTH_LONG).show() });

        // Create the observer which updates the UI.
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        mModel!!.testModel.observe(this, Observer { testModel ->
            // Update the UI, in this case, a TextView.
            (findViewById<View>(R.id.tv) as TextView).text = testModel!!.weatherinfo.city
        })
    }
}
