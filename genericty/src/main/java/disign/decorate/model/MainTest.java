package disign.decorate.model;

/**
 * https://www.jianshu.com/u/dc1e37336946
 * Created by Administrator on 2018/11/10
 * https://blog.csdn.net/z4909801/article/details/59059263
 * 装饰模式就是给一个对象增加一些新的功能，而且是动态的，
 * 要求装饰对象和被装饰对象实现统一接口或者继承同一个父类，装饰对象持有被装饰对象的实例。
 * https://www.jianshu.com/p/df1a96c5c046
 */
public class MainTest {

    public static void main(String[] args){
        Food food=new Food("香肠");
        Bread bread=new Bread(food);
        Cream cream=new Cream(bread);
        Vegetable vegetable=new Vegetable(cream);
        System.out.print("运行结果："+vegetable.make()+"\n");
    }
}
