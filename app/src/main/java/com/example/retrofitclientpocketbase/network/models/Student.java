package com.example.retrofitclientpocketbase.network.models;

import com.google.gson.annotations.SerializedName;


public class Student {

    @SerializedName("address")
    public String address;

    @SerializedName("age")
    public Integer age;

    @SerializedName("collectionId")
    public String collectionId;

    @SerializedName("collectionName")
    public String collectionName;

    @SerializedName("created")
    public String created;

    @SerializedName("height")
    public Integer height;

    @SerializedName("id")
    public String id;

    @SerializedName("name")
    public String name;

    @SerializedName("updated")
    public String updated;

    @SerializedName("weight")
    public Integer weight;

}

