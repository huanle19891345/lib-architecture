package com.pince.architecture

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.arch.lifecycle.ViewModelProviders
import android.view.View
import android.widget.TextView

import com.pince.architecture.model.test.TestModel
import com.pince.architecture.viewmodel.test.TestViewModel

import com.pince.architecture.*


class MainActivity : AppCompatActivity() {

    private var mModel: TestViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the ViewModel.
        mModel = ViewModelProviders.of(this).get(TestViewModel::class.java)

        mModel?.observeDataError(this);
        mModel?.observeDataEmpty(this);

        // Create the observer which updates the UI.
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        mModel!!.testModel.observe(this, Observer { testModel ->
            // Update the UI, in this case, a TextView.
            (findViewById<View>(R.id.tv) as TextView).text = testModel!!.weatherinfo.city
        })
    }
}
