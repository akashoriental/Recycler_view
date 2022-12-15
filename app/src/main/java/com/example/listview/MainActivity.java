package com.example.listview;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ClickListener {
    RecyclerView listView;
    String arr[] = {"Humko", "Kl ki", "Fikar", "Stati", "Vo bs aaj", "Ki masti mei", "jita tha wo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.ListView);
        // USING BUILT-IN ARRAY ADAPTER
  //
        //
        //    ArrayAdapter aad=new ArrayAdapter(this, androidx.constraintlayout.widget.R.layout.select_dialog_multichoice_material,arr);
//        listView.setAdapter(aad);
        // USING CUSTOM ARRAY ADAPTER
        AkashAdapter ag = new AkashAdapter(this, arr);
      //  listView.setOnItemClickListener(messageClickedHandler);
        listView.setAdapter(ag);
        listView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        /*ag.returnOnClickListener(index -> {

        });*/
    }

    @Override
    public void onItemClick(int index) {
        Log.d(TAG, "onItemClick: clickPosition "+ index);
    }

//    private final AdapterView.OnItemClickListener messageClickedHandler = (parent, v, position, id) -> {
//         Display a messagebox.
//        Toast.makeText(MainActivity.this, "You've got an event " + parent + " " + v + " " + position + " " + id, Toast.LENGTH_SHORT).show();
//        Log.e(TAG,"You've got an event " + parent + " " + v + " " + position + " " + id);
//    };
}