package com.example.runtimedemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView

class CustomRecyclerAdapter(var context: Context, var textName: ArrayList<CustomModel>) :
    RecyclerView.Adapter<CustomRecyclerAdapter.CustomViewHolder>() {
    //var lastCheckedPosition=-1
    public var arraylist=ArrayList<String>()

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name = itemView.findViewById<CheckBox>(R.id.radio_button)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.activity_custom_radio_layout, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.name.text = textName[position].NameText

        holder.name.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
//                arraylist.add(textName[position].NameText)
                textName[position].isChecked==true
            }
            else textName[position].isChecked==false
        }
        if (textName[position].isChecked==true){
            arraylist.add(textName[position].NameText)
        }
        else arraylist.remove(textName[position].NameText)
/*        holder.name.setChecked(position==lastCheckedPosition)
        holder.name.setOnClickListener {
            if (position==lastCheckedPosition){
                holder.name.setChecked(false)
                lastCheckedPosition=-1
            }else{
                lastCheckedPosition=position
                notifyDataSetChanged()
                Toast.makeText(context, "Selected : "+textName[position], Toast.LENGTH_SHORT).show()
            }
        }*/
    }
    override fun getItemCount(): Int {
        return textName.size
    }
}
