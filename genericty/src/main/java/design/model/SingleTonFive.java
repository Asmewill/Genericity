package design.model;

/**
 * Created by Administrator on 2018/11/10
 * https://www.cnblogs.com/android-blogs/p/5530239.html
 */
public class SingleTonFive {
    private SingleTonFive(){}
    //懒汉式
    private static SingleTonFive instance=null;
    //锁住代码块
    public static SingleTonFive getInstance(){
        if(instance==null){
            synchronized (SingleTonFive.class){
                if(instance==null){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance=new SingleTonFive();
                }
          }
        }
        return instance;
    }
    //锁住方法
    public static SingleTonFive getInstance1(){
        if(instance==null){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance=new SingleTonFive();
        }
        return  instance;
    }



    //饿汉式
   // https://blog.csdn.net/xlantian/article/details/80963640//放到内部类里面
    private static SingleTonFive instance2=new SingleTonFive();
    public static SingleTonFive getInstance2(){
       return instance2;
    }

    private static  class SingleTonHolder{
        private final static SingleTonFive instance=new SingleTonFive();
    }
    public static SingleTonFive getInstance3() {
        return SingleTonHolder.instance;
    }

}
