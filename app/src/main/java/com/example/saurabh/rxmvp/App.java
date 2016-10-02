package com.example.saurabh.rxmvp;

import android.app.Application;

import com.example.saurabh.rxmvp.data.component.DaggerNetComponent;
import com.example.saurabh.rxmvp.data.component.NetComponent;
import com.example.saurabh.rxmvp.data.module.AppModule;
import com.example.saurabh.rxmvp.data.module.NetModule;

/**
 * Created by saurabh on 2/10/16.
 */

public class App extends Application {
    private NetComponent netComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        netComponent= DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://jsonplaceholder.typicode.com/"))
                .build();
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }
}
