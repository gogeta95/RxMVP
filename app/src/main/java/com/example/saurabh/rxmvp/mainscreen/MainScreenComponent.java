package com.example.saurabh.rxmvp.mainscreen;

import com.example.saurabh.rxmvp.data.component.NetComponent;

import dagger.Component;

/**
 * Created by saurabh on 2/10/16.
 */
@CustomScope
@Component(dependencies = NetComponent.class,modules = MainScreenModule.class)
public interface MainScreenComponent {
    void inject(MainActivity activity);
}
