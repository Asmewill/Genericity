package chain.model;

/**
 * Created by Administrator on 2018/11/10
 * https://blog.csdn.net/u012810020/article/details/71194853
 */
public class MainTest {
    public static void main(String[] args){
        //写法一
        Request.Builder builder=new Request.Builder();//通过静态内部类构建builder对象
        builder.setName("zhangsan");
        builder.setDays("5");
        builder.setReason("事假");
        Request request=builder.build();//build方法返回request对象
        //写法二
        Request request1=new Request.Builder().setName("lisi").setDays("7").setReason("事假").build();
        //System.out.print("结果："+request.toString());

        ChainOfResponsibilityClient client=new ChainOfResponsibilityClient();
        client.addRatifys(new CustomInterceptor());
        Result result=client.execute(request);
        System.out.println("结果:"+result.toString());

    }
}
