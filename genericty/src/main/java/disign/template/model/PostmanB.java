package disign.template.model;

/**
 * Created by jian.shui on 2019/1/24
 */
public  class PostmanB extends Postman{
    @Override
    protected void call() {
        System.out.println("联系收货人B,准备派送...");
    }

    @Override
    protected boolean isSign() {
        return false;
    }

    @Override
    protected void refuse() {
        super.refuse();
        System.out.println("商品与实物不符，拒绝签收!");
    }
}
