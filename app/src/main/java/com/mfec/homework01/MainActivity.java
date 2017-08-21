package com.mfec.homework01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    SharedPrefUtil sharedPrefUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentMain,MainFragment.newInstance())
                    .commit();
        }
        Log.d("MildMos","onCreate:act1");
    }

    public void onBtnNextClick(View view){
        Intent intent = new Intent(this,TwoActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MildMos","onStart:act1");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MildMos","onResume:act1");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MildMos","onPause:act1");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MildMos","onStop:act1");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MildMos","onDestroy:act1");
    }
}
