package com.example.client_khach_hang2.utils;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageDownloader extends AsyncTask<String, Void, byte[]> {

    private static final String TAG = "ImageDownloader";
    private ImageDownloadListener listener;

    public interface ImageDownloadListener {
        void onImageDownloaded(byte[] imageData);
        void onImageDownloadFailed(String errorMessage);
    }

    public void setImageDownloadListener(ImageDownloadListener listener) {
        this.listener = listener;
    }

    @Override
    protected byte[] doInBackground(String... urls) {
        String imageUrl = urls[0];
        byte[] imageData = null;
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, bytesRead);
                }
                imageData = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                inputStream.close();
            }
            connection.disconnect();
        } catch (Exception e) {
            Log.e(TAG, "Error downloading image: " + e.getMessage());
        }
        return imageData;
    }

    @Override
    protected void onPostExecute(byte[] result) {
        if (listener != null) {
            if (result != null) {
                listener.onImageDownloaded(result);
            } else {
                listener.onImageDownloadFailed("Failed to download image");
            }
        }
    }
}
