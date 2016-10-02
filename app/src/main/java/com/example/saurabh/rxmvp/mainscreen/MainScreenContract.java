package com.example.saurabh.rxmvp.mainscreen;

import com.example.saurabh.rxmvp.data.Post;

import java.util.List;

/**
 * Created by saurabh on 2/10/16.
 */

public interface MainScreenContract {
    interface View {
        void showPosts(List<Post> posts);

        void showError(String message);

        void showComplete();
    }

    interface Presenter {
        void loadPost();
    }
}
