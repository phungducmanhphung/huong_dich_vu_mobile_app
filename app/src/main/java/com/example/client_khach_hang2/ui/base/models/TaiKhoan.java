package com.example.client_khach_hang2.ui.base.models;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.Date;

public class TaiKhoan implements Serializable {
    private String email;
    private String password;
    private String sdt;
    private String ho;
    private String ten;
    private int gioiTinh;
    private Date ngaySinh;
    private byte[] avatar;

    public TaiKhoan() {
    }
    public TaiKhoan(String email, String password, String sdt, String ho, String ten, int gioiTinh, Date ngaySinh, byte[] avatar) {
        this.email = email;
        this.password = password;
        this.sdt = sdt;
        this.ho = ho;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }
}
