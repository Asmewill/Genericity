package disign.chain.model;

/**
 * Created by jian.shui on 2019/1/8
 */
public class GroupLeader implements Ratify {
    @Override
    public Result deal(Chain chain) {
        Request request=chain.request();
        System.out.println("GroupLeader====>request:"+request.toString());
        if(Integer.parseInt(request.getDays())>1){
            //包装新的Request对象
            Request newRequest=new Request.Builder().newRequest(request).setManagerInfo(request.getName()+"平时表现不错,而且现在项目不忙").build();
            return chain.proceed(newRequest);
        }
        return new Result(true,"GroupLeader:早去早回");
    }
}
