package com.dhanush.fetch

import com.dhanush.fetch.model.Item
import retrofit2.Call
import retrofit2.http.GET

//retrofit api service
interface ApiInterface {
    //a method to make an HTTP GET request to retrieve a list of items from the "hiring.json" endpoint
    @GET(value = "hiring.json")
    fun getItems(): Call<List<Item>>

}