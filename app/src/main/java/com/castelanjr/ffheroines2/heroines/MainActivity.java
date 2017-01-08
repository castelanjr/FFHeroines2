package com.castelanjr.ffheroines2.heroines;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.castelanjr.ffheroines2.FFHApplication;
import com.castelanjr.ffheroines2.R;
import com.castelanjr.ffheroines2.base.BaseActivity;
import com.castelanjr.ffheroines2.data.model.Heroine;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements HeroinesView {

    @Inject HeroinesPresenter presenter;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.grid)
    RecyclerView grid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FFHApplication.get(this).getComponent().inject(this);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        getPresenter().takeView(this);
        getPresenter().loadHeroines();
    }

    @Override
    public HeroinesPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void showProgressIndicator(boolean active) {

    }

    @Override
    public void showError(String message) {
        Snackbar.make(grid, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showHeroines(List<Heroine> heroines) {

    }

    @Override
    public void showHeroineDetails(Heroine heroine) {

    }
}
