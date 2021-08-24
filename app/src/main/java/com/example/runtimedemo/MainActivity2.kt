package com.example.runtimedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.appizona.yehiahd.fastsave.FastSave
import com.example.runtimedemo.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var viewBinding:ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding= ActivityMain2Binding.inflate(LayoutInflater.from(this))
        setContentView(viewBinding.root)

        viewBinding.txt.setText("Welcome "+ FastSave.getInstance().getString("keyString",""))
        viewBinding.txt2.setText("Integer "+FastSave.getInstance().getInt("keyInt", 0))
        viewBinding.txt3.setText("Float "+FastSave.getInstance().getFloat("keyFloat", 0F))
    }
}