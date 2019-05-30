package com.example.administrator.genericitydemo.kotlin

/**
 * Created by Owen on 2019/5/23
 */
class Cofox constructor(name:String){
    var url="http://www.baidu.com"
    var county="CHINA"
    var Sitename=name

    init {
        println("初始化网络名称:$name")
    }
    constructor(name :String,alexa:Int):this(name){
        println("Alexa 排名 $alexa")
    }
    fun PrintTest():Unit{
        println("我是类函数")
    }
}