package disign.share.model;

/**
 * Created by Administrator on 2018/11/10
 * https://www.jianshu.com/p/6d1333917ae5
 */
public class MainTest {
    public static void main(String[] args) {
        ShareBikeFactory shareBikeFactory=new ShareBikeFactory();
        //第一次骑ofo，交押金
        IBike ofo1=shareBikeFactory.getBike("ofo");
        ofo1.ride(2);
        //第一次骑mobike，交押金
        IBike mobike=shareBikeFactory.getBike("mobike");
        mobike.ride(3);
        //第二次骑mobike，不交押金
        IBike ofo2=shareBikeFactory.getBike("ofo");
        ofo2.ride(4);
    }
}
