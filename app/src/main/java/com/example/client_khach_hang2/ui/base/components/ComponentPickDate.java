package com.example.client_khach_hang2.ui.base.components;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.client_khach_hang2.R;
import com.example.client_khach_hang2.utils.DateUtils;

import java.util.Calendar;
import java.util.Date;

public class ComponentPickDate extends LinearLayout {
    ImageView ivSelectNgay;
    TextView tvNgay;
    Date date = null;
    I_OnPickDate i_onPickDate;

    public ComponentPickDate(Context context) {
        super(context);
        init(context, null);
    }

    public ComponentPickDate(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ComponentPickDate(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }
    public ComponentPickDate(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }
    private void init(Context context, AttributeSet attrs) {
        inflate(getContext(), R.layout.component_pick_date, this);

        setControl();
        setEvent();

        if(attrs != null){
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ComponentsPickDate);
            String text = a.getString(R.styleable.ComponentsPickDate_text);
            if(text != null){
                tvNgay.setText(text);
            }
            a.recycle();
        }
    }
    private void setControl(){
        ivSelectNgay = findViewById(R.id.ivSelectNgay);
        tvNgay = findViewById(R.id.tvNgay);
    }
    private void setEvent(){
        setOnClickListener(v -> {
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);

            // Tạo DatePickerDialog
            DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            // Xử lý khi người dùng chọn ngày
                            date = DateUtils.SetDate(year, monthOfYear, dayOfMonth);
                            tvNgay.setText(DateUtils.Date2String(date));
                            if(i_onPickDate != null){
                                i_onPickDate.onPickDate(date);
                            }
                        }
                    }, mYear, mMonth, mDay);
            // Hiển thị DatePickerDialog
            datePickerDialog.show();
        });
    }
    public void setIcon(Bitmap bitmap){
        ivSelectNgay.setImageBitmap(bitmap);
    }
    public void setText(String ngay){
        tvNgay.setText(ngay);
    }
    public void setDate(Date date){
        this.date = date;
        setText(DateUtils.Date2String(this.date));
    }
    public Date getDate(){
        return date;
    }
    public void setOnPickDate(I_OnPickDate onPickDate){
        this.i_onPickDate = onPickDate;
    }
}
