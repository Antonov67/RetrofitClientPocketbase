package com.example.retrofitclientpocketbase;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.retrofitclientpocketbase.network.callbacks.SimpleDataCallback;
import com.example.retrofitclientpocketbase.network.models.ResponseStudents;
import com.example.retrofitclientpocketbase.network.models.Student;
import com.example.retrofitclientpocketbase.service.Service;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Service service;
    private ArrayAdapter<String> adapter;
    ListView studentsList;
    Button addBtn, resetBtn;
    List<String> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        resetBtn = findViewById(R.id.resetButton);
        studentsList = findViewById(R.id.studentsList);

        students = new ArrayList<>();
        service = new Service();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, students);
        studentsList.setAdapter(adapter);

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service.getAllStudents(new SimpleDataCallback<ResponseStudents>() {
                    @Override
                    public void onLoad(ResponseStudents data) {
                        students.clear();
                        for (Student student : data.getStudents()) {
                            students.add(student.name + " " + student.age);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}