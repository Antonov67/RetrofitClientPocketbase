package com.example.retrofitclientpocketbase.network.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.retrofitclientpocketbase.R;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {

    public StudentAdapter(@NonNull Context context, int resource, @NonNull List<Student> students) {
        super(context, resource, students);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.student_item, null);
        }

        TextView name = convertView.findViewById(R.id.nameText);
        TextView age = convertView.findViewById(R.id.ageText);
        TextView address = convertView.findViewById(R.id.cityText);
        TextView  weight = convertView.findViewById(R.id.weightText);
        TextView height = convertView.findViewById(R.id.heightText);

        Student student = getItem(position);

        name.setText(student.getName());
        age.setText(student.getAge());
        address.setText(student.getAddress());
        weight.setText(student.getWeight());
        height.setText(student.getHeight());

        return convertView;
    }
}
