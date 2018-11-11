package com.example.genericty;

import java.util.ArrayList;
import java.util.List;

/***
 *
 * 泛型博客分析
 * https://blog.csdn.net/s10461/article/details/53941091
 */
public class GenericsTest {
    public static void main(String[] args){
        /***
         *      1.  一个栗子
         一个被举了无数次的例子：
         ava.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
//        List arrayList = new ArrayList();
//        arrayList.add("aaaa");
//        arrayList.add(100);
//        for(int i = 0; i< arrayList.size();i++){
//            String item = (String)arrayList.get(i);
//            System.out.println("泛型测试---item = " + item);
//        }

        /***
         * 2. 特性
         泛型只在编译阶段有效。看下面的代码：
         */

        List<String> stringList=new ArrayList<>();
        List<Integer> integerList=new ArrayList<>();
        if(stringList.getClass().equals(integerList.getClass())){
            //如果输出乱码，需要将文件设置成GB2312编码格式
            System.out.println("类型相同--->证明了泛型只是在编译阶段有效,编译成字节码就无效了");
        }
        /****
         * 3.1泛型类
         * 泛型类型用于类的定义中，被称为泛型类。
         * 通过泛型可以完成对一组类的操作对外开放相同的接口。最典型的就是各种容器类，
         * 如：List、Set、Map。
         * 泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
         * 传入的实参类型需与泛型的类型参数类型相同，即为Integer.
         */
        Generics<Integer> integerGenerics=new Generics<>(123456);
        Generics<String>  stringGenerics=new Generics<>("one_two_three_four_five_six");
        System.out.println("key is "+integerGenerics.getKey());
        System.out.println("key is "+stringGenerics.getKey());

        /****
         * 3.2泛型类
         * 定义的泛型类，就一定要传入泛型类型实参么？并不是这样，在使用泛型的时候如果传入泛型实参，
         * 则会根据传入的泛型实参做相应的限制，此时泛型才会起到本应起到的限制作用。
         * 如果不传入泛型类型实参的话，在泛型类中使用泛型的方法或成员变量定义的类型可以为任何的类型。
         */
        Generics generics1=new Generics(111111);
        Generics generics2=new Generics("one_two_three_four_five_six");
        Generics generics3=new Generics(false);
        Generics generics4=new Generics(11.00f);
        System.out.println("key is "+generics1.getKey());
        System.out.println("key is "+generics2.getKey());
        System.out.println("key is "+generics3.getKey());
        System.out.println("key is "+generics4.getKey());
        /****
         * 4. 泛型接口
         泛型接口与泛型类的定义及使用基本相同。泛型接口常被用在各种类的生产器中，可以看一个例子：
         详见：FruitGenerator
         */

        /******
         * 5.泛型通配符
         */
        Generics<Integer> integerG=new Generics<>(345);
        Generics<Float>  numberG=new Generics<>(678f);
        showKeyValue(integerG);
        showKeyValue(numberG);

        /****
         * 6.泛型方法
         *泛型类，是在实例化类的时候指明泛型的具体类型；泛型方法，是在调用方法的时候指明泛型的具体类型
         *详见FruitGenerator
         */
        /**
         * 这才是一个真正的泛型方法。
         * 首先在public与返回值之间的<T>必不可少，这表明这是一个泛型方法，并且声明了一个泛型T
         * 这个T可以出现在这个泛型方法的任意位置.
         * 泛型的数量也可以为任意多个
         *    如：public <T,K> K showKeyName(Generic<T> container){
         *        ...
         *        }
         */


        /****
         *
         * 7.在使用泛型的时候，
         * 我们还可以为传入的泛型类型实参进行上下边界的限制，
         * 如：类型实参只准传入某种类型的父类或某种类型的子类。
         * 泛型上下边界
         *
         */
     //   Generic<String> stringGeneric=new Generic<>("1111");
          Generic<Integer>  integerGeneric=new Generic<>(111);
          Generic<Float> floatGeneric=new Generic<>(222f);
          Generic<Double> doubleGeneric=new Generic<>(12.00);





    }


    public static  void showKeyValue(Generics<?> obj){
        System.out.println("key value is :"+obj.getKey());
    }


}
