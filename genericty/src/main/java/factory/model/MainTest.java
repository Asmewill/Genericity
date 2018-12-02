package factory.model;

/**
 * Created by Administrator on 2018/11/10
 */
public class MainTest {
    public static void main(String[] args){
        SendFactoryOne sendFactoryOne=new SendFactoryOne();
        sendFactoryOne.produce("mail");
        sendFactoryOne.produce("sms");

         SendFactoryTwo sendFactoryTwo=new SendFactoryTwo();
         sendFactoryTwo.produceMail();
         sendFactoryTwo.produceSms();

         SendFactoryThree.produceMail();
         SendFactoryThree.produceSms();

         Provider provider=new SendMailFactory();
         Sender sender=provider.produce();
         sender.send();

         Provider provider1=new SendSmsFactory();
         Sender sender1=provider1.produce();
         sender1.send();
    }
}
