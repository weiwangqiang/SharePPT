package com.example.observerdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class NewRecyclerView extends RecyclerView {
    public NewRecyclerView(@NonNull  Context context) {
        super(context);
    }

    public NewRecyclerView(@NonNull  Context context, @Nullable  AttributeSet attrs) {
        super(context, attrs);
    }

    public NewRecyclerView(@NonNull  Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void addView(View child, int index) {
        super.addView(child, index);
    }
}
