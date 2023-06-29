package com.example.my_shop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        getProducts()
    }

    fun getProducts(){
        val retrofit = ApiClient.buildClient(ApiInterface::class.java)
        val request = retrofit.getProducts()
        request.enqueue(object:Callback<List<Products>>{
            override fun onResponse(
                call: Call<List<Products>>,
                response: Response<List<Products>>
            ) {
                if(response.isSuccessful){
                    var products = response.body()
                    Toast.makeText(baseContext, "fetched ${products?.size} products", Toast.LENGTH_LONG).show()

                }
                else{
                    Toast.makeText(baseContext, response.errorBody()?.string(), Toast.LENGTH_LONG).show()
                }


            }

            override fun onFailure(call: Call<List<Products>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()

            }
        }
        )
    }
}