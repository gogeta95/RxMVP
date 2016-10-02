package com.example.saurabh.rxmvp.data.component;

import com.example.saurabh.rxmvp.data.module.AppModule;
import com.example.saurabh.rxmvp.data.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by saurabh on 2/10/16.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    // downstream components need these exposed with the return type
    // method name does not really matter
    Retrofit retrofit();
}
