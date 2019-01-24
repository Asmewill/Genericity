package disign.single.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2018/11/10
 */
public class MainTest {
    public static void main(String[] args){
        int threadCount = 50;
        for (int i = 0; i < threadCount; i++) {
            new Thread() {
                @Override
                public void run() {
                    System.out.println(SingleTon.getInstance());
                }
            }.start();
        }
    }

    public void testInputStreamReader() throws Exception {
          final String SEPARATOR = File.separator;

        File file = new File("e:" + SEPARATOR + "io" + SEPARATOR + "test.txt");
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        // 备注上面这个初始化过程就是多次使用包装来完成的,不推荐这么写,会让新手看不懂。

        //1、获得子节输入流
        FileInputStream fileInputStream=new FileInputStream(file);
        //2、构造转换流(是继承Reader的)
        InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
        //3、 构造缓冲字符流
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        bufferedReader.read();

        //备注1、2两步骤体现出了适配器模式
        //2步骤体现了InputStreamReader类具有将子节输入流转换为字符输入流的功能
        //2、3两步骤体现了装饰模式(wrapper包装模式)

    }
}
