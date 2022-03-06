package com.shiviishiv7.helloenglish;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleViewShowData extends AppCompatActivity {
    private RecyclerView recyclerView;
    public static int state = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_show_data);
        recyclerView = findViewById(R.id.recyclerView);
        MyListAdapter adapter = new MyListAdapter(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);
    }
    public static class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{
        ArrayList<String> list = new ArrayList<String>();
        Context context;
        MyListAdapter(Context context) {
            this.context = context;
            list.add("Present Tense 1");
            list.add("Present Tense 2");
            list.add("Present Tense 3");
            list.add("Present Tense 4");
            list.add("Past Tense 1");
            list.add("Past Tense 2");
            list.add("Past Tense 3");
            list.add("Past Tense 4");
            list.add("Future Tense 1");
            list.add("Future Tense 2");
            list.add("Future Tense 3");
            list.add("Future Tense 4");
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View listItem= layoutInflater.inflate(R.layout.recycle_view_item, parent, false);
            ViewHolder viewHolder = new ViewHolder(listItem);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            holder.textView.setText(list.get(position));
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    state =  holder.getAdapterPosition()+1;
                    context.startActivity(new Intent(context.getApplicationContext(), ViewPager2ShowData.class));
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
    }

}