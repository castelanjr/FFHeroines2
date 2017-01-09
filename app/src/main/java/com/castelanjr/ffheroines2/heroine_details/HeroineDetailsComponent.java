package com.castelanjr.ffheroines2.heroine_details;

import com.castelanjr.ffheroines2.util.ActivityScope;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = HeroineDetailsModule.class)
public interface HeroineDetailsComponent {
    void inject(HeroineDetailsActivity activity);
}
