package com.example.administrator.genericitydemo.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.administrator.genericitydemo.R
import com.example.administrator.genericitydemo.kotlin.*
import java.io.File
import java.io.OutputStream

class KotlinTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_test)
        /***
         * 1.函数
         */
        println("--------------1.函数-------------------")
        println("sum of 3 and 5 is "+sum(3,5))
        println("sum of 3 and 5 is "+sum2(3,5))
        println("sum of 3 and 5 is ${sum2(3,5)}")
        printSum(1,3)
        printSum2(1,3)
        read("校花的贴身高手",2011,"鱼人二代")
        read("风流黑道学生")
        read("斗破苍穹")
        addAll(1,2,3,4)
        println("--------------2.变量，常量-------------------")
        /***
         * 2.变量，常量
         */
        val a:Int=1
        var b:Int=3
        //a+=9 报错
        val c=5  //系统自动推断类型为Int
        var d=7  //系统自动推断类型为Int
        val e:Int //不初始化，必须提供类型
        var f:Int //不初始化，必须提供类型
        /****
         * 3.Null安全检查
         */
        println("-------------3.Null安全检查-----------------")
        var age:Int?=null//声明可为null
        //val age1=age!!.toInt()//为空就报异常
        val age2=age?.toInt()   //为null就返回null
        val age3=age?.toInt()?:-1 //为null就返回-1
       // println("age1="+age1)
        println("age2="+age2)
        println("age3="+age3)
        println(addNew(3,5))
        println(addNew(null,5))
        println(addNew(3,null))
        println(addNew(null,null))
        /***
         * 4.范围，条件表达式
         */
        println("-------------4.范围，条件表达式----------------")
        range()

        /***
         * 5.类对象
         */
        println("-------------5.类对象---------------")
        val cofox=Cofox("金龙移动办公",1000)
        println(cofox.Sitename)
        println(cofox.county)
        println(cofox.url)
        cofox.PrintTest()

        println("-------------5.1 内部类---------------")
        val demo=Outer.Nested().foo()
        val demo2=Outer.Nested.Thrd().mee()
        println(demo.toString()+":"+demo2)
        println("-------------5.2 匿名内部类---------------")
        var test=Test()
        println(test.v)
        test.setInterface(object :TestInterface{
            override fun test() {
                println("对象表达式创建匿名内部类实例")
            }
        })
        println("-------------5.3 类的继承---------------")
        var student2=Student2("Owen","28")
        println("-------------6 泛型-----------------")
        val box:Box<Int> =Box<Int>(1)
        val box2=Box(2)
        var boxInt:Box<Int> =Box<Int>(10)
        var boxString=Box<String>("ether")
        println(box.value)
        println(box2.value)
        println(boxInt.value)
        println(boxString.value)
        doPrintln("hello")
        doPrintln(1100.23f)
        println("-------------7 高阶函数-----------------")
        val list= listOf(1,2,3,4,5,6,7)
        val newList=list.map{ it*2+3 }
        val newList2=list.map(Int::toDouble)
        newList.forEach(::println)
        newList2.forEach(::println)
        println("-------------7 高阶函数 复杂数组-----------------")
        //复杂的数组
        var list1= listOf(1..10,2..5,1017..1028)
        //扁平化
        val flatlist=list1.flatMap {
             it.map {
                 "No.$it"
             }
        }
        list1.forEach(::println)
        flatlist.forEach(::println)
        println("-------------7 高阶函数  reduce joinToString-----------------")
        val flatList2=list1.flatMap{ it }
        val reduceList2=(1..3).reduce { acc, i ->acc+i  }//1+2+3求和
        println(flatList2)
        println(reduceList2)
        println((1..5).joinToString(","))
        println("-------------7 高阶函数 fold，foldRight，filter，filterIndexed，takeWhile 用法 -----------------")
        println((0..6).map(::factorial))// [1, 1, 2, 6, 24, 120, 720]
        println("--------------顺序----------------")
        println((0..6).map(::factorial).fold(StringBuilder()){
            acc, i ->  acc.append(i).append(",")//1,1,2,6,24,120,720,
        })
        println("----------------倒序--------------")
        println((0..6).map(::factorial).foldRight(StringBuilder()){
            i,acc ->  acc.append(i).append(",")//720,120,24,6,2,1,1,
        })
        println("----------------过滤偶数--------------")
        println((0..6).map(::factorial).filter { it % 2==0 })
        println("----------------过滤奇数位上的数字--------------")
        println((0..6).map(::factorial).filterIndexed { index, i ->  index%2==1 })
        println("---------------取得符合条件的，当不符合条件就停止-------------")
        println((0..6).map(::factorial).takeWhile { it % 2==1 })
        println("-------------8 闭包 把函数当作参数和返回值来用-----------------")
        val x=makeFun()
        println(x())
        println(x())
        println(x())
        println("-------------9 科理化Currying-----------------")
        log("joel",System.out,"访问了首页。")
        log("Smith")(System.out)("访问了次页。")
        println("-------------10 kotlin实现统计文件字符个数-----------------")
        var intent=Intent(this,SQLiteDemoActivity::class.java)

    }

    fun myIO1(){
        val file = File("build.gradle")
//    println(file.readLines())     //一行输出
        file.readLines().forEach(::println)     //逐行输出
    }
    fun testkotlin(){
        val file="E:\\test\\test.txt"
        val map=HashMap<Char,Int>()
        File(file).readText().toCharArray().filterNot(Char::isWhitespace).forEach{
            val count =map[it]
            if(count==null){
                map[it]=1
            }else{
                map[it]=count+1
            }
        }
        map.forEach { key, value ->
            println("字符 $key 出现了 $value 次")
        }
    }

    fun log(tag:String,target:OutputStream,message:Any?){
        target.write("[$tag]$message\n".toByteArray())
    }
    fun log(tag:String)
            =fun(target:OutputStream)
            =fun(message: Any?)=target.write("[$tag]$message\n".toByteArray())

    fun makeFun():()->Int{
        var count=0
        return fun():Int{
            //println(++count)
            return ++count;
        }
    }

    /**
     * 阶乘
     */
    fun factorial(n:Int):Int{
        if(n==0){
           return 1
        }
        return (1..n).reduce { acc, i ->acc*i  }
    }

    fun <T> doPrintln(content :T){
        when(content){
            is Int-> println("Int 类型数字为：$content")
            is String -> println("String 类型数字为:$content")
            else -> println("$content 不是Int也不是String类型")
        }

    }
    fun range(){
        println("--------------step-------------------")
        for(i in 0..10 step 2){//从小到大
          println(i)
        }
        println("----------downTo step-----------------------")
        for(i in 10 downTo 1 step 2){//从大到小
            println(i)
        }
        println("--------------until-------------------")
        for(i in 0 until 10){//从小到大去除末位
            println(i)
        }
        println("--------------until step-------------------")
        for(i in 0 until 10 step 2){//从小到大去除末尾，步长为2
            println(i)
        }
        println("--------------when -------------------")
       var x=1
        when(x){
            1-> println("x==1")
            2-> println("x==2")
            3,4,5-> println("x 在3，4，5中")
            else ->{
                println("x 不是1到5中的任意一个数")
            }
        }
        println("--------------when in-------------------")
        when(x){
            in 1..5-> println("x在1-5中")
            in 6..10-> println("x在6-10中")
            !in 10..99-> println("x 不在10-99中")
            else ->{
                println("x搞不清楚在哪里哟")
            }
        }
        println("--------------when 表达式-------------------")
        var yy=111
        var zz=101
        when {
            yy>99 -> println("yy>99")
            zz>99-> println("zz>99")
        }
        println("--------------for循环遍历数组style1-------------------")
        var items= listOf("apples" ,"banana","melon")
        for(index in items.indices){
            println("item at $index is ${items[index]}")
        }
        println("--------------for循环遍历数组style2-------------------")
        for(item in items){
            println(item)
        }
    }



    fun addNew(x:Int ?,y:Int ?):Int?{
         if(x!=null&&y!=null){
             return x+y
         }else if(x!=null){
             return x
         }else if(y!=null){
             return y
         }
        return null
    }

    /**
     * 可变长参数
     */
    fun addAll(vararg x:Int):Int{
        var result=0;
        for(vt in x){
            result+=vt
        }
        return result
    }
    /***
     * 参数有默认值的函数
     */
    fun read(bookName:String,publishYear:Int=2018,author:String="管俊波"){
        println("《 $bookName 》是 $author 在 $publishYear 的大作")
    }
    /***
     * 有返回值
     */
    fun sum(a:Int ,b:Int):Int{
        return a+b
    }
    /***
     * 表达式作为函数体、返回值类型自动推断的函数
     */
    fun sum2(a:Int ,b:Int)=a+b

    /**
     * 无返回值
     */
    fun printSum2(x:Int ,y:Int){
        println("sum of $x and $y is ${x+y}")
    }

    /**
     *返回值无意义
     */
    fun printSum(x:Int ,y:Int):Unit{
        println("sum of $x and $y is ${x+y}")
    }



}
