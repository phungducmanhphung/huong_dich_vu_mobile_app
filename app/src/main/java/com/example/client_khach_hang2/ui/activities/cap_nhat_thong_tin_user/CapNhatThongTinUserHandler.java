package com.example.client_khach_hang2.ui.activities.cap_nhat_thong_tin_user;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.client_khach_hang2.ui.activities.cap_nhat_avatar_user.CapNhatAvatarUserActivitiy;
import com.example.client_khach_hang2.ui.base.components.ComponentPickDate;
import com.example.client_khach_hang2.ui.base.models.TaiKhoan;
import com.example.client_khach_hang2.utils.DateUtils;
import com.example.client_khach_hang2.utils.ImageDownloader;
import com.example.client_khach_hang2.utils.ResUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CapNhatThongTinUserHandler implements I_CapNhatThongTinUserHandler{
    I_CapNhatThongTinUserActivity activity;
    public CapNhatThongTinUserHandler(I_CapNhatThongTinUserActivity activity){
        this.activity = activity;
    }
    public CapNhatThongTinUserHandler(){
    }
    /*
    * Xử lý khi đã nhập thông tin xong
    * */
    @Override
    public void onNextHandle(View v) {
        try {
            if(activity == null)
                return;

            CapNhatThongTinUserActivitiy _activity = (CapNhatThongTinUserActivitiy)activity;

            /*
            * Kiểm tra sự hợp lệ của dữ liệu
            * */
            if(_activity.pageCapNhatThongTin1.isValid()){
                ImageDownloader downloader = new ImageDownloader();
                downloader.setImageDownloadListener(new ImageDownloader.ImageDownloadListener() {
                    @Override
                    public void onImageDownloaded(byte[] imageData) {
                        TaiKhoan taiKhoan = _activity.pageCapNhatThongTin1.convert2TaiKhoan();
                        taiKhoan.setAvatar(imageData);
                        Intent intent = new Intent(_activity, CapNhatAvatarUserActivitiy.class);
                        intent.putExtra("taiKhoan", taiKhoan);
                        _activity.startActivity(intent);
                    }

                    @Override
                    public void onImageDownloadFailed(String errorMessage) {
                        // Xử lý khi tải ảnh thất bại
                    }
                });
                downloader.execute("https://www.vietnamworks.com/hrinsider/wp-content/uploads/2023/12/hinh-thien-nhien-3d-002.jpg");
            }
            else{
                if(_activity.pageCapNhatThongTin1.exceptionView instanceof ComponentPickDate){
                    _activity.pageCapNhatThongTin1.exceptionView.callOnClick();
                }
                else{
                    _activity.pageCapNhatThongTin1.exceptionView.requestFocus();
                }
                Toast.makeText(_activity, _activity.pageCapNhatThongTin1.inValidMessage, Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception ex){
            Log.d("MY LOG", ex.getMessage());
        }
    }
    @Override
    public void setActivity(I_CapNhatThongTinUserActivity activity) {
        this.activity = activity;
    }
    @Override
    public void handleTest(){

        if(activity == null)
            return;

        CapNhatThongTinUserActivitiy _activity = (CapNhatThongTinUserActivitiy)activity;
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setEmail("kimyoki99@gmail.com");
        taiKhoan.setPassword("12345");
        taiKhoan.setSdt("1234576");
        taiKhoan.setHo("Phùng");
        taiKhoan.setTen("Đức Mạnh");
        taiKhoan.setGioiTinh(0);
        taiKhoan.setNgaySinh(DateUtils.SetDate(2002, 11, 18));
        _activity.pageCapNhatThongTin1.setTaiKhoan(taiKhoan);
    }
}
