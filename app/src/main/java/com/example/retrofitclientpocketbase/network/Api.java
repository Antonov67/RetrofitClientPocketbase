package com.example.retrofitclientpocketbase.network;

import com.example.retrofitclientpocketbase.network.models.ResponseStudents;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("collections/students/records")
    Call<ResponseStudents> getAllStudents();
}
