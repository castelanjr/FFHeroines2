package com.castelanjr.ffheroines2.heroines;

import android.view.View;
import android.view.ViewGroup;

import com.castelanjr.ffheroines2.base.BaseAdapter;
import com.castelanjr.ffheroines2.base.BaseViewHolder;
import com.castelanjr.ffheroines2.data.model.Heroine;

public class HeroinesAdapter extends BaseAdapter<Heroine, HeroinesAdapter.Holder> {

    public HeroinesAdapter(OnItemSelectedListener<Heroine> listener) {
        super(listener);
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent) {
        return null;
    }

    static class Holder extends BaseViewHolder<Heroine> {
        public Holder(View itemView) {
            super(itemView);
        }

        @Override
        protected void bindTo(Heroine item) {

        }
    }
}
