package design.model;

/**
 * Created by Administrator on 2018/11/10
 * https://www.cnblogs.com/android-blogs/p/5530239.html
 */
public class SingleTonFour {
    private SingleTonFour(){}
    //懒汉式
    private static SingleTonFour instance=null;
    //锁住代码块
    public static SingleTonFour getInstance(){
        if(instance==null){
            synchronized (SingleTonFour.class){
                if(instance==null){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance=new SingleTonFour();
                }
          }
        }
        return instance;
    }
    //锁住方法
    public static SingleTonFour getInstance1(){
        if(instance==null){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance=new SingleTonFour();
        }
        return  instance;
    }



    //饿汉式
   // https://blog.csdn.net/xlantian/article/details/80963640//放到内部类里面
    private static SingleTonFour instance2=new SingleTonFour();
    public static SingleTonFour getInstance2(){
       return instance2;
    }

    private static  class SingleTonHolder{
        private final static SingleTonFour instance=new SingleTonFour();
    }
    public static SingleTonFour getInstance3() {
        return SingleTonHolder.instance;
    }

}
