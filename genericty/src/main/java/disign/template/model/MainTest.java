package disign.template.model;

/**
 * Created by Administrator on 2018/11/10
 *http://baijiahao.baidu.com/s?id=1601547440739500969&wfr=spider&for=pc
 */
public class MainTest {
    public static void main(String[] args){
        //A收货人正常签收
        Postman postmanA=new PostmanA();
        postmanA.post();
        //B收货人拒绝签收
        Postman postmanB=new PostmanB();
        postmanB.post();
    }
}
