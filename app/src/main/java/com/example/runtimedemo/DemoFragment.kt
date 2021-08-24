package com.example.runtimedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.runtimedemo.databinding.ActivityDemoFragmentBinding

class DemoFragment : AppCompatActivity() {
    lateinit var viewBinding:ActivityDemoFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding= ActivityDemoFragmentBinding.inflate(LayoutInflater.from(this))
        setContentView(viewBinding.root)

        viewBinding.btnFragment1.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.frame_1,Fragment1()).commit()
        }

    }
}