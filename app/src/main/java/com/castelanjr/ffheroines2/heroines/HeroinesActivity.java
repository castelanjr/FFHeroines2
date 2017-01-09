package com.castelanjr.ffheroines2.heroines;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.castelanjr.ffheroines2.FFHApplication;
import com.castelanjr.ffheroines2.R;
import com.castelanjr.ffheroines2.base.BaseActivity;
import com.castelanjr.ffheroines2.data.model.Heroine;
import com.castelanjr.ffheroines2.heroine_details.HeroineDetailsActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HeroinesActivity extends BaseActivity implements HeroinesView {

    @Inject
    HeroinesPresenter presenter;

    @Inject
    Picasso picasso;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.progress)
    ProgressBar progress;

    @Bind(R.id.recyclerview)
    RecyclerView recyclerView;

    private HeroinesAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FFHApplication.get(this).component().plus(new HeroinesModule(this)).inject(this);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        adapter = new HeroinesAdapter(picasso, presenter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        presenter.loadHeroines();
    }

    @Override
    public void showProgressIndicator(boolean active) {
        if (active) {
            progress.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.INVISIBLE);
        } else {
            progress.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showError(String message) {
        Snackbar.make(recyclerView, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showHeroines(List<Heroine> heroines) {
        adapter.setData(heroines);
    }

    @Override
    public void showHeroineDetails(Heroine heroine) {
        ImageView avatar = ButterKnife.findById(recyclerView
                .findViewHolderForAdapterPosition(adapter.indexOf(heroine)).itemView,
                R.id.image_heroine);
        HeroineDetailsActivity.showDetails(this, avatar, heroine);
    }

    @Override
    public HeroinesPresenter getPresenter() {
        return presenter;
    }
}
