package com.example.client_khach_hang2.ui.activities.cap_nhat_avatar_user;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.client_khach_hang2.R;
import com.example.client_khach_hang2.ui.activities.interfaces.I_Activity;
import com.example.client_khach_hang2.ui.base.models.TaiKhoan;
import com.example.client_khach_hang2.ui.base.pages.PageCapNhatThongTin_1;
import com.example.client_khach_hang2.ui.base.pages.PageCapNhatThongTin_2;
import com.example.client_khach_hang2.utils.ResUtils;

import java.io.InputStream;

public class CapNhatAvatarUserActivitiy extends AppCompatActivity implements I_Activity, I_CapNhatAvatarUserActivity {

    I_CapNhatAvatarUserHandler handler;
    TaiKhoan taiKhoan = null;
    PageCapNhatThongTin_2 pageCapNhatThongTin2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cap_nhat_avatar_user_activitiy);

        handler = new CapNhatAvatarUserHandler(this);

        getArgs();
        setControl();
        setEvent();
    }

    @Override
    public void getArgs() {
        try {
            Intent intent = getIntent();
            taiKhoan = (TaiKhoan) intent.getSerializableExtra("taiKhoan");
            Log.d("TAI KHOAN", taiKhoan.toString());
        }
        catch (Exception ex){

        }
    }
    @Override
    public void setEvent() {
        initValues();

        pageCapNhatThongTin2.setOnBackClick(v -> {
            handler.onBackHandle(v);
        });
        pageCapNhatThongTin2.setOnSelectImageClick(v -> {
            ((CapNhatAvatarUserHandler)handler).openImagePicker();
        });
    }
    @Override
    public void setControl() {
        pageCapNhatThongTin2 = findViewById(R.id.pageCapNhatThongTin2);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null) {
            Uri filePath = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(filePath);
                Bitmap bm = BitmapFactory.decodeStream(inputStream);
                pageCapNhatThongTin2.setAvatar(bm);
                byte[] arr = ResUtils.BitmapToByteArray(bm);
            }
            catch (Exception ex){
                Toast.makeText(this, "Lỗi mẹ rồi", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void initValues() {
        if(taiKhoan != null){
            if(taiKhoan.getAvatar() != null){
                pageCapNhatThongTin2.setAvatar(ResUtils.ByteArrayToBitmap(taiKhoan.getAvatar()));
                Toast.makeText(this, "Avatar khac null", Toast.LENGTH_SHORT).show();
            }
        }
    }
}