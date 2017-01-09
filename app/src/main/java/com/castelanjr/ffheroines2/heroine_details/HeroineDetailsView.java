package com.castelanjr.ffheroines2.heroine_details;

import com.castelanjr.ffheroines2.data.model.Heroine;

interface HeroineDetailsView {

    Heroine getHeroine();

    void showName(String name);

    void showGame(String game);

    void showDescription(String description);

    void showAbility(String ability);

    void showAvatar(String avatar);

    void showCover(String cover);

}
