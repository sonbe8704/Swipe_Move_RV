package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ItemViewHolder> implements ItemTouchHelperListener {
    private ArrayList<Item> datas = new ArrayList<>();

    public Adapter(ArrayList<Item> datas) {
        this.datas =datas;
    }

    @NonNull
    @Override
    public Adapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_list,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ItemViewHolder holder, int position) {
        holder.tv_title.setText(datas.get(position).toString());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return datas !=null?datas.size():0;
    }

    @Override
    public boolean onItemMove(int from_position, int to_position) {
        Item item = datas.get(from_position);
        datas.remove(from_position);
        datas.add(to_position,item);
        notifyItemMoved(from_position,to_position);
        return true;
    }

    @Override
    public void onItemSwipe(int position) {
        datas.remove(position);
        notifyItemRemoved(position);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        protected TextView tv_title;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_title = itemView.findViewById(R.id.tv_title);
        }
    }
}
