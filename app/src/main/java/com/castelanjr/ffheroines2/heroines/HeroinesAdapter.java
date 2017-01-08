package com.castelanjr.ffheroines2.heroines;

import android.support.design.internal.ForegroundLinearLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.castelanjr.ffheroines2.R;
import com.castelanjr.ffheroines2.base.BaseAdapter;
import com.castelanjr.ffheroines2.base.BaseViewHolder;
import com.castelanjr.ffheroines2.data.model.Heroine;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

class HeroinesAdapter extends BaseAdapter<Heroine, HeroinesAdapter.Holder> {

    private final Picasso picasso;

    HeroinesAdapter(Picasso picasso, OnItemSelectedListener<Heroine> listener) {
        super(listener);
        this.picasso = picasso;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent) {
        return new Holder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_heroines, parent, false), picasso);
    }

    static class Holder extends BaseViewHolder<Heroine> {

        private final Picasso picasso;

        @Bind(R.id.layout_heroine)
        ForegroundLinearLayout layoutHeroine;

        @Bind(R.id.image_heroine)
        ImageView imageHeroine;

        @Bind(R.id.text_name)
        TextView textName;

        @OnClick(R.id.layout_heroine)
        void click() {
            onClick();
        }

        Holder(View itemView, Picasso picasso) {
            super(itemView);
            this.picasso = picasso;
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void bindTo(Heroine heroine) {
            layoutHeroine.setBackgroundColor(heroine.color());
            textName.setText(heroine.name());
            picasso.load(heroine.avatar()).into(imageHeroine);
        }
    }
}
