package com.example.saurabh.rxmvp.mainscreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.saurabh.rxmvp.App;
import com.example.saurabh.rxmvp.R;
import com.example.saurabh.rxmvp.data.Post;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainScreenContract.View {


    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerMainScreenComponent.builder()
                .netComponent(((App) getApplicationContext()).getNetComponent())
                .mainScreenModule(new MainScreenModule(this))
                .build().inject(this);
        presenter.loadPost();
    }


    @Override
    public void showPosts(List<Post> posts) {
        Toast.makeText(this, "LisT: "+posts, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComplete() {
        Toast.makeText(this, "Complete", Toast.LENGTH_SHORT).show();
    }
}
