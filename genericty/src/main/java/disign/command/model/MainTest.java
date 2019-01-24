package disign.command.model;

/**
 * Created by Administrator on 2018/11/10
 * https://www.jianshu.com/p/ff909f9d925f
 */
public class MainTest {
    public static void main(String[] args){
       Receiver receiver=new Receiver();//创建命令接收者
       Command command=new ShutDownCommand(receiver);//创建一个命令的具体实现对象，并指定命令接收者
       Invoker invoke=new Invoker(command);//创建一个命令调用者，并指定具体命令
       invoke.action();
    }
}
