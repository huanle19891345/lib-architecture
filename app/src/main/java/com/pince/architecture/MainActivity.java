package com.pince.architecture;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.arch.lifecycle.ViewModelProviders;
import android.widget.TextView;

import com.pince.architecture.model.test.TestModel;
import com.pince.architecture.viewmodel.test.TestViewModel;


public class MainActivity extends AppCompatActivity {

    private TestViewModel mModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the ViewModel.
        mModel = ViewModelProviders.of(this).get(TestViewModel.class);

        // Create the observer which updates the UI.
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        mModel.getTestModel().observe(this, new Observer<TestModel>() {
            @Override
            public void onChanged(@Nullable final TestModel testModel) {
                // Update the UI, in this case, a TextView.
                ((TextView)findViewById(R.id.tv)).setText(testModel.getWeatherinfo().getCity());
            }
        });
    }
}
