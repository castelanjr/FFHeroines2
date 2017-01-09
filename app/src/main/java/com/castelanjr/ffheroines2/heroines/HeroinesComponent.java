package com.castelanjr.ffheroines2.heroines;

import com.castelanjr.ffheroines2.util.ActivityScope;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = HeroinesModule.class)
public interface HeroinesComponent {
    void inject(HeroinesActivity activity);
}
