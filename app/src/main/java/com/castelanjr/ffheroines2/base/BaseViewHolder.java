package com.castelanjr.ffheroines2.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    private BaseAdapter.OnItemSelectedListener<T> listener;

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public void setListener(BaseAdapter.OnItemSelectedListener<T> listener) {
        this.listener = listener;
    }

    public BaseAdapter.OnItemSelectedListener<T> getListener() {
        return listener;
    }

    private T item;

    public void onClick() {
        listener.onItemSelected(item);
    }

    public void bindItem(T item) {
        this.item = item;
        bindTo(item);
    }

    protected abstract void bindTo(T item);

    public T getItem() {
        return item;
    }

}
