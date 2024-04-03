package com.example.client_khach_hang2.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.client_khach_hang2.R;
import com.example.client_khach_hang2.ui.activities.cap_nhat_thong_tin_user.CapNhatThongTinUserActivitiy;
import com.example.client_khach_hang2.ui.base.models.TaiKhoan;
import com.example.client_khach_hang2.utils.DateUtils;

public class MainActivity_OLD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_old);

        Button btnClick = findViewById(R.id.btnClick);

        btnClick.setOnClickListener(v -> {
            TaiKhoan taiKhoan = new TaiKhoan();
            taiKhoan.setEmail("kimyoki99@gmail.com");
            taiKhoan.setPassword("12345");
            taiKhoan.setSdt("1234576");
            taiKhoan.setHo("Phùng");
            taiKhoan.setTen("Đức Mạnh");
            taiKhoan.setGioiTinh(0);
            taiKhoan.setNgaySinh(DateUtils.SetDate(2002, 11, 18));

            Intent intent = new Intent(this, CapNhatThongTinUserActivitiy.class);
            intent.putExtra("taiKhoan", taiKhoan);
            startActivity(intent);

        });

    }
}