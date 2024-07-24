package com.example.amdocsapp.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

// factory which creates objects/address boxes
@Module
public class SharedPrefModule {

    Context mContext;

    public SharedPrefModule(Context context){
        mContext = context;
    }

    Context provideContext(){
        return  mContext;
    }

    @Singleton
    @Provides   //patrick provides sharedprefs object
    SharedPreferences provideSharedPrefs(){
        return PreferenceManager.getDefaultSharedPreferences(mContext);
    }
}