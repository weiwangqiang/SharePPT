package com.example.observerdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ListAdapter listAdapter = new ListAdapter();
        recyclerView.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();
        recyclerView.getChildCount();
    }

    private static class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHodle> {
        @NonNull
        @Override
        public ViewHodle onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewActivity.ListAdapter.ViewHodle holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        private class ViewHodle extends RecyclerView.ViewHolder {

            public ViewHodle(@NonNull View itemView) {
                super(itemView);
            }
        }
    }
}