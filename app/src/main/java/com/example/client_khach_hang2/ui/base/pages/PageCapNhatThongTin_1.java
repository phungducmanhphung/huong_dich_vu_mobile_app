package com.example.client_khach_hang2.ui.base.pages;

import android.content.Context;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.client_khach_hang2.R;
import com.example.client_khach_hang2.ui.base.components.ComponentPickDate;
import com.example.client_khach_hang2.ui.base.models.TaiKhoan;
import com.example.client_khach_hang2.utils.DateUtils;

import java.util.Date;

public class PageCapNhatThongTin_1 extends LinearLayout {

    public String inValidMessage = "";
    public View exceptionView;
    ComponentPickDate myDatePickerLayout;
    EditText edtEmail, edtPassword, edtPassword2, edtSdt, edtHo, edtTen;
    Button btnOke;
    ImageView ivBack;
    RadioGroup rgGioiTinh;
    RadioButton rbNam;
    RadioButton rbNu;
    RadioButton rbKhac;
    CheckBox cbHienMK2, cbHienMK;
    LinearLayout mkArea;
    TextView tvTitle;
    PageCapNhatThongTinType type = PageCapNhatThongTinType.DANG_KY_TAI_KHOAN;

    public PageCapNhatThongTin_1(Context context) {
        super(context);
        init();
    }

    public PageCapNhatThongTin_1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PageCapNhatThongTin_1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public PageCapNhatThongTin_1(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }
    private void init() {
        inflate(getContext(), R.layout.page_cap_nhat_thong_tin_1, this);
        setControl();
        setEvent();
    }
    private void setControl(){
        ivBack = findViewById(R.id.ivBack);
        btnOke = findViewById(R.id.btnOke);
        myDatePickerLayout = findViewById(R.id.myDatePicker);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtPassword2 = findViewById(R.id.edtPassword2);
        edtSdt = findViewById(R.id.edtSdt);
        edtHo = findViewById(R.id.edtHo);
        edtTen = findViewById(R.id.edtTen);
        rgGioiTinh = findViewById(R.id.rgGioiTinh);
        rbNam = findViewById(R.id.rbNam);
        rbNu = findViewById(R.id.rbNu);
        rbKhac = findViewById(R.id.rbKhac);
        cbHienMK = findViewById(R.id.cbHienMK);
        cbHienMK2 = findViewById(R.id.cbHienMK2);
        mkArea = findViewById(R.id.mkArea);
        tvTitle = findViewById(R.id.tvTitle);
    }
    private void setEvent(){
        edtPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        edtPassword2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        edtPassword.setTypeface(edtEmail.getTypeface());
        edtPassword2.setTypeface(edtEmail.getTypeface());
        cbHienMK.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                edtPassword.setInputType(InputType.TYPE_CLASS_TEXT);
            }
            else{
                edtPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
            edtPassword.setTypeface(edtEmail.getTypeface());
        });
        cbHienMK2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                edtPassword2.setInputType(InputType.TYPE_CLASS_TEXT);
            }
            else{
                edtPassword2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
            edtPassword2.setTypeface(edtEmail.getTypeface());
        });

