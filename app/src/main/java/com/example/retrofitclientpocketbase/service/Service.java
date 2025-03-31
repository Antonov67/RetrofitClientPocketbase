package com.example.retrofitclientpocketbase.service;

import androidx.annotation.NonNull;

import com.example.retrofitclientpocketbase.network.Api;
import com.example.retrofitclientpocketbase.network.callbacks.SimpleDataCallback;
import com.example.retrofitclientpocketbase.network.models.ResponseStudents;
import com.example.retrofitclientpocketbase.network.models.Student;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {
    private final Api api;

    public Service() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.11.164:8090/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }

    public void getAllStudents(SimpleDataCallback<ResponseStudents> callback) {
        Call<ResponseStudents> call = api.getAllStudents();
        call.enqueue(new Callback<ResponseStudents>() {
            @Override
            public void onResponse(@NonNull Call<ResponseStudents> call, @NonNull Response<ResponseStudents> response) {
                if (!response.isSuccessful()) {
                    callback.onLoad(null);
                    return;
                }
                try (final ResponseStudents students = response.body()) {
                    if (students == null) {
                        callback.onLoad(null);
                        return;
                    }
                    callback.onLoad(students);
                } catch (IOException e) {
                    callback.onLoad(null);
                }
            }

            @Override
            public void onFailure(Call<ResponseStudents> call, Throwable throwable) {

            }
        });
    }

    public void createStudent(Student student, SimpleDataCallback<Student> callback){
        Call<Student> call = api.createStudent(student);
        call.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                if (!response.isSuccessful()) {
                    callback.onLoad(null);
                    return;
                }
                try (final Student student = response.body()) {
                    if (student == null) {
                        callback.onLoad(null);
                        return;
                    }
                    callback.onLoad(student);
                } catch (IOException e) {
                    callback.onLoad(null);
                }
            }

            @Override
            public void onFailure(Call<Student> call, Throwable throwable) {

            }
        });
    }

    public void deleteStudent(String id, SimpleDataCallback<Student> callback){
        Call<Void> call = api.deleteStudent(id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {

            }
        });
    }
}
