package lyb.practice.behavioral.strategy.pay.payport;


/**
 * Created by Tom.
 */
public class AliPay extends Payment {
    @Override
    public String getName() {
        return "支付宝";
    }

    @Override
    protected double queryBalance(String uid) {
        return 900;
    }

}
