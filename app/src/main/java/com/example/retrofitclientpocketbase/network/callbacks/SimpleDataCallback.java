package com.example.retrofitclientpocketbase.network.callbacks;

public interface SimpleDataCallback<T> {

    void onLoad(T data);
}
