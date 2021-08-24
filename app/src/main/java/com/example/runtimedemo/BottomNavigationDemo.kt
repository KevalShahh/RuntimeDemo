package com.example.runtimedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.runtimedemo.databinding.ActivityBottomNavigationDemoBinding

class BottomNavigationDemo : AppCompatActivity() {
    lateinit var viewBinding:ActivityBottomNavigationDemoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding= ActivityBottomNavigationDemoBinding.inflate(LayoutInflater.from(this))
        setContentView(viewBinding.root)

        viewBinding.bottomNav.setOnNavigationItemSelectedListener {
            supportFragmentManager.beginTransaction().replace(R.id.frame_bottom_nav,HomeFragment()).commit()
            when(it.itemId){
                R.id.item_home->{
                    supportFragmentManager.beginTransaction().replace(R.id.frame_bottom_nav,HomeFragment()).commit()
                }
                R.id.item_profile->{
                    supportFragmentManager.beginTransaction().replace(R.id.frame_bottom_nav,ProfileFragment()).commit()
                }
                R.id.item_employee->{
                    supportFragmentManager.beginTransaction().replace(R.id.frame_bottom_nav,EmployeeFragment()).commit()
                }
                R.id.item_setting->{
                    supportFragmentManager.beginTransaction().replace(R.id.frame_bottom_nav,SettingFragment()).commit()
                }
            }
            true
        }
    }
}