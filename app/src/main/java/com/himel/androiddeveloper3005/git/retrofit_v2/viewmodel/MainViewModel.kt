package com.himel.androiddeveloper3005.git.retrofit_v2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.himel.androiddeveloper3005.git.retrofit_v2.model.Post
import com.himel.androiddeveloper3005.git.retrofit_v2.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel (private val repository: Repository) : ViewModel() {

    val myResponse : MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse1 : MutableLiveData<Response<Post>> = MutableLiveData()
    val customResponse : MutableLiveData<Response<List<Post>>> = MutableLiveData()



    fun getPost(){
        viewModelScope.launch {
            val response:Response<Post> = repository.getPost()
            myResponse.value = response
        }
    }

    fun getPost1(number : Int){
        viewModelScope.launch {
            val response:Response<Post> = repository.getPost1(number)
            myResponse1.value = response
        }
    }

    fun getCustomPosts(userId : Int , sort : String , order : String){
        viewModelScope.launch {
            val response:Response<List<Post>> = repository.getCustomPosts(userId,sort,order)
            customResponse.value = response
        }


    }
}