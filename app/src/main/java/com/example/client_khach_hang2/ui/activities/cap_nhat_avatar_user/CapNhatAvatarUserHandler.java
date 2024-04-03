package com.example.client_khach_hang2.ui.activities.cap_nhat_avatar_user;

import android.content.Intent;
import android.provider.MediaStore;
import android.view.View;

public class CapNhatAvatarUserHandler implements I_CapNhatAvatarUserHandler{
    I_CapNhatAvatarUserActivity activity;
    public CapNhatAvatarUserHandler() {
    }
    public CapNhatAvatarUserHandler(I_CapNhatAvatarUserActivity activity) {
        this.activity = activity;
    }
    @Override
    public void onBackHandle(View view) {
        if(activity == null)
            return;
        CapNhatAvatarUserActivitiy _activity = (CapNhatAvatarUserActivitiy) activity;
        _activity.finish();
    }
    @Override
    public void setActivity(I_CapNhatAvatarUserActivity activity) {
        this.activity = activity;
    }
    public void openImagePicker() {
        if(activity != null){
            CapNhatAvatarUserActivitiy _activity = (CapNhatAvatarUserActivitiy) activity;
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            _activity.startActivityForResult(intent, 1);
        }
    }
}
