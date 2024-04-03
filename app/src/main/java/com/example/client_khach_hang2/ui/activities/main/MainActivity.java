package com.example.client_khach_hang2.ui.activities.main;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.drawerlayout.widget.DrawerLayout;

import com.example.client_khach_hang2.KhachSanClientApplication;
import com.example.client_khach_hang2.R;
import com.example.client_khach_hang2.ui.activities.cap_nhat_avatar_user.CapNhatAvatarUserActivitiy;
import com.example.client_khach_hang2.ui.activities.cap_nhat_thong_tin_user.CapNhatThongTinUserActivitiy;
import com.example.client_khach_hang2.ui.activities.dang_nhap.DangNhapActivity;
import com.example.client_khach_hang2.ui.base.components.ComponentFilterPhong;
import com.example.client_khach_hang2.ui.base.pages.PageHome;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    DrawerLayout drawerLayout;
    ImageView drawerToggle;
    ComponentFilterPhong componentFilterPhong;
    PageHome pageHome;
    Button btnDangKi, btnDangNhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setControl();
        setEvent();
        detectOrientation();
        
        /*
        * test
        * */
        initTest();
    }
    private void initTest() {
        List<String> viTri = new ArrayList<>();
        viTri.add("Hà Nội");
        viTri.add("Hồ Chí Minh");
        viTri.add("Đạ Tẻ");
        componentFilterPhong.setDataViTri(viTri);

        List<String> soNguoi = new ArrayList<>();
        soNguoi.add("1");
        soNguoi.add("2");
        soNguoi.add("3");
        componentFilterPhong.setDataSoNguoi(soNguoi);
    }
    private void detectOrientation() {
        int orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(this, "LANDCAPE", Toast.LENGTH_SHORT).show();
        } else if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "PORTRAIT", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "UNDEFIND", Toast.LENGTH_SHORT).show();
        }
    }
    private void setEvent() {
        if (KhachSanClientApplication.taiKhoanLocal == null){
            drawerToggle.setVisibility(View.GONE);
        }

        drawerToggle.setOnClickListener(v -> {
            drawerLayout.open();
        });

        btnDangKi.setOnClickListener(v -> {
            Intent intent = new Intent(this, CapNhatThongTinUserActivitiy.class);
            startActivity(intent);
        });

        btnDangNhap.setOnClickListener(v -> {
            Intent intent = new Intent(this, DangNhapActivity.class);
            startActivity(intent);
        });

    }
    private void setControl() {
        drawerLayout = findViewById(R.id.drawerLayout);

        pageHome = findViewById(R.id.pageHome);
        componentFilterPhong = pageHome.componentFilterPhong;
        drawerToggle = pageHome.drawerToggle;
        btnDangKi = pageHome.btnDangKi;
        btnDangNhap = pageHome.btnDangNhap;
    }
}