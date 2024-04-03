package com.example.client_khach_hang2.ui.activities.cap_nhat_thong_tin_user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.client_khach_hang2.KhachSanClientApplication;
import com.example.client_khach_hang2.R;
import com.example.client_khach_hang2.ui.activities.interfaces.I_Activity;
import com.example.client_khach_hang2.ui.base.models.TaiKhoan;
import com.example.client_khach_hang2.ui.base.pages.PageCapNhatThongTinType;
import com.example.client_khach_hang2.ui.base.pages.PageCapNhatThongTin_1;

public class CapNhatThongTinUserActivitiy extends AppCompatActivity implements I_Activity, I_CapNhatThongTinUserActivity {

    I_CapNhatThongTinUserHandler handler;
    public TaiKhoan taiKhoan = null;
    public PageCapNhatThongTin_1 pageCapNhatThongTin1;
    PageCapNhatThongTinType type = PageCapNhatThongTinType.DANG_KY_TAI_KHOAN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cap_nhat_thong_tin_user_activitiy);

        // set handler for this activity
        handler = new CapNhatThongTinUserHandler(this);
        getArgs();
        setControl();
        setEvent();

        /*
        * //init virtual value for test acvitity from dev env
        *
        * handler.handleTest();
        * */
    }
    @Override
    public void getArgs() {
        Intent intent = getIntent();
        taiKhoan = (TaiKhoan) intent.getSerializableExtra("taiKhoan");
    }
    @Override
    public void setEvent() {
        initFormValues();

        pageCapNhatThongTin1.setOnNextClick(v -> {
            onNextClick(v);
        });

        pageCapNhatThongTin1.setOnBackClick(v -> {
            finish();
        });
    }
    @Override
    public void setControl() {
        pageCapNhatThongTin1 = findViewById(R.id.pageCapNhatThongTin1);
    }
    /*
    * Đưa thông tin của người dùng hiện tại vào form nếu là cập nhật tài khoản
    * */
    private void initFormValues() {
        pageCapNhatThongTin1.setType(type);
        if(type == PageCapNhatThongTinType.CAP_NHAT_THONG_TIN){
            if(KhachSanClientApplication.taiKhoanLocal != null){
                pageCapNhatThongTin1.setEmail(KhachSanClientApplication.taiKhoanLocal.getEmail());
                pageCapNhatThongTin1.setPassword(KhachSanClientApplication.taiKhoanLocal.getPassword());
                pageCapNhatThongTin1.setSdt(KhachSanClientApplication.taiKhoanLocal.getSdt());
                pageCapNhatThongTin1.setHo(KhachSanClientApplication.taiKhoanLocal.getHo());
                pageCapNhatThongTin1.setTen(KhachSanClientApplication.taiKhoanLocal.getTen());
                pageCapNhatThongTin1.setGioiTinh(KhachSanClientApplication.taiKhoanLocal.getGioiTinh());
                pageCapNhatThongTin1.setNgaySinh(KhachSanClientApplication.taiKhoanLocal.getNgaySinh());
            }
        }
    }
    private void onNextClick(View v){
        handler.onNextHandle(v);
    }
}