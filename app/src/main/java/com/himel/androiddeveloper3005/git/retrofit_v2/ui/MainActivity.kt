package com.himel.androiddeveloper3005.git.retrofit_v2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.himel.androiddeveloper3005.git.retrofit_v2.R
import com.himel.androiddeveloper3005.git.retrofit_v2.adapter.MyAdapter
import com.himel.androiddeveloper3005.git.retrofit_v2.model.Post
import com.himel.androiddeveloper3005.git.retrofit_v2.repository.Repository
import com.himel.androiddeveloper3005.git.retrofit_v2.viewmodel.MainViewModel
import com.himel.androiddeveloper3005.git.retrofit_v2.viewmodel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var repository: Repository
    private lateinit var viewModelFactory: MainViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val post = Post(2,2,"himel","github")
        repository = Repository()
        viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel ::class.java)
        viewModel.pushPost_1(3,2,"himel","github")
        viewModel.myResponse.observe(this, Observer {response ->
            if (response.isSuccessful){
                Log.d("post",response.body().toString())
                Log.d("post",response.code().toString())
                Log.d("post",response.message().toString())

            }else{
                Toast.makeText(applicationContext,""+response.body(),Toast.LENGTH_LONG).show()
            }

        })



    }

}