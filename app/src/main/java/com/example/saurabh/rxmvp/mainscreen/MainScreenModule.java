package com.example.saurabh.rxmvp.mainscreen;

import dagger.Module;
import dagger.Provides;

/**
 * Created by saurabh on 2/10/16.
 */
@Module
public class MainScreenModule {
    private final MainScreenContract.View mView;


    public MainScreenModule(MainScreenContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @CustomScope
    MainScreenContract.View providesMainScreenContractView() {
        return mView;
    }
}
