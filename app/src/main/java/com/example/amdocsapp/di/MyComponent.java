package com.example.amdocsapp.di;

import com.example.amdocsapp.DiActivity;

import dagger.Component;

//middle man -- realestate guy
@Component(modules = SharedPrefModule.class)
public interface MyComponent {

    void inject(DiActivity activity);

}