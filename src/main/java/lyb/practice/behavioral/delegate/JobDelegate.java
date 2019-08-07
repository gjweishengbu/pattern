package lyb.practice.behavioral.delegate;

import com.sun.deploy.util.SystemUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 项目名称：pattern
 * 功能说明: 委派者
 * 创建日期：2019/8/5
 *
 * @Author: LYB
 */
public class JobDelegate {
    private Map<String,ITarget> targetMap = new ConcurrentHashMap<>();

    public JobDelegate() {
        targetMap.put("design",new TargetDesign());
        targetMap.put("coding",new TargetCoding());

    }

    public void dispatchJob(String order){
        if (order == null || order.equals("")) {
            System.out.println("请给出指令！");
            return;
        }
        if(targetMap.containsKey(order)){
            targetMap.get(order).doJob(order);
        }else{
            System.out.println("job指令超出范围，不受理！");
        }

    }

}
