package com.example.myapplication;

import androidx.recyclerview.widget.RecyclerView;

public interface ItemTouchHelperListener {
    boolean onItemMove(int from_position,int to_position);
    void onItemSwipe(int position);
}
