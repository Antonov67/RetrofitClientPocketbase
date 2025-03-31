package com.example.retrofitclientpocketbase.network.models;

import com.google.gson.annotations.SerializedName;

import java.io.Closeable;
import java.io.IOException;


public class Student implements Closeable {

    @SerializedName("address")
    private String address;

    @SerializedName("age")
    private String age;

    @SerializedName("collectionId")
    private String collectionId;

    @SerializedName("collectionName")
    private String collectionName;

    @SerializedName("created")
    private String created;

    @SerializedName("height")
    private String height;

    @SerializedName("id")
    private String id;

    public String getId() {
        return id;
    }

    @SerializedName("name")
    private String name;

    @SerializedName("updated")
    private String updated;

    @SerializedName("weight")
    private String weight;

    @Override
    public void close() throws IOException {

    }

    public Student(String address, String age, String height, String name, String weight) {
        this.address = address;
        this.age = age;
        this.height = height;
        this.name = name;
        this.weight = weight;
    }

    public String getAddress() {
        return address;
    }

    public String getAge() {
        return age;
    }

    public String getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    public String getWeight() {
        return weight;
    }
}

