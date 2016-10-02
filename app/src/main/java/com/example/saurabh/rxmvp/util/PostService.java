package com.example.saurabh.rxmvp.util;

import com.example.saurabh.rxmvp.data.Post;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by saurabh on 2/10/16.
 */

public interface PostService {
    @GET("/posts")
    Observable<List<Post>> getPostList();
}
