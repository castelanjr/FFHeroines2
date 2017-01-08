package com.castelanjr.ffheroines2.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    private BaseAdapter.OnItemSelectedListener<T> listener;

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    void setListener(BaseAdapter.OnItemSelectedListener<T> listener) {
        this.listener = listener;
    }

    private T item;

    protected void onClick() {
        listener.onItemSelected(item);
    }

    void bindItem(T item) {
        this.item = item;
        bindTo(item);
    }

    protected abstract void bindTo(T item);

    public T getItem() {
        return item;
    }

}
