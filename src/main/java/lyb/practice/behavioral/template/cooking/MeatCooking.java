package lyb.practice.behavioral.template.cooking;

/**
 * 项目名称：pattern
 * 功能说明: 做肉菜
 * 创建日期：2019/8/8
 *
 * @Author: LYB
 */
public class MeatCooking extends CookingTemplate {

    private boolean noMaterial = true;

    MeatCooking(boolean noMaterial, String foodName) {
        super(foodName);
        this.noMaterial = noMaterial;
    }

    @Override
    protected void cooking() {
        System.out.println("大火炒"+foodName);
    }

    // 子类中控制主流程

    @Override
    protected boolean noMaterial() {
        return noMaterial;
    }
}
