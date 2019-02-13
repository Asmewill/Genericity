package disign.adapter.model;

/**
 * Created by Administrator on 2018/11/10
 * https://www.cnblogs.com/V1haoge/p/6479118.html
 */
public class MainTest {
    public static void main(String[] args){
        //3.接口适配，通过抽象类实现
        A aRealize=new MyAdapter();
        aRealize.a();
        aRealize.b();

    }
}
