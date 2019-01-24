package disign.prototype.model;

/**
 * Created by Administrator on 2018/11/10
 * https://www.jianshu.com/p/6d1333917ae5
 */
public class MainTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Card card1=new Card();
        card1.setNum(111);
        card1.setSpec(66,67);
        System.out.println(card1.toString());
        System.out.println("---------------------");
        //拷贝
        Card card2=card1.clone();
        System.out.println(card2.toString());
        System.out.println("---------------------");
        //拷贝之后，card2对num进行重新赋值
        card2.setNum(222);
        System.out.println(card1.toString());
        System.out.println(card2.toString());
        System.out.println("---------------------");
        //拷贝之后，card2对Spec进行重新赋值之后，连card1也跟着改变了，这种就是浅拷贝
        card2.setSpec(76,77);
        System.out.println(card1.toString());
        System.out.println(card2.toString());
        System.out.println("---------------------");







    }
}
