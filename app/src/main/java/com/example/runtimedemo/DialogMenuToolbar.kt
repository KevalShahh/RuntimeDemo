package com.example.runtimedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.runtimedemo.databinding.ActivityDialogMenuToolbarBinding

class DialogMenuToolbar : AppCompatActivity() {
    var list= ArrayList<CustomModel>()
    lateinit var viewBinding: ActivityDialogMenuToolbarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityDialogMenuToolbarBinding.inflate(LayoutInflater.from(this))
        setContentView(viewBinding.root)
        var textName = arrayOf(
            "none",
            "Callisto",
            "Garrymede",
            "Luna",
            "Oberon",
            "Phobos",
            "Diaono",
            "Ring",
            "none",
            "Callisto",
            "Garrymede",
            "Luna",
            "Oberon",
            "Phobos",
            "Diaono",
            "Ring",
            "none",
            "Callisto",
            "Garrymede",
            "Luna",
            "Oberon",
            "Phobos",
            "Diaono",
            "Ring"
        )
        for (i in 1..textName.size-1) {
            list[i].NameText= textName[i]
            list[i].isChecked=false
        }
        viewBinding.btnRing.setOnClickListener {
            var dialogView =
                LayoutInflater.from(this).inflate(R.layout.activity_dialog_design, null)

            var rv = dialogView.findViewById<RecyclerView>(R.id.rv)
            var adapter = CustomRecyclerAdapter(this, list)
            rv.adapter = adapter
            rv.layoutManager = LinearLayoutManager(this)
            var dialog = AlertDialog.Builder(this).setView(dialogView).setTitle("Phone Ringtone")
                .setPositiveButton("OK") { _, _ ->
                    Toast.makeText(
                        this,
                        "Selected : " + adapter.arraylist.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                    /*var radioGroup=dialogView.findViewById<RadioGroup>(R.id.radiogrp)
                    var button=radioGroup.checkedRadioButtonId
                    var text=radioGroup.findViewById<RadioButton>(button)
                    Toast.makeText(this, "Selected : "+text.text, Toast.LENGTH_SHORT).show()*/
                }.setNegativeButton("Cancel", null)
            dialog.show()
        }

        viewBinding.btnOpen.setOnClickListener {
            AlertDialog.Builder(this).setTitle("Hey Wait")
                .setMessage("Are you sure you want to destroy it ?")
                .setPositiveButton("Yes") { _, _ ->
                    Toast.makeText(this, "Start Destroying", Toast.LENGTH_SHORT).show()
                }.setNegativeButton("No") { _, _ ->
                    Toast.makeText(this, "Good decision", Toast.LENGTH_SHORT).show()
                }.show()
        }
        viewBinding.menu.setOnClickListener {
            Toast.makeText(this, "menu clicked", Toast.LENGTH_SHORT).show()
        }
        viewBinding.btnPopup.setOnClickListener {
            var popup = PopupMenu(this, viewBinding.btnPopup)
            popup.menuInflater.inflate(R.menu.popup_menu, popup.menu)
            popup.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.item_color -> {
                        Toast.makeText(this, "color changed", Toast.LENGTH_SHORT).show()
                    }
                    R.id.item_font -> {
                        Toast.makeText(this, "font changed", Toast.LENGTH_SHORT).show()
                    }
                }
                true
            }
            popup.show()
        }
        viewBinding.btnCustom.setOnClickListener {
            var dialogview =
                LayoutInflater.from(this).inflate(R.layout.activity_custom_dialog, null)
            var dialog = AlertDialog.Builder(this).setView(dialogview).create()
            dialog.show()
            dialogview.findViewById<Button>(R.id.btn_1).setOnClickListener {
                Toast.makeText(this, "Selected : Yes", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            dialogview.findViewById<Button>(R.id.btn_2).setOnClickListener {
                Toast.makeText(this, "Selected : No", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_home -> {
                Toast.makeText(this, "home selected", Toast.LENGTH_SHORT).show()
            }
            R.id.item_settings -> {
                Toast.makeText(this, "settings selected", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}