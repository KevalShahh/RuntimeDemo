package com.example.runtimedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.runtimedemo.databinding.ActivityImagebuttonDemoBinding

class imagebuttonDemo : AppCompatActivity() {
    lateinit var viewBinding:ActivityImagebuttonDemoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding= ActivityImagebuttonDemoBinding.inflate(LayoutInflater.from(this))
        setContentView(viewBinding.root)

        viewBinding.imageButton.setOnClickListener {
            Toast.makeText(this, "Indian Flag", Toast.LENGTH_SHORT).show()
        }
        viewBinding.imgview.setOnClickListener {
            Toast.makeText(this, "USA flag", Toast.LENGTH_SHORT).show()
        }
    }
}