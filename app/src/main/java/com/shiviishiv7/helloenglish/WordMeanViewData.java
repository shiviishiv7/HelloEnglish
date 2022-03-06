package com.shiviishiv7.helloenglish;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class WordMeanViewData extends AppCompatActivity {
    private RecyclerView recyclerView;
    public static int state = 1;
    public static int QuestionState = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_mean_view_data);
        recyclerView = findViewById(R.id.recyclerView_2);
        MyListAdapter adapter = new MyListAdapter(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);
    }
    public static class MyListAdapter extends RecyclerView.Adapter<WordMeanViewData.MyListAdapter.ViewHolder>{
        ArrayList<String> list = new ArrayList<String>();
        Context context;
        MyListAdapter(Context context) {
            this.context = context;
            list.addAll(WordMeaning.map.keySet());

        }
        @Override
        public WordMeanViewData.MyListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View listItem= layoutInflater.inflate(R.layout.wordmean, parent, false);
            WordMeanViewData.MyListAdapter.ViewHolder viewHolder = new WordMeanViewData.MyListAdapter.ViewHolder(listItem);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(WordMeanViewData.MyListAdapter.ViewHolder holder, int position) {

            holder.textView.setText(list.get(position)+"\t"+(WordMeaning.map.get(list.get(position))));
            
        }


        @Override
        public int getItemCount() {
            return list.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {

            public TextView textView;
            public ViewHolder(View itemView) {
                super(itemView);
                this.textView = itemView.findViewById(R.id.button_word_mean);

            }
        }
    }}