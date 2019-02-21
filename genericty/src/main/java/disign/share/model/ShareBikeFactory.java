package disign.share.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jian.shui on 2019/1/24
 */
public class ShareBikeFactory {
    Map<String,IBike> pool=new HashMap<>();
    public  IBike getBike(String name){
        IBike iBike=null;
        if(!pool.containsKey(name)){
            iBike=new ShareBike();
            pool.put(name,iBike);
            System.out.println("交了199元押金，可以用车:"+name);
        }else{
            iBike=pool.get(name);
            System.out.println("押金已交，直接用车:"+name);
        }
        return iBike;
    }
}
