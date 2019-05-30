package com.example.administrator.genericitydemo.kotlin

/**
 * Created by Owen on 2019/5/23
 */
class Student2 : Person2{
    constructor(name:String,age:String):super(name,age){
        println("继承类次级构造函数")
    }
}