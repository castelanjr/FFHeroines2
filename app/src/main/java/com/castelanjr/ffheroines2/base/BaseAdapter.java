package com.castelanjr.ffheroines2.base;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

public abstract class BaseAdapter<T, VH extends BaseViewHolder<T>> extends RecyclerView.Adapter<VH> {

    private List<T> data = Collections.emptyList();
    private OnItemSelectedListener<T> listener;

    public BaseAdapter(OnItemSelectedListener<T> listener) {
        this.listener = listener;
    }

    public void setData(List<T> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void addData(T item) {
        data.add(item);
        notifyItemInserted(getItemCount());
    }

    public void addData(T item, int position) {
        data.add(position, item);
        notifyItemInserted(position);
    }

    public void removeData(int pos) {
        data.remove(pos);
        notifyItemRemoved(pos);
    }

    public int indexOf(T item) {
        return data.indexOf(item);
    }

    protected List<T> getData() {
        return data;
    }

    protected T getItem(int position) {
        return data.get(position);
    }

    public void setListener(OnItemSelectedListener<T> listener) {
        this.listener = listener;
    }

    /**
     *
    * Only override this method if you need the viewType funcionalities.
     * Otherwise, use #onCreateViewHolder
     *
     **/
    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        VH holder = onCreateViewHolder(parent);
        holder.setListener(listener);
        return holder;
    }

    public abstract VH onCreateViewHolder(ViewGroup parent);

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.bindItem(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface OnItemSelectedListener<T> {
        void onItemSelected(T item);
    }
}
