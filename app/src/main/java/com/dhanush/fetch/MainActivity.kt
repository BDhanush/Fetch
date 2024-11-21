package com.dhanush.fetch

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.dhanush.fetch.model.Item
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val dataURL="https://fetch-hiring.s3.amazonaws.com/"                 //api link

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getItems()

    }
    private fun getItems()
    {
        val retrofitBuffer= Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(dataURL).build().create(ApiInterface::class.java)

        //make an api call to get item list
        val retrofitData = retrofitBuffer.getItems()

        retrofitData.enqueue(object : Callback<List<Item>?> {
            override fun onResponse(call: Call<List<Item>?>, response: Response<List<Item>?>) {
                val responseBody=response.body()!!      //body has a list of items
                val dataset=responseBody.toList()
                filterDataset(dataset)
            }

            override fun onFailure(call: Call<List<Item>?>, t: Throwable) {
                Log.e("http error", "Failed to get items: ${t.message}", t)
            }
        })
    }
    private fun filterDataset(dataset:List<Item>) {
        val newItems = dataset
            .filter { !it.name.isNullOrBlank() } // filter out blank or null names
            .sortedWith(compareBy({ it.listId }, { it.name })) // sort by listId, name
            .groupBy { it.listId } //group by listId

    }
}