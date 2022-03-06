package com.shiviishiv7.helloenglish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class ViewPager2ShowData extends AppCompatActivity {

        private ViewPager2 viewPager2;
        private RecyclerView recyclerView;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_view_pager2_show_data);
//            viewPager2 = findViewById(R.id.viewPager2);
//            MyListAdapter adapter = new MyListAdapter(RecycleViewShowData.state,MainActivity.section);
//            viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
//
//            viewPager2.setAdapter(adapter);
            recyclerView = findViewById(R.id.recyclerView);
            MyListAdapter adapter = new MyListAdapter(RecycleViewShowData.state,MainActivity.section);

            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            recyclerView.setAdapter(adapter);
        }

        public static class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {
            Map<String, String> map = new HashMap<>();
            String[] list;

            MyListAdapter(int state, int section) {
                this.map = ApplicationData.getData(state,section);
                this.list = this.map.keySet().toArray(new String[map.size()]);
            }

            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
                View listItem = layoutInflater.inflate(R.layout.viewpager, parent, false);
                ViewHolder viewHolder = new ViewHolder(listItem);
                return viewHolder;
            }


            @Override
            public void onBindViewHolder(ViewHolder holder, int position) {
                holder.textView.setText(list[position]);
                holder.textView2.setText(map.get(list[position]));

            }


            @Override
            public int getItemCount() {
                return map.size();
            }

            public static class ViewHolder extends RecyclerView.ViewHolder {

                public TextView textView;
                public TextView textView2;

                public ViewHolder(View itemView) {
                    super(itemView);

                    this.textView = itemView.findViewById(R.id.textview);
                    this.textView2 = itemView.findViewById(R.id.textview2);
                }
            }
        }
    }

