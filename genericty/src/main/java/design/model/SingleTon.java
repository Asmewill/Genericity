package design.model;

/**
 * Created by Administrator on 2018/11/10
 * https://www.cnblogs.com/android-blogs/p/5530239.html
 */
public class SingleTon {
    private  SingleTon(){}
    //懒汉式
    private static SingleTon instance=null;
    public static SingleTon getInstance(){
        if(instance==null){
//            synchronized (SingleTon.class){
                if(instance==null){
                 instance=new SingleTon();
                }
//            }

        }
        return instance;
    }
    //饿汉式
   // https://blog.csdn.net/xlantian/article/details/80963640//放到内部类里面
    private static SingleTon instance1=new SingleTon();
    public static SingleTon getInstance1(){
       return instance1;
    }


}
