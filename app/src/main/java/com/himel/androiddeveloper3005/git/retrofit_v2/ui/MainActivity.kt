package com.himel.androiddeveloper3005.git.retrofit_v2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.himel.androiddeveloper3005.git.retrofit_v2.R
import com.himel.androiddeveloper3005.git.retrofit_v2.repository.Repository
import com.himel.androiddeveloper3005.git.retrofit_v2.viewmodel.MainViewModel
import com.himel.androiddeveloper3005.git.retrofit_v2.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var repository: Repository
    private lateinit var viewModelFactory: MainViewModelFactory
    private lateinit var numberEtx : EditText
    private lateinit var saveBtn : Button
    private lateinit var showTxt : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showTxt = findViewById(R.id.text)
        numberEtx = findViewById(R.id.number_etx)
        saveBtn = findViewById(R.id.save_btn)
        repository = Repository()
        viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory)
                .get(MainViewModel ::class.java)

        //query map
        val options : HashMap<String , String> = HashMap()
        options["_sort"] = "id"
        options["order"] = "desc"


        saveBtn.setOnClickListener {

            val number = numberEtx.text.toString()
            viewModel.getCustomPosts1(Integer.parseInt(number),options)

            viewModel.customResponse1.observe(this, Observer { response ->

                if(response.isSuccessful){
                    showTxt.setText(response.body()?.toString()!!)
                    response.body()?.forEach{
                        Log.d("response",it.myUserID.toString())
                        Log.d("response",it.id.toString())
                        Log.d("response",it.title.toString())
                        Log.d("response",it.body.toString())

                    }

                }else{
                    showTxt.setText(response.errorBody().toString())


                }



            })


        }
    }
}