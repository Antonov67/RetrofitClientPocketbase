package com.example.retrofitclientpocketbase;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.retrofitclientpocketbase.network.callbacks.SimpleDataCallback;
import com.example.retrofitclientpocketbase.network.models.ResponseStudents;
import com.example.retrofitclientpocketbase.network.models.Student;
import com.example.retrofitclientpocketbase.network.models.StudentAdapter;
import com.example.retrofitclientpocketbase.service.Service;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Service service;
    private StudentAdapter adapter;
    ListView studentsList;
    Button addBtn, resetBtn;
    List<Student> students;
    EditText nameField, ageField, weightField, heightField, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        resetBtn = findViewById(R.id.resetButton);
        addBtn = findViewById(R.id.addButton);
        studentsList = findViewById(R.id.studentsList);
        nameField = findViewById(R.id.nameField);
        ageField = findViewById(R.id.ageField);
        weightField = findViewById(R.id.weightField);
        heightField = findViewById(R.id.heightField);
        address = findViewById(R.id.addressField);

        students = new ArrayList<>();
        service = new Service();
        adapter = new StudentAdapter(this, R.layout.student_item, students);
        studentsList.setAdapter(adapter);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!address.getText().toString().isEmpty() &&
                        !ageField.getText().toString().isEmpty() &&
                        !heightField.getText().toString().isEmpty() &&
                        !nameField.getText().toString().isEmpty() &&
                        !weightField.getText().toString().isEmpty()
                ) {
                    Student student = new Student(
                            address.getText().toString(),
                            ageField.getText().toString(),
                            heightField.getText().toString(),
                            nameField.getText().toString(),
                            weightField.getText().toString());

                    service.createStudent(student, new SimpleDataCallback<Student>() {
                        @Override
                        public void onLoad(Student data) {
                            Toast.makeText(MainActivity.this, data.getName(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(MainActivity.this, "Не все поля заполнены", Toast.LENGTH_SHORT).show();
                }
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service.getAllStudents(new SimpleDataCallback<ResponseStudents>() {
                    @Override
                    public void onLoad(ResponseStudents data) {
                        students.clear();
                        students.addAll(data.getStudents());
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        });

        studentsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                service.deleteStudent(students.get(i).getId(), new SimpleDataCallback<String>() {
                    @Override
                    public void onLoad(String data) {
                        Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
                    }
                });
                students.remove(i);
                adapter.notifyDataSetChanged();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}