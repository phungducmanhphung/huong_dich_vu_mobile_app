package com.example.client_khach_hang2.ui.base.layouts.interfaces;

import android.view.View;

public interface I_MutiplePagesLayout {
    public void addPage(View page);
    public void goToPage(int position);
    public void nextPage();
    public void prePage();
}
