package com.example.client_khach_hang2.ui.base.components;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.client_khach_hang2.R;
import com.example.client_khach_hang2.utils.DateUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ComponentSpinner extends LinearLayout {
    ImageView ivIcon;
    Spinner spinner;
    List<String> data;
    ArrayAdapter<String> arrayAdapter;
    public ComponentSpinner(Context context) {
        super(context);
        init(context, null);
    }

    public ComponentSpinner(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ComponentSpinner(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }
    public ComponentSpinner(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }
    private void init(Context context, AttributeSet attrs) {
        inflate(getContext(), R.layout.component_spinner, this);
        
        setControl();
        setEvent();

        if(attrs != null){
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ComponentsSpinner);
            int resourceId = a.getResourceId(R.styleable.ComponentsSpinner_imageResource, R.drawable.ic_location);
            ivIcon.setImageResource(resourceId);
            a.recycle();
        }
    }
    private void setEvent() {
        data = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item,data);
        spinner.setAdapter(arrayAdapter);
    }
    private void setControl() {
        ivIcon = findViewById(R.id.ivIcon);
        spinner = findViewById(R.id.spinner);
    }
    public void setIcon(Bitmap bitmap){
        ivIcon.setImageBitmap(bitmap);
    }
    public void setData(List<String> data){
        this.data.clear();
        this.data.addAll(data);
        arrayAdapter.notifyDataSetChanged();
    }
    public void setOnItemSelected(AdapterView.OnItemSelectedListener onItemSelectedListener){
        spinner.setOnItemSelectedListener(onItemSelectedListener);
    }
}
