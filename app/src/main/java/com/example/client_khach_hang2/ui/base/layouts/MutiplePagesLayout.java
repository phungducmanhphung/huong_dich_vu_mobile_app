package com.example.client_khach_hang2.ui.base.layouts;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.client_khach_hang2.R;
import com.example.client_khach_hang2.ui.base.layouts.interfaces.I_MutiplePagesLayout;

import java.util.LinkedList;
import java.util.List;

public class MutiplePagesLayout extends LinearLayout implements I_MutiplePagesLayout {
    int currentPage = -1;
    LinearLayout root;
    List<View> pages;

    public MutiplePagesLayout(Context context) {
        super(context);
    }

    public MutiplePagesLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MutiplePagesLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public MutiplePagesLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
        inflate(getContext(), R.layout.layout_mutiple_pages, this);

        pages = new LinkedList<>();
        
        setControl();
        setEvent();
    }
    private void setEvent() {
    }
    private void setControl() {
        root = findViewById(R.id.main);
    }
    private void setCurrentPage(int position){

    }
    @Override
    public void addPage(View page) {
        pages.add(page);
        root.addView(page);
    }
    @Override
    public void goToPage(int position) {
        if(pages != null && pages.size() > position){
            this.currentPage = position;
        }
    }
    @Override
    public void nextPage() {

    }
    @Override
    public void prePage() {

    }
}
