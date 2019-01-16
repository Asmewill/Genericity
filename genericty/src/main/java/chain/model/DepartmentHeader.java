package chain.model;

/**
 * Created by jian.shui on 2019/1/8
 */
public class DepartmentHeader implements Ratify {
    @Override
    public Result deal(Chain chain) {
        Request request=chain.request();
        System.out.println("DepartmentHeader=====>request:"+request.toString());
        if(Integer.parseInt(request.getDays())>7){
              return  new Result(false,"DepartmentHeader:你这个时间太长,不能批准");
        }
        return new Result(true,"DepartmentHeader:不要着急，把事情处理完在回来!");
    }
}
