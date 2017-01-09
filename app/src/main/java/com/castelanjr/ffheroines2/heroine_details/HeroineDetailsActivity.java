package com.castelanjr.ffheroines2.heroine_details;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.castelanjr.ffheroines2.FFHApplication;
import com.castelanjr.ffheroines2.R;
import com.castelanjr.ffheroines2.base.BaseActivity;
import com.castelanjr.ffheroines2.base.BasePresenter;
import com.castelanjr.ffheroines2.data.model.Heroine;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HeroineDetailsActivity extends BaseActivity implements HeroineDetailsView {

    private static final String EXTRA_HEROINE = "heroine";

    public static void showDetails(Activity activity, ImageView avatar, Heroine heroine) {
        Intent intent = new Intent(activity, HeroineDetailsActivity.class)
                .putExtra(EXTRA_HEROINE, heroine);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && avatar != null) {
            ActivityOptionsCompat options = ActivityOptionsCompat
                    .makeSceneTransitionAnimation(activity, avatar, "avatar");
            activity.startActivity(intent, options.toBundle());
        } else {
            activity.startActivity(intent);
        }
    }

    @Inject
    HeroineDetailsPresenter presenter;

    @Inject
    Picasso picasso;

    @Bind(R.id.appbarlayout)
    AppBarLayout appBarLayout;

    @Bind(R.id.collapsingtoolbarlayout)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.text_personality)
    TextView textDescription;

    @Bind(R.id.text_ability)
    TextView textAbility;

    @Bind(R.id.text_game)
    TextView textGame;

    @Bind(R.id.image_heroine)
    ImageView imageCover;

    @Bind(R.id.image_avatar)
    ImageView imageAvatar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        FFHApplication.get(this).component().inject(this);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        presenter.takeView(this);
        presenter.loadDetails();
    }

    @Override
    public Heroine getHeroine() {
        return getIntent().getParcelableExtra(EXTRA_HEROINE);
    }

    @Override
    public void showName(String name) {
        collapsingToolbarLayout.setTitle(name);
    }

    @Override
    public void showGame(String game) {
        textGame.setText(game);
    }

    @Override
    public void showDescription(String description) {
        textDescription.setText(description);
    }

    @Override
    public void showAbility(String ability) {
        textAbility.setText(ability);
    }

    @Override
    public void showAvatar(String avatar) {
        picasso.load(avatar)
                .transform(new CircleTransformation())
                .into(imageAvatar, new Callback() {
                    @Override
                    public void onSuccess() {
                        imageAvatar.animate().alpha(1).start();
                    }

                    @Override
                    public void onError() {

                    }
                });
    }

    @Override
    public void showCover(String cover) {
        picasso.load(cover).into(imageCover);
    }

    @Override
    public BasePresenter getPresenter() {
        return presenter;
    }
}
