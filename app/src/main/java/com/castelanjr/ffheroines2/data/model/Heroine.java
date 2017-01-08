package com.castelanjr.ffheroines2.data.model;

import android.graphics.Color;
import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;

@AutoValue
public abstract class Heroine implements Parcelable {
    public abstract long id();
    public abstract String name();
    public abstract String fullname();
    public abstract String ability();
    public abstract String avatar();
    public abstract String image();
    public abstract String description();
    @Json(name = "color") public abstract String colorStr();
    public abstract String game();
    public abstract String url();

    public static Heroine create(long id, String name, String fullname, String ability, String avatar,
                                 String image, String description, String color, String game, String url) {
        return new AutoValue_Heroine(id, name, fullname, ability, avatar, image, description, color, game, url);
    }

    public static JsonAdapter.Factory typeAdapterFactory() {
        return AutoValue_Heroine.typeAdapterFactory();
    }

    public int color() {
        return Color.parseColor(colorStr());
    }
}
