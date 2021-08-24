package com.example.runtimedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.runtimedemo.databinding.ActivitySpinnerDemoBinding

class SpinnerDemo : AppCompatActivity() {
    lateinit var viewBinding:ActivitySpinnerDemoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding= ActivitySpinnerDemoBinding.inflate(LayoutInflater.from(this))
        setContentView(viewBinding.root)

        var images= arrayOf(R.drawable.india,R.drawable.usa,R.drawable.china,R.drawable.germany)
        var name= arrayOf("India","Usa","China","Germany")

        var spinnerAdapter=customspinnerAdapter(this,images,name)
        viewBinding.spinner.adapter=spinnerAdapter

        var adapter=ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,name)
        viewBinding.spinnerNormal.adapter=adapter


    }
}