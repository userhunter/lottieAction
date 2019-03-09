package com.example.lottie.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * autour: bobbylu
 * date: 2019/3/9 on 16:29
 */
public class SharedPreferencesUtils {

    public static  final  String  PreferencesName = "content";

    public static String  KEY_ADD = "add";
    public static String  KEY_STATUS = "status";
    public static String  KEY_VALUE = "value";


    public static void setAddStatus(Context context,int value){

        SharedPreferences sharedPreferences = context.getSharedPreferences(PreferencesName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_ADD,value);
        editor.commit();
    }

    public static int getAddStatus(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PreferencesName,Context.MODE_PRIVATE);
        return  sharedPreferences.getInt(KEY_ADD,0);
    }

    public static void setStatus(Context context,boolean value){

        SharedPreferences sharedPreferences = context.getSharedPreferences(PreferencesName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(KEY_STATUS,value);
        editor.commit();
    }

    public static boolean getStatus(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PreferencesName,Context.MODE_PRIVATE);
        return  sharedPreferences.getBoolean(KEY_STATUS,false);
    }

    public static void setValue(Context context,String value){

        SharedPreferences sharedPreferences = context.getSharedPreferences(PreferencesName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_VALUE,value);
        editor.commit();
    }

    public static String getValue(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PreferencesName,Context.MODE_PRIVATE);
        return  sharedPreferences.getString(KEY_VALUE,"no");
    }



}
