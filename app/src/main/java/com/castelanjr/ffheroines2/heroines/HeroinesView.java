package com.castelanjr.ffheroines2.heroines;

import com.castelanjr.ffheroines2.data.model.Heroine;

import java.util.List;

interface HeroinesView {

    void showProgressIndicator(boolean active);

    void showError(String message);

    void showHeroines(List<Heroine> heroines);

    void showHeroineDetails(Heroine heroine);

}
