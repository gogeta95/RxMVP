package com.example.saurabh.rxmvp.mainscreen;

import com.example.saurabh.rxmvp.data.Post;
import com.example.saurabh.rxmvp.util.PostService;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by saurabh on 2/10/16.
 */

public class MainPresenter implements MainScreenContract.Presenter {
    Retrofit retrofit;
    MainScreenContract.View mView;
    @Override
    public void loadPost() {
        retrofit.create(PostService.class).getPostList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Post>>() {
                    @Override
                    public void onCompleted() {
                        mView.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Post> posts) {
                        mView.showPosts(posts);
                    }
                });
    }
    @Inject
    public MainPresenter(Retrofit retrofit,MainScreenContract.View view){
        this.retrofit=retrofit;
        this.mView=view;
    }
}
