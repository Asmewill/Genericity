package disign.template.model;

/**
 * Created by jian.shui on 2019/1/24
 */
public abstract class Postman {

    public void post(){
        prepare();
        call();
        if(isSign()){
            sign();
        }else{
            refuse();
        }


    }

    protected void refuse() {
    }

    protected void sign() {
        System.out.println("派送完毕,客户已经签收！");
    }

    protected boolean isSign() {
        return true;
    }

    protected abstract void call();

    protected void prepare() {
        System.out.println("快递已经到达，准备派送...");
    }
}
