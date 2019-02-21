package disign.memo.model;

/**
 * Created by Administrator on 2018/11/10
 * https://www.cnblogs.com/luohanguo/p/7825656.html
 */
public class MainTest {
    public static void main(String[] args){
        Game game=new Game();
        game.paly();
        CreateMemo createMemo=new CreateMemo();
        createMemo.setMemo(game.createMemo());//游戏存档
        game.exit();
        //第二次进入游戏
        System.out.println("第二次进入游戏");
        Game secondGame=new Game();
        secondGame.setMemo(createMemo.getMemo());//取出之前备忘录中的数据
        secondGame.paly();
        secondGame.exit();
    }
}
