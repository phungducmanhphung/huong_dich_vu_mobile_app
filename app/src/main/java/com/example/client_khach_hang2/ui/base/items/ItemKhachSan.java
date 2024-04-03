package com.example.client_khach_hang2.ui.base.items;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.client_khach_hang2.R;

public class ItemKhachSan extends LinearLayout {
    public ItemKhachSan(Context context) {
        super(context);
        init();
    }

    public ItemKhachSan(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ItemKhachSan(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ItemKhachSan(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.item_khach_san, this);
    }

}
