package disign.single.model;

/**
 * Created by Administrator on 2018/11/10
 * https://www.cnblogs.com/android-blogs/p/5530239.html
 */
public class SingleTonThree {
    private SingleTonThree(){}
    //懒汉式
    private static SingleTonThree instance=null;
    //锁住代码块
    public static SingleTonThree getInstance(){
        if(instance==null){
            synchronized (SingleTonThree.class){
                if(instance==null){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance=new SingleTonThree();
                }
          }
        }
        return instance;
    }
    //锁住方法
    public static SingleTonThree getInstance1(){
        if(instance==null){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance=new SingleTonThree();
        }
        return  instance;
    }



    //饿汉式
   // https://blog.csdn.net/xlantian/article/details/80963640//放到内部类里面
    private static SingleTonThree instance2=new SingleTonThree();
    public static SingleTonThree getInstance2(){
       return instance2;
    }

    private static  class SingleTonHolder{
        private final static SingleTonThree instance=new SingleTonThree();
    }
    public static SingleTonThree getInstance3() {
        return SingleTonHolder.instance;
    }

}
