package com.example.administrator.genericitydemo.kotlin

/**
 * Created by Owen on 2019/5/23
 */
open class Person2 (name:String){
    constructor(name :String,age:String):this(name){
        println("基类次级构造函数")
    }
}