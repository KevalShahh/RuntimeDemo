package com.example.runtimedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.runtimedemo.databinding.ActivityMainPageBinding

class MainPage : AppCompatActivity() {
    lateinit var viewBinding:ActivityMainPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding= ActivityMainPageBinding.inflate(LayoutInflater.from(this))
        setContentView(viewBinding.root)

        viewBinding.btnRuntime.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
        viewBinding.btnSpinner.setOnClickListener {
            startActivity(Intent(this,SpinnerDemo::class.java))
        }
        viewBinding.btnImage.setOnClickListener {
            startActivity(Intent(this,imagebuttonDemo::class.java))
        }
        viewBinding.btnOops.setOnClickListener {
            startActivity(Intent(this,OopsConcepts::class.java))
        }
        viewBinding.btnFragment.setOnClickListener {
            startActivity(Intent(this,FragmentDemo::class.java))
        }
        viewBinding.btnDemoFrag.setOnClickListener {
            startActivity(Intent(this,DemoFragment::class.java))
        }
        viewBinding.btnDialog.setOnClickListener {
            startActivity(Intent(this,DialogMenuToolbar::class.java))
        }
        viewBinding.btnLogin.setOnClickListener {
            startActivity(Intent(this,LoginScreen::class.java))
        }
        viewBinding.btnDynao.setOnClickListener {
            startActivity(Intent(this,DynaoDesign::class.java))
        }
        viewBinding.btnSignup.setOnClickListener {
            startActivity(Intent(this,SignupDesign::class.java))
        }
        viewBinding.btnHelena.setOnClickListener {
            startActivity(Intent(this,HelenaDesign::class.java))
        }
        viewBinding.btnRemo.setOnClickListener {
            startActivity(Intent(this,RemoDesign::class.java))
        }
        viewBinding.btnShared.setOnClickListener {
            startActivity(Intent(this,SharedPreferenceDemo::class.java))
        }
        viewBinding.btnNavigation.setOnClickListener {
            startActivity(Intent(this,NavigationDrawerDemo::class.java))
        }
        viewBinding.btnScreen.setOnClickListener {
            startActivity(Intent(this,ProfileScreen::class.java))
        }
        viewBinding.btnBottom.setOnClickListener {
            startActivity(Intent(this,BottomNavigationDemo::class.java))
        }
    }
}