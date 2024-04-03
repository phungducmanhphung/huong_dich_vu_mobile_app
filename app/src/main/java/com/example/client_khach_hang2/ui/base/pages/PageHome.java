package com.example.client_khach_hang2.ui.base.pages;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.client_khach_hang2.R;
import com.example.client_khach_hang2.ui.base.components.ComponentFilterPhong;
import com.example.client_khach_hang2.ui.base.components.I_OnPickDate;
import com.example.client_khach_hang2.utils.DateUtils;

import java.util.Date;
import java.util.List;

public class PageHome extends LinearLayout {

    public ComponentFilterPhong componentFilterPhong;
    public Button btnDangKi, btnDangNhap;
    public ImageView drawerToggle;

    public PageHome(Context context) {
        super(context);
        init();
    }
    public PageHome(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public PageHome(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public PageHome(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }
    private void init() {
        inflate(getContext(), R.layout.page_home, this);
        
        setControl();
        setEvent();
    }
    private void setEvent() {
    }
    private void setControl() {
        componentFilterPhong = findViewById(R.id.componentFilterPhong);
        btnDangKi = findViewById(R.id.btnDangKi);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        drawerToggle = findViewById(R.id.drawerToggle);
    }
}
