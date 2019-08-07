package lyb.practice.behavioral.strategy.promotion;
/**
 * 无优惠
 * Created by Tom
 */
public class EmptyStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("无促销活动");
    }
}
