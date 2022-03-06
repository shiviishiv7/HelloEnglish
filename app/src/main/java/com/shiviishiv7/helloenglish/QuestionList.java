package com.shiviishiv7.helloenglish;

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

import java.util.ArrayList;

public class QuestionList extends AppCompatActivity {
    private RecyclerView recyclerView;
    public static int state = 1;
    public static int QuestionState = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);
        recyclerView = findViewById(R.id.recyclerView);
        MyListAdapter adapter = new MyListAdapter(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);
    }
    public static class MyListAdapter extends RecyclerView.Adapter<RecycleViewShowData.MyListAdapter.ViewHolder>{
        ArrayList<String> list = new ArrayList<String>();
        Context context;
        MyListAdapter(Context context) {
            this.context = context;
            list.add("What");
            list.add("When");
            list.add("How");
            list.add("Where");
            list.add("Who");
            list.add("Whom");
            list.add("Whose");
            list.add("Which");

        }
        @Override
        public RecycleViewShowData.MyListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View listItem= layoutInflater.inflate(R.layout.recycle_view_item, parent, false);
            RecycleViewShowData.MyListAdapter.ViewHolder viewHolder = new RecycleViewShowData.MyListAdapter.ViewHolder(listItem);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(RecycleViewShowData.MyListAdapter.ViewHolder holder, int position) {

            holder.textView.setText(list.get(position));
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    QuestionState =  holder.getAdapterPosition()+1;
                    context.startActivity(new Intent(context.getApplicationContext(), RecycleViewShowData.class));
                }
            });
        }


        @Override
        public int getItemCount() {
            return list.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {

            public Button textView;
            public ViewHolder(View itemView) {
                super(itemView);
                this.textView = itemView.findViewById(R.id.button);

            }
        }
    }}