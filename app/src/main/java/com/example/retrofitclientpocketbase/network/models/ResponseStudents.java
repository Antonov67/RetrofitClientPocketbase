package com.example.retrofitclientpocketbase.network.models;

import com.google.gson.annotations.SerializedName;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

public class ResponseStudents implements Closeable {

    @SerializedName("items")
    private List<Student> students;

    @Override
    public void close() throws IOException {

    }

    public List<Student> getStudents() {
        return students;
    }
}
