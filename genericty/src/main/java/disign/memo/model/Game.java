package disign.memo.model;

/**
 * Created by jian.shui on 2019/1/24
 */
public class Game {
    private int mLevel=0;
    private int mIcon=0;

    /***
     * 开始游戏
     */
    public void paly(){
        System.out.print("升级了");
        mLevel++;
        System.out.println("当前等级为："+mLevel);
        mIcon+=32;
        System.out.println("获得金币："+mIcon);
        System.out.println("当前金币数量为:"+mIcon);
    }

    /***
     * 退出游戏
     */
    public void exit(){
        System.out.println("退出游戏，属性为：等级="+mLevel+",金币="+mIcon);
    }

    //创建备忘录
    public Memo createMemo(){
        Memo memo=new Memo();
        memo.setmLevel(mLevel);
        memo.setmIcon(mIcon);
        return memo;
    }

    public void setMemo(Memo memo){
        mLevel=memo.getmLevel();
        mIcon=memo.getmIcon();
    }

}
