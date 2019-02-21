package com.example.genericty;

/****
 *一个普通的java泛型类
 * 此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
 在实例化泛型类时，必须指定T的具体类型
 * @param <T>
 */

public   class Generics<T> {
    //key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    public Generics(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

}
