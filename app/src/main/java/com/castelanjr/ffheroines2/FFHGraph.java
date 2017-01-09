package com.castelanjr.ffheroines2;

import com.castelanjr.ffheroines2.heroine_details.HeroineDetailsActivity;
import com.castelanjr.ffheroines2.heroines.HeroinesActivity;

interface FFHGraph {
    void inject(FFHApplication application);
    void inject(HeroinesActivity activity);
    void inject(HeroineDetailsActivity activity);
}
