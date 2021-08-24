package com.example.runtimedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.runtimedemo.databinding.ActivityDialogDesignBinding

class dialog_design : AppCompatActivity(){
    lateinit var viewBinding: ActivityDialogDesignBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityDialogDesignBinding.inflate(LayoutInflater.from(this))
        setContentView(viewBinding.root)
    }
}