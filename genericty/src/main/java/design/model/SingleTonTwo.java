package design.model;

/**
 * Created by Administrator on 2018/11/10
 * https://www.cnblogs.com/android-blogs/p/5530239.html
 */
public class SingleTonTwo {
    private SingleTonTwo(){}
    //懒汉式
    private static SingleTonTwo instance=null;
    //锁住代码块
    public static SingleTonTwo getInstance(){
        if(instance==null){
            synchronized (SingleTonTwo.class){
                if(instance==null){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance=new SingleTonTwo();
                }
          }
        }
        return instance;
    }
    //锁住方法
    public static SingleTonTwo getInstance1(){
        if(instance==null){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance=new SingleTonTwo();
        }
        return  instance;
    }



    //饿汉式
   // https://blog.csdn.net/xlantian/article/details/80963640//放到内部类里面
    private static SingleTonTwo instance2=new SingleTonTwo();
    public static SingleTonTwo getInstance2(){
       return instance2;
    }

    private static  class SingleTonHolder{
        private final static SingleTonTwo instance=new SingleTonTwo();
    }
    public static SingleTonTwo getInstance3() {
        return SingleTonHolder.instance;
    }

}
