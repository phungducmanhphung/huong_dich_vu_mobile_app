package com.example.client_khach_hang2.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ResUtils {
    public static Bitmap getBitmapFromUri(Uri uri, Context context) throws IOException {
        InputStream input = context.getContentResolver().openInputStream(uri);
        Bitmap bitmap = BitmapFactory.decodeStream(input);
        input.close();
        return bitmap;
    }

    public static Bitmap GetBitmapFromFile(String filePath) {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                Bitmap bitmap = BitmapFactory.decodeFile(filePath);
                return bitmap;
            } else {
                // Handle the case where file does not exist
                return null;
            }
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            // Handle OutOfMemoryError gracefully (log, show error message, etc.)
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            // Handle other exceptions gracefully (log, show error message, etc.)
            return null;
        }
    }

    public static byte[] BitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        return stream.toByteArray();
    }
    public static Bitmap ByteArrayToBitmap(byte[] byteArray) {
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }
}
