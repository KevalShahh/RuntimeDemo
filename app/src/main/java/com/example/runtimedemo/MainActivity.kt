package com.example.runtimedemo

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import com.example.runtimedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityMainBinding
    var permissions = arrayOf(
        android.Manifest.permission.CAMERA,
        android.Manifest.permission.ACCESS_FINE_LOCATION
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(viewBinding.root)

        viewBinding.btnCamera.setOnClickListener {
            if (!hasPermissions(this, permissions)
            ) {
                request()
            }
        }
    }

    fun hasPermissions(context: Context, vararg permissions: Array<String>): Boolean =
        permissions.all {
            ActivityCompat.checkSelfPermission(
                context,
                it.toString()
            ) == PackageManager.PERMISSION_GRANTED
        }

    private fun request() {
        ActivityCompat.requestPermissions(this, permissions, 1)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>,
        grantResults: IntArray,
    ) {
        var granted = true
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1 -> {
                for (i in 0..(permissions.size - 1)) {
                    if (grantResults.isNotEmpty() && grantResults[i] ==
                        PackageManager.PERMISSION_GRANTED
                    ) {
                        granted = true
                    } else {
                        granted = false
                        break
                    }
                }
                if (granted == false) {
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
                    AlertDialog.Builder(this).setTitle("Alert")
                        .setMessage("This permissions are required for using this app")
                        .setPositiveButton("OK") { _, _ ->
                            request()
                        }
                        .setNegativeButton("Deny") { _, _ ->
                            Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
                        }
                        .show()
                } else {
                    Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
                }
                return
            }
        }
    }
}