package lyb.practice.behavioral.strategy.pay.payport;

/**
 * Created by Tom.
 */
public class WechatPay extends Payment {
    @Override
    public String getName() {
        return "微信支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 256;
    }

}
