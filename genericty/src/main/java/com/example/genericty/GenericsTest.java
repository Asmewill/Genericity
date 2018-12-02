package com.example.genericty;

import java.util.ArrayList;
import java.util.List;

/***
 *
 * ���Ͳ��ͷ���
 * https://blog.csdn.net/s10461/article/details/53941091
 */
public class GenericsTest {
    public static void main(String[] args){
        /***
         *      1.  һ������
         һ�������������ε����ӣ�
         ava.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
//        List arrayList = new ArrayList();
//        arrayList.add("aaaa");
//        arrayList.add(100);
//        for(int i = 0; i< arrayList.size();i++){
//            String item = (String)arrayList.get(i);
//            System.out.println("���Ͳ���---item = " + item);
//        }

        /***
         * 2. ����
         ����ֻ�ڱ���׶���Ч��������Ĵ��룺
         */

        List<String> stringList=new ArrayList<>();
        List<Integer> integerList=new ArrayList<>();
        if(stringList.getClass().equals(integerList.getClass())){
            //���������룬��Ҫ���ļ����ó�GB2312�����ʽ
            System.out.println("������ͬ--->֤���˷���ֻ���ڱ���׶���Ч,������ֽ������Ч��");
        }
        /****
         * 3.1������
         * ��������������Ķ����У�����Ϊ�����ࡣ
         * ͨ�����Ϳ�����ɶ�һ����Ĳ������⿪����ͬ�Ľӿڡ�����͵ľ��Ǹ��������࣬
         * �磺List��Set��Map��
         * ���͵����Ͳ���ֻ���������ͣ������Զ����ࣩ�������Ǽ�����
         * �����ʵ���������뷺�͵����Ͳ���������ͬ����ΪInteger.
         */
        Generics<Integer> integerGenerics=new Generics<>(123456);
        Generics<String>  stringGenerics=new Generics<>("one_two_three_four_five_six");
        System.out.println("key is "+integerGenerics.getKey());
        System.out.println("key is "+stringGenerics.getKey());

        /****
         * 3.2������
         * ����ķ����࣬��һ��Ҫ���뷺������ʵ��ô����������������ʹ�÷��͵�ʱ��������뷺��ʵ�Σ�
         * �����ݴ���ķ���ʵ������Ӧ�����ƣ���ʱ���ͲŻ��𵽱�Ӧ�𵽵��������á�
         * ��������뷺������ʵ�εĻ����ڷ�������ʹ�÷��͵ķ������Ա������������Ϳ���Ϊ�κε����͡�
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
         * 4. ���ͽӿ�
         ���ͽӿ��뷺����Ķ��弰ʹ�û�����ͬ�����ͽӿڳ������ڸ�������������У����Կ�һ�����ӣ�
         �����FruitGenerator
         */

        /******
         * 5.����ͨ���
         */
        Generics<Integer> integerG=new Generics<>(345);
        Generics<Float>  numberG=new Generics<>(678f);
        showKeyValue(integerG);
        showKeyValue(numberG);

        /****
         * 6.���ͷ���
         *�����࣬����ʵ�������ʱ��ָ�����͵ľ������ͣ����ͷ��������ڵ��÷�����ʱ��ָ�����͵ľ�������
         *���FruitGenerator
         */
        /**
         * �����һ�������ķ��ͷ�����
         * ������public�뷵��ֵ֮���<T>�ز����٣����������һ�����ͷ���������������һ������T
         * ���T���Գ�����������ͷ���������λ��.
         * ���͵�����Ҳ����Ϊ������
         *    �磺public <T,K> K showKeyName(Generic<T> container){
         *        ...
         *        }
         */


        /****
         *
         * 7.��ʹ�÷��͵�ʱ��
         * ���ǻ�����Ϊ����ķ�������ʵ�ν������±߽�����ƣ�
         * �磺����ʵ��ֻ׼����ĳ�����͵ĸ����ĳ�����͵����ࡣ
         * �������±߽�
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
