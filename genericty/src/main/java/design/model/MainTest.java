package design.model;

/**
 * Created by Administrator on 2018/11/10
 */
public class MainTest {
    public static void main(String[] args){
       // final CountDownLatch latch = new CountDownLatch(1);
        int threadCount = 1000;
        for (int i = 0; i < threadCount; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        //latch.await();
                       // Thread.sleep(2);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(SingleTon.getInstance());
                }
            }.start();
        }
       // latch.countDown();

    }
}
