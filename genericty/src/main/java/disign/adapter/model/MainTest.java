package disign.adapter.model;

/**
 * Created by Administrator on 2018/11/10
 * https://www.cnblogs.com/V1haoge/p/6479118.html
 */
public class MainTest {
    public static void main(String[] args){
        //1.类适配，通过继承类适配
        AdapterOne adapterOne=new AdapterOne();
        adapterOne.isPs2();
        //2.对象适配，通过组合实现
        Usber usber=new Usber();
        AdapterTwo adapterTwo=new AdapterTwo(usber);
        adapterTwo.isPs2();
        //3.接口适配，通过抽象类实现
        A aRealize=new MyAdapter();
        aRealize.a();
        aRealize.b();

    }
}
