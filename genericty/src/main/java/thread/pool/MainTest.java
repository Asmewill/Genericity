package thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018/11/10
 * https://www.cnblogs.com/ljp-sun/p/6580147.html
 * https://blog.csdn.net/l540675759/article/details/62230562
 */
public class MainTest {
    public static void main(String[] args){

//        //�̳߳���ֻ����ͬʱ����2���߳�
//        System.out.println("****************************newFixedThreadPool*******************************");
//        ExecutorService newFixedThreadPool=Executors.newFixedThreadPool(2);
//        for(int j=0;j<4;j++){
//            final  int index=j;
//            newFixedThreadPool.execute(new MyRunnable(index));
//        }
//
//
//        //����һ�������̳߳�,��ʱִ��ĳ������
//        System.out.println("****************************newScheduleThreadPool*******************************");
//        ScheduledExecutorService newScheduleThreadPool= Executors.newScheduledThreadPool(2);
//        for(int k=0;k<4;k++){
//           final  int index=k;
//            //ִ�н�����ӳ�����֮��ִ�У������ӳ�ִ��֮���newFixedThreadPool������ͬ����������ִ�ж�ʱ����
//            newScheduleThreadPool.schedule(new MyRunnable(index),3, TimeUnit.SECONDS);
//        }


        System.out.println("****************************newCachedThreadPool*******************************");
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        for(int i=0;i<4;i++) {
            final int index=i;
            newCachedThreadPool.execute(new MyRunnable(index));
        }


//        System.out.println("****************************newSingleThreadExecutor*******************************");
//        ExecutorService newSingleThreadExtutor=Executors.newSingleThreadExecutor();
//        for(int l=0;l<4;l++){
//            final int index=l;
//            //ִ�н����ֻ����һ���̣߳�˳��ִ��
//            newSingleThreadExtutor.execute(new MyRunnable(index));
//        }
    }
}
