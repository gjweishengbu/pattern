package lyb.practice.structure.decorator.battercake.v2;

/**
 * 项目名称：pattern
 * 功能说明: 加蛋装饰器
 * 创建日期：2019/8/15
 *
 * @Author: LYB
 */
public class EggBattercakeDecorator extends BattercakeDecorator{
    public EggBattercakeDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected String getMsg() {
        return super.getMsg()+"+1个鸡蛋";
    }

    @Override
    protected int getPrice() {
        return super.getPrice()+1;
    }
}
