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
import com.himel.androiddeveloper3005.git.retrofit_v2.repository.Repository
import com.himel.androiddeveloper3005.git.retrofit_v2.viewmodel.MainViewModel
import com.himel.androiddeveloper3005.git.retrofit_v2.viewmodel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var repository: Repository
    private lateinit var viewModelFactory: MainViewModelFactory
    private  val myAdapter by lazy {MyAdapter()}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        repository = Repository()
        viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel ::class.java)
        viewModel.getCustomPosts(2,"id","desc")
        viewModel.customResponse.observe(this, Observer {response ->
            if (response.isSuccessful){
                response.body()?.let { myAdapter.setData(it) }
            }else{
                Toast.makeText(applicationContext,""+response.body(),Toast.LENGTH_LONG).show()
            }

        })



    }

    private fun setupRecyclerView(){
        retrofit_rv.adapter = myAdapter
        retrofit_rv.layoutManager = LinearLayoutManager(this)
    }
}