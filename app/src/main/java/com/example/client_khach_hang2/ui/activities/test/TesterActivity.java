package com.example.client_khach_hang2.ui.activities.test;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.client_khach_hang2.R;
import com.example.client_khach_hang2.ui.base.components.ComponentSpinner;

import java.util.ArrayList;
import java.util.List;

public class TesterActivity extends AppCompatActivity {

    ComponentSpinner comSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tester);

        comSpinner = findViewById(R.id.comSpinner);

        List<String> data = new ArrayList<>();
        data.add("1");
        data.add("2");
        data.add("3");
        data.add("4");

        comSpinner.setData(data);
    }
}