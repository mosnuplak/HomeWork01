package com.mfec.homework01;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class TwoFragment extends Fragment {

    SharedPrefUtil sharedPrefUtil;
    TextView show_string;
    EditText input_string;
    public TwoFragment() {

    }

    public static TwoFragment newInstance() {
        TwoFragment fragment = new TwoFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_two, container, false);
        initInstances(rootView);
        Log.d("MildMos","onCreateView:frag");
        return rootView;
    }

    private void initInstances(View rootView) {
        sharedPrefUtil = new SharedPrefUtil(getContext());
        show_string = (TextView) rootView.findViewById(R.id.show_string);
        input_string = (EditText) rootView.findViewById(R.id.input_string);
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
        show_string.setText(sharedPrefUtil.getName()+"");
    }

    @Override
    public void onResume() {
        super.onResume();
        input_string.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    sharedPrefUtil.saveName(input_string.getText().toString());
                    show_string.setText(sharedPrefUtil.getName()+"");
                    return true;
                }
                return false;
            }
        });

    }

    @Override
    public void onPause() {
        super.onPause();
        int num = sharedPrefUtil.getNumOnPauseFrag();
        num++;
        sharedPrefUtil.saveOnPauseFrag(num);
        sharedPrefUtil.saveOnPauseFrag(num);
    }
}
