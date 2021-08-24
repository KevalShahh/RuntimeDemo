package com.example.runtimedemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class customspinnerAdapter(var context: Context,var images: Array<Int>,var name: Array<String>) :
    BaseAdapter() {
    override fun getCount(): Int {
        return name.size
    }

    override fun getItem(position: Int): Any {
       return name.size
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view=LayoutInflater.from(context).inflate(R.layout.spinner_design,null)
        var image=view.findViewById<ImageView>(R.id.img)
        var text=view.findViewById<TextView>(R.id.tv_name)
        image.setImageResource(images[position])
        text.setText(name[position])
        return view
    }

}