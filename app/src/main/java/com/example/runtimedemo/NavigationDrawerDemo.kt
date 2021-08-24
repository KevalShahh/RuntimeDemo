package com.example.runtimedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.example.runtimedemo.databinding.ActivityNavigationDrawerDemoBinding

class NavigationDrawerDemo : AppCompatActivity() {
    lateinit var viewBinding:ActivityNavigationDrawerDemoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding= ActivityNavigationDrawerDemoBinding.inflate(LayoutInflater.from(this))
        setContentView(viewBinding.root)

        setSupportActionBar(viewBinding.toolbarNav)
        var drawerToggle=ActionBarDrawerToggle(this,viewBinding.drawer,R.string.open,R.string.close)
        viewBinding.drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                viewBinding.drawer.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}