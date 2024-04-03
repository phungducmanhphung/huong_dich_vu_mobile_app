package com.example.client_khach_hang2.ui.base.pages;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.client_khach_hang2.R;

public class PageCapNhatThongTin_2 extends LinearLayout {

    Button btnOke;
    ImageView ivBack, ivSelectImage, ivAvatar;

    public PageCapNhatThongTin_2(Context context) {
        super(context);
        init();
    }

    public PageCapNhatThongTin_2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PageCapNhatThongTin_2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public PageCapNhatThongTin_2(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }
    private void init() {
        inflate(getContext(), R.layout.page_cap_nhat_thong_tin_2, this);

        setControl();
        setEvent();
    }
    private void setControl(){
        btnOke = findViewById(R.id.btnOke);
        ivBack = findViewById(R.id.ivBack);
        ivSelectImage = findViewById(R.id.ivSelectImage);
        ivAvatar = findViewById(R.id.ivAvatar);
    }
    private void setEvent(){

    }
    private boolean isValid(){
        return true;
    }
    public void setOnBackClick(OnClickListener onClickListener){
        ivBack.setOnClickListener(onClickListener);
    }
    public void setOnNextClick(OnClickListener onClickListener){
        btnOke.setOnClickListener(onClickListener);
    }
    public void setOnSelectImageClick(OnClickListener onClickListener){
        ivSelectImage.setOnClickListener(onClickListener);
    }
    public void setAvatar(Bitmap bm){
        ivAvatar.setImageBitmap(bm);
    }
}
