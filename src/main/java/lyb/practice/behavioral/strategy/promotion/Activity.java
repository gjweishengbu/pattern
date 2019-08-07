package lyb.practice.behavioral.strategy.promotion;


import org.apache.commons.lang3.StringUtils;

/**
 * 项目名称：pattern
 * 功能说明: 发布优惠活动
 * 创建日期：2019/8/6
 *
 * @Author: LYB
 */
public class Activity {
    // 持有抽象策略
    private PromotionStrategy promotionStrategy;

    public Activity(PromotionStrategy promotionStrategy){
        this.promotionStrategy = promotionStrategy;

    }

    /**
     * 将所有策略公开给调用者，由客户选择发布活动
     */
    public void execute(){
        promotionStrategy.doPromotion();
    }

    /**
     * 将所有策略转换说明给调用者，统一管理发布活动
     * 将会破坏开闭原则
     */
    public static void executeByName(String promotionKey){

        if(StringUtils.equals(promotionKey,"COUPON")){
            new Activity(new CouponStrategy()).execute();
        }else if(StringUtils.equals(promotionKey,"CASHBACK")){
            new Activity(new CashbackStrategy()).execute();;
        }else if(StringUtils.equals(promotionKey,"GROUPBUG")){
            new Activity(new GroupbuyStrategy()).execute();;
        }else {
            new Activity(new EmptyStrategy()).execute();
        }

    }
    

}
