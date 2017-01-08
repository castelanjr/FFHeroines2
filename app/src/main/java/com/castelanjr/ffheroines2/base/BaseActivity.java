package com.castelanjr.ffheroines2.base;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

public abstract class BaseActivity extends RxAppCompatActivity {

    public abstract BasePresenter getPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getPresenter().dropView();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
