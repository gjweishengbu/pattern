package lyb.practice.behavioral.strategy.pay.payport;


import lyb.practice.entity.ResultMsg;

/**
 * 支付渠道
 * Created by Tom.
 */
public abstract class Payment {

    //支付类型
    public abstract String getName();

    //查询余额
    protected abstract double queryBalance(String uid);

    //扣款支付
    public ResultMsg pay(String uid, double amount) {
        if(queryBalance(uid) < amount){
            return new ResultMsg(500,"支付失败","余额不足");
        }
        return new ResultMsg(200,"支付成功","支付金额：" + amount);
    }


}
