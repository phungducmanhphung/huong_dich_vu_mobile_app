package com.example.client_khach_hang2.ui.base.components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.client_khach_hang2.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComponentFilterPhong extends LinearLayout {
    ComponentPickDate pickDateNgayNhanPhong, pickDateNgayTraPhong;
    ComponentSpinner spinnerViTri, spinnerSoNguoi;

    public ComponentFilterPhong(Context context) {
        super(context);
        init();
    }
    public ComponentFilterPhong(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public ComponentFilterPhong(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public ComponentFilterPhong(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }
    private void init() {
        inflate(getContext(), R.layout.component_filter_phong, this);

        setControl();
        setEvent();
    }
    private void setEvent() {

    }
    private void setControl(){
        pickDateNgayNhanPhong = findViewById(R.id.pickDateNgayNhanPhong);
        pickDateNgayTraPhong = findViewById(R.id.pickDateNgayTraPhong);
        spinnerViTri = findViewById(R.id.spinnerViTri);
        spinnerSoNguoi = findViewById(R.id.spinnerSoNguoi);
    }
    public void setPickDateNgayNhanPhong(Date ngayNhanPhong){
        pickDateNgayNhanPhong.setDate(ngayNhanPhong);
    }
    public void setPickDateNgayTraPhong(Date ngayTraPhong){
        pickDateNgayTraPhong.setDate(ngayTraPhong);
    }
    public Date getNgayNhanPhong(){
        return pickDateNgayNhanPhong.getDate();
    }
    public Date getNgayTraPhong(){
        return pickDateNgayTraPhong.getDate();
    }
    public void setDataViTri(List<String> viTri){
        spinnerViTri.setData(viTri);
    }
    public void setDataSoNguoi(List<String> soNguoi){
        spinnerSoNguoi.setData(soNguoi);
    }
    public void setOnViTriSelected(AdapterView.OnItemSelectedListener onItemSelectedListener){
        spinnerViTri.setOnItemSelected(onItemSelectedListener);
    }
    public void setOnSoNguoiSelected(AdapterView.OnItemSelectedListener onItemSelectedListener){
        spinnerSoNguoi.setOnItemSelected(onItemSelectedListener);
    }
    public void setOnPickDateNgayNhanPhong(I_OnPickDate onPickDate){
        pickDateNgayNhanPhong.setOnPickDate(onPickDate);
    }
    public void setOnPickDateNgayTraPhong(I_OnPickDate onPickDate){
        pickDateNgayTraPhong.setOnPickDate(onPickDate);
    }
}
