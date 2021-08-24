package com.example.runtimedemo

import android.app.Application
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.appizona.yehiahd.fastsave.FastSave
import com.example.runtimedemo.databinding.ActivitySharedPreferenceDemoBinding

class SharedPreferenceDemo : AppCompatActivity() {
    lateinit var viewBinding:ActivitySharedPreferenceDemoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding= ActivitySharedPreferenceDemoBinding.inflate(LayoutInflater.from(this))
        setContentView(viewBinding.root)
        FastSave.init(applicationContext)

        viewBinding.btnSave.setOnClickListener {
            FastSave.getInstance().saveString("keyString",viewBinding.edt.text.toString())
            FastSave.getInstance().saveInt("keyInt",Integer.parseInt(viewBinding.edt2.text.toString()))
            FastSave.getInstance().saveFloat("keyFloat",(viewBinding.edt3.text.toString()).toFloat())
            startActivity(Intent(this,MainActivity2::class.java))
        }
    }
}