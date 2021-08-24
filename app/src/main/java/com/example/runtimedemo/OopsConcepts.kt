package com.example.runtimedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.lang.Exception
import kotlin.properties.Delegates

//inheritance
open class OopsConcepts : AppCompatActivity() {
    //lateinit
    var ask by Delegates.notNull<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        //super
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oops_concepts)

        ask=5
        println(ask)
        val items = listOf("apple", "banana", "kiwifruit")
        var index = 0
        var num=getNumber(5)
        Log.d("TAG", "onCreate: "+num)
        //while loop
        while (index < items.size) {
            Log.d("TAG", "onCreate: "+index)
            println("item at $index is ${items[index]}")
            index++
        }
        //for loop with range
        for (x in 1..5) {
            println(x)
        }
        println(oops())
        println(oops("hi"))
        //for and when loop with "in"
        for (item in items) {
            println(item)
        }
        when {
            "orange" in items -> println("juicy")
            "apple" in items -> println("apple is fine too")
        }
        //filter and map
        val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
        fruits
            .filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.uppercase() }
            .forEach { println(it) }
    }
    fun getNumber(num:Int):String{
        return try {
            var a=num/1
            "$a"
        } catch (e:Exception){
            println("fail"+e.message)
            "fail"
        }
    }
    //when loop
    fun describe(obj: Any): String =
        when (obj) {
            1          -> "One"
            "Hello"    -> "Greeting"
            is Long    -> "Long"
            !is String -> "Not a string"
            else       -> "Unknown"
        }
    //polymorphism
    fun oops():Int{
        var i=5
        return i
        println(i)
    }
    // overloading
    //final
    final fun oops(string: String){
        var s="name"
        println(s)
        println(string)
    }
    //overriding
   /* fun oops(id: Int): Int {
        var i=10
        return i
        println(i)
    }*/
    //abstraction
    abstract class oop  {
        abstract fun method1()
        fun method2():String{
            var s="non-abstract method"
            return s
        }
    }
    //emcapsulation
    var f:Int=1
    public fun ff() {
       fun getData(): Int {
            return@getData f
           println(f)
        }
        fun setData() {
            f=2
            println(f)
        }
    }
    //static
    class Foo {
        companion object {
            fun a() : Int = 1
        }
    }

}