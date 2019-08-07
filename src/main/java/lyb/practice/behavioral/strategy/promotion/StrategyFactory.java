package lyb.practice.behavioral.strategy.promotion;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 项目名称：pattern
 * 功能说明: 策略工厂，简单工厂
 * 创建日期：2019/8/6
 *
 * @Author: LYB
 */
public class StrategyFactory {

    private static Map<String,PromotionStrategy> strategyMap = new ConcurrentHashMap<>();

    static {
        strategyMap.put(PromotionKey.COUPON,new CouponStrategy());
        strategyMap.put(PromotionKey.CASHBACK,new CashbackStrategy());
        strategyMap.put(PromotionKey.GROUPBUY,new GroupbuyStrategy());
        strategyMap.put(PromotionKey.NON_PROMOTION,new EmptyStrategy());
    }

    private static final PromotionStrategy NON_PROMOTION = new EmptyStrategy();


    private StrategyFactory(){

    }

    public static PromotionStrategy getPromotionStrategy(String promotionKey){
        if (promotionKey == null) {
            return NON_PROMOTION;
        }
        if(strategyMap.containsKey(promotionKey)){
            return strategyMap.get(promotionKey);
        }else{
            return NON_PROMOTION;
        }

    }

    private interface PromotionKey{
        String COUPON = "COUPON";
        String CASHBACK = "CASHBACK";
        String GROUPBUY = "GROUPBUY";
        String NON_PROMOTION = "NON_PROMOTION";
    }

}
