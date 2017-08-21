package com.mfec.homework01;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

/**
 * Created by E5-473G on 8/21/2017.
 */

public class SharedPrefUtil {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private String PREF_NAME = "prefSaveName";
    private int PREF_MODE = Context.MODE_PRIVATE;
    private Context mContext;
    private String NAME = "name";
    private String NUM_ONPAUSE_ACT = "numOnPauseAct";
    private String NUM_ONPAUSE_FRAG = "numOnPauseFrag";

    public SharedPrefUtil(Context mContext) {
        this.mContext = mContext;
        this.sharedPreferences = mContext.getSharedPreferences(PREF_NAME, PREF_MODE);
        this.editor = sharedPreferences.edit();
    }

    public void saveName(String name) {
        if (sharedPreferences.contains(NAME)) {
            editor.remove(NAME);
        }
        editor.putString(NAME, name);
        editor.putBoolean("isInit", true);
        editor.commit();
        Toast.makeText(mContext, "Save !", Toast.LENGTH_SHORT).show();
    }

    public void saveOnPauseAct(int num){
        editor.putInt(NUM_ONPAUSE_ACT, num);
        editor.commit();
    }

    public void saveOnPauseFrag(int num){
        editor.putInt(NUM_ONPAUSE_FRAG, num);
        editor.commit();
    }

    public int getNumOnPauseAct(){
        return  sharedPreferences.getInt(NUM_ONPAUSE_ACT, 0);
    }

    public int getNumOnPauseFrag(){
        return  sharedPreferences.getInt(NUM_ONPAUSE_FRAG, 0);
    }

    public String getName() {
        return sharedPreferences.getString(NAME, "");
    }

    public boolean getInit(){
        return sharedPreferences.getBoolean("isInit",false);
    }

    public void clearSharedPref() {
        editor.clear();
        editor.commit();
    }
}
