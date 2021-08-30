package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Adapter adapter;
    private ItemTouchHelper itemTouchHelper;
    private Button btn_add;
    private ArrayList<Item> datas;
    int num = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(manager);
        datas = new ArrayList<>();
        adapter= new Adapter(datas);
        recyclerView.setAdapter(adapter);


        itemTouchHelper = new ItemTouchHelper(new ItemTouchHelperCallback(adapter));

        itemTouchHelper.attachToRecyclerView(recyclerView);

        btn_add = findViewById(R.id.btn_add);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num+=1;
                Item item = new Item(Integer.toString(num));
                datas.add(item);
                adapter.notifyDataSetChanged();
            }
        });
    }
}