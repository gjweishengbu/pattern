package lyb.practice.structure.decorator.battercake.v2;

/**
 * 项目名称：pattern
 * 功能说明: 火腿肠装饰器
 * 创建日期：2019/8/15
 *
 * @Author: LYB
 */
public class HotdogBattercakeDecorator extends BattercakeDecorator {
    public HotdogBattercakeDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected String getMsg() {
        return super.getMsg()+"+1根火腿";
    }

    @Override
    protected int getPrice() {
        return super.getPrice()+2;
    }
}
