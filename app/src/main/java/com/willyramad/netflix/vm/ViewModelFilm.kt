package com.willyramad.netflix.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.willyramad.netflix.model.ResponFilmItem
import com.willyramad.netflix.service.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelFilm : ViewModel() {
    lateinit var LiveDataFilm : MutableLiveData<ResponFilmItem?>


    init {
        LiveDataFilm = MutableLiveData()
    }
    fun getAllFilm(): MutableLiveData<ResponFilmItem?>{
        return LiveDataFilm
    }
    fun callAllFilm(){
        ApiClient.instance.getAllFilm()
            .enqueue(object  : Callback<ResponFilmItem>{
                override fun onResponse(
                    call: Call<ResponFilmItem>,
                    response: Response<ResponFilmItem>
                ) {
                    if (response.isSuccessful){
                        LiveDataFilm.postValue(response.body())
                    }else{
                        LiveDataFilm.postValue(null)
                    }
                }

                override fun onFailure(call: Call<ResponFilmItem>, t: Throwable) {
                    LiveDataFilm.postValue(null)
                }

            })
    }
}