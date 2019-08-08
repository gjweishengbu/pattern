package lyb.practice.behavioral.template.cooking;

/**
 * 项目名称：pattern
 * 功能说明: 模板模式 做饭流程归纳控制
 * 创建日期：2019/8/8
 *
 * @Author: LYB
 */
public abstract class CookingTemplate {
    String foodName;

    public CookingTemplate(String foodName) {
        this.foodName = foodName;
    }

    protected final void createMeal() {
        // 如果没有食材 现买

        if (noMaterial()) {
            buyMaterial();
        }

        // 准备食材
        prepareMaterial();

        // 准备厨具
        prepareTools();

        // cooking
        cooking();

        // 收拾厨具，厨房
        ending();

    }

    private final void ending(){
        System.out.println("收拾收尾！");
    }

    protected abstract void cooking();

    /**
     * 购买原材料
     */
    private final void buyMaterial() {
        System.out.println("购买材料"+foodName);
    }

    /**
     * 检查是否有原料，默认有
     * @return
     */
    protected boolean noMaterial() {
        return true;
    }

    /**
     * 准备食材
     */
    private final void prepareMaterial() {
        System.out.println("准备材料"+foodName);
    }

    /**
     * 准备厨具
     */
    private final void prepareTools() {
        System.out.println("准备厨具做"+foodName);
    }


}
