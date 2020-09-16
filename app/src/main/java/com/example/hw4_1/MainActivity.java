package com.example.hw4_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
    public List<Title> list;
    public List<String> titles;

    public MainAdapter adapter;
    private EditText editText;
    private Title title;


    private Button button;
    public static String KEY = "key";
    public static String TAG = "tag";
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            Log.e(TAG, "onCreate: " + savedInstanceState.getStringArrayList("array"));
        }
        titles = new ArrayList<>();
        init();
    }

    private void init() {
        recyclerView = findViewById(R.id.recyclerView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapter = new MainAdapter(list, this);
        recyclerView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });

        for (int i = 0; i < 3; i++) {
            list.add(new Title("Item" + (i + 1), "Welcome to GeekTech courses, we are from group 24"));
        }
    }

    private void sendMessage() {
        String resultText = editText.getText().toString();
        title = new Title();
        title.setTitle(resultText);
        titles.add(resultText);
        list.add(0, title);
        adapter.notifyDataSetChanged();
        editText.setText("");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("array", (ArrayList<String>) titles);
        Log.e(TAG, "onSaveInstanceState: " + titles);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e(TAG, "onRestoreInstanceState: " + savedInstanceState.getStringArrayList("array"));
        titles = savedInstanceState.getStringArrayList("array");
        assert titles != null;
        for (int i = 0; i < titles.size(); i++) {
            list.add(0, new Title(titles.get(i), ""));
        }
    }
}