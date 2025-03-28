package com.example.retrofitclientpocketbase;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.retrofitclientpocketbase.network.callbacks.SimpleDataCallback;
import com.example.retrofitclientpocketbase.network.models.ResponseStudents;
import com.example.retrofitclientpocketbase.service.Service;

public class MainActivity extends AppCompatActivity {

    private Service service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        service = new Service();
        service.getAllStudents(new SimpleDataCallback<ResponseStudents>() {
            @Override
            public void onLoad(ResponseStudents data) {
                System.out.println(data.getStudents().get(0).name);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}