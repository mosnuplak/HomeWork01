package com.mfec.homework01;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class MainFragment extends Fragment {
    TextView act;
    TextView frag;
    EditText input_string;
    SharedPrefUtil sharedPrefUtil;

    public MainFragment() {

    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
        Log.d("MildMos","onCreate:frag");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initInstances(rootView);
        Log.d("MildMos","onCreateView:frag");
        return rootView;
    }

    private void initInstances(View rootView) {
        sharedPrefUtil = new SharedPrefUtil(getContext());
        act = (TextView) rootView.findViewById(R.id.act);
        frag = (TextView) rootView.findViewById(R.id.frag);
        input_string = (EditText) rootView.findViewById(R.id.input_string);
        input_string.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    sharedPrefUtil.saveName(input_string.getText().toString());
                    return true;
                }
                return false;
            }
        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("MildMos","onAttach:frag");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("MildMos","onDetach:frag");

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("MildMos","onActivityCreated:frag");
    }

    @Override
    public void onStart() {
        super.onStart();
        act.setText(""+sharedPrefUtil.getNumOnPauseAct());
        frag.setText(""+sharedPrefUtil.getNumOnPauseFrag());
    }
}