//        btnOke.setOnClickListener(v -> {
//            parent.preNhapThongTinDangKi(v);
//            if(!isValid()){
//                MyCustomeDialog myCustomeDialog = new MyCustomeDialog(getContext());
//                myCustomeDialog.setOnClose(v2 -> {
//                    myCustomeDialog.dismiss();
//                    if(exceptionView != null){
//                        if(exceptionView instanceof MyDatePickerLayout){
//                            exceptionView.callOnClick();
//                        }
//                        else{
//                            exceptionView.requestFocus();
//                        }
//                    }
//                });
//                myCustomeDialog.show();
//            }
//            else{
//
//                parent.postNhapThongTinDangKi(convert2TaiKhoan());
//            }
//        });

    }
    public boolean isValid(){
        if (edtEmail.getText().toString().equals("")){
            inValidMessage = "Vui lòng nhập email!";
            exceptionView = edtEmail;
            return false;
        }
        if(type == PageCapNhatThongTinType.DANG_KY_TAI_KHOAN){
            if (edtPassword.getText().toString().equals("")){
                inValidMessage = "Vui lòng nhập mật khẩu!";
                exceptionView = edtPassword;
                return false;
            }
            if (edtPassword2.getText().toString().equals("")){
                inValidMessage = "Vui lòng nhập mật khẩu!";
                exceptionView = edtPassword2;
                return false;
            }
            if (!edtPassword.getText().toString().equals(edtPassword2.getText().toString())){
                inValidMessage = "Mật khẩu không khớp!";
                exceptionView = edtPassword2;
                return false;
            }
        }

        if (edtSdt.getText().toString().equals("")){
            exceptionView = edtSdt;
            inValidMessage = "Vui lòng nhập số điện thoại!";
            return false;
        }
        if (edtHo.getText().toString().equals("")){
            inValidMessage = "Vui lòng nhập họ!";
            exceptionView = edtHo;
            return false;
        }
        if (edtTen.getText().toString().equals("")){
            inValidMessage = "Vui lòng nhập tên!";
            exceptionView = edtTen;
            return false;
        }
        if (myDatePickerLayout.getDate() == null){
            inValidMessage = "Vui lòng nhập ngày sinh!";
            exceptionView = myDatePickerLayout;
            return false;
        }
        if(getGioiTinhInt() == -1){
            rbNam.setChecked(true);
            return false;
        }

        return true;
    }
    public void setOnBackClick(OnClickListener onClickListener){
        ivBack.setOnClickListener(onClickListener);
    }
    public void setOnNextClick(OnClickListener onClickListener){
        btnOke.setOnClickListener(onClickListener);
    }
    public int getGioiTinhInt(){
        if(rgGioiTinh != null){
            int rbId = rgGioiTinh.getCheckedRadioButtonId();
            if (rbId == R.id.rbNam)
                return 0;
            if (rbId == R.id.rbNu)
                return 1;
            if (rbId == R.id.rbKhac)
                return 2;
        }
        return -1;
    }
    public TaiKhoan convert2TaiKhoan(){
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setEmail(edtEmail.getText().toString());
        taiKhoan.setPassword(edtPassword.getText().toString());
        taiKhoan.setSdt(edtSdt.getText().toString());
        taiKhoan.setHo(edtHo.getText().toString());
        taiKhoan.setTen(edtTen.getText().toString());
        taiKhoan.setGioiTinh(getGioiTinhInt());
        taiKhoan.setNgaySinh(myDatePickerLayout.getDate());

        return taiKhoan;
    }
    public void setEmail(String email){
        edtEmail.setText(email);
    }
    public void setPassword(String password){
        edtPassword.setText(password);
    }
    public void setSdt(String sdt){
        edtSdt.setText(sdt);
    }
    public void setHo(String ho){
        edtHo.setText(ho);
    }
    public void setTen(String ten){
        edtTen.setText(ten);
    }
    public void setGioiTinh(int gioiTinh){
        switch (gioiTinh){
            case 0:
            {
                rbNam.setChecked(true);
                break;
            }
            case 1:
            {
                rbNu.setChecked(true);
                break;
            }
            case 2:
            {
                rbKhac.setChecked(true);
                break;
            }
        }
    }
    public void setNgaySinh(Date ngaySinh){
        myDatePickerLayout.setDate(ngaySinh);
    }
    public void setType(PageCapNhatThongTinType type){
        if(type == PageCapNhatThongTinType.CAP_NHAT_THONG_TIN){
            mkArea.setVisibility(GONE);
        }
        else{
            mkArea.setVisibility(VISIBLE);
        }
        this.type = type;
    }
    public void setTitle(String title){
        tvTitle.setText(title);
    }
    public void setTaiKhoan(TaiKhoan taiKhoan){
        edtEmail.setText(taiKhoan.getEmail());
        edtPassword.setText(taiKhoan.getPassword());
        edtSdt.setText(taiKhoan.getSdt());
        edtHo.setText(taiKhoan.getHo());
        edtTen.setText(taiKhoan.getTen());
        myDatePickerLayout.setDate(taiKhoan.getNgaySinh());
        setGioiTinh(taiKhoan.getGioiTinh());
    }
}
