package com.example.runtimedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.example.runtimedemo.databinding.ActivityFragmentDemoBinding

class FragmentDemo : AppCompatActivity(),Communicator {
    lateinit var viewBinding:ActivityFragmentDemoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding= ActivityFragmentDemoBinding.inflate(LayoutInflater.from(this))
        setContentView(viewBinding.root)

        supportFragmentManager.beginTransaction().replace(R.id.frame,SignUpFragment()).commit()
        /*viewBinding.btnLog.setOnClickListener {
            if (findViewById<EditText>(R.id.edit_name).text.isEmpty()){
                Toast.makeText(this, "First write name in signup page", Toast.LENGTH_SHORT).show()
            }
            else supportFragmentManager.beginTransaction().replace(R.id.frame,LoginFragment()).commit()
        }*/
        viewBinding.btnSign.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.frame,SignUpFragment()).commit()
        }
    }

    override fun passData(editTextInput: String) {
        val transaction = this.supportFragmentManager.beginTransaction()
        val frag2 = LoginFragment()
        val bundle = Bundle()
        bundle.putString("Name", editTextInput)
        frag2.arguments = bundle
        transaction.replace(R.id.frame, frag2)
        transaction.commit()
    }
}