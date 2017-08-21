package com.mfec.homework01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by E5-473G on 8/21/2017.
 */

public class TwoActivity extends AppCompatActivity {
    SharedPrefUtil sharedPrefUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentTwo,TwoFragment.newInstance())
                    .commit();
        }
        sharedPrefUtil = new SharedPrefUtil(this);
        Log.d("MildMos","onCreate:act2");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MildMos","onStart:act2");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MildMos","onResume:act2");
    }

    @Override
    protected void onPause() {
        super.onPause();
        int num = sharedPrefUtil.getNumOnPauseAct();
        num++;
        sharedPrefUtil.saveOnPauseAct(num);
        Log.d("MildMos","onPause:act2"+num);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MildMos","onStop:act2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MildMos","onDestroy:act2");
    }
}
