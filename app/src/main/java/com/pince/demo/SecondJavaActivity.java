package com.pince.demo;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.pince.architecture.R;
import com.pince.architecture.ViewModelUtil;
import com.pince.demo.model.testmodule.TestModel;
import com.pince.demo.viewmodel.testmodule.TestViewModel;

public class SecondJavaActivity extends AppCompatActivity {

    private TestViewModel testViewModel;

   @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        testViewModel = ViewModelProviders.of(this).get(TestViewModel.class);

       ViewModelUtil.observeDataError(testViewModel, this, new Observer<String>() {
           @Override
           public void onChanged(@Nullable String s) {
               Toast.makeText(SecondJavaActivity.this, s, Toast.LENGTH_LONG).show();
           }
       });
       ViewModelUtil.observeDataEmpty(testViewModel, this, new Observer<Boolean>() {
           @Override
           public void onChanged(@Nullable Boolean aBoolean) {
               Toast.makeText(SecondJavaActivity.this, aBoolean + "", Toast.LENGTH_LONG).show();
           }
       });
       testViewModel.getTestModel().observe(this, new Observer<TestModel>() {
           @Override
           public void onChanged(@Nullable TestModel testModel) {
               ((TextView)findViewById(R.id.tv)).setText(testModel.getWeatherinfo().getCity());
           }
       });
    }
}
