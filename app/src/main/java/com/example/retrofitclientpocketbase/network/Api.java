package com.example.retrofitclientpocketbase.network;

import com.example.retrofitclientpocketbase.network.models.ResponseStudents;
import com.example.retrofitclientpocketbase.network.models.Student;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @GET("collections/students/records")
    Call<ResponseStudents> getAllStudents();

    @POST("collections/students/records")
    Call<Student> createStudent(@Body Student student);

}
