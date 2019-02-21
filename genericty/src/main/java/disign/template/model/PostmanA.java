package disign.template.model;

/**
 * Created by jian.shui on 2019/1/24
 */
public  class PostmanA extends Postman{
    @Override
    protected void call() {
        System.out.println("联系收货人A,准备派送...");
    }
}
