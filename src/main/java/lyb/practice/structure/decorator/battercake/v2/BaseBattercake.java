package lyb.practice.structure.decorator.battercake.v2;

/**
 * 项目名称：pattern
 * 功能说明: 标准版本
 * 创建日期：2019/8/15
 *
 * @Author: LYB
 */
public class BaseBattercake extends Battercake {
    @Override
    protected String getMsg() {
        return "煎饼";
    }

    @Override
    protected int getPrice() {
        return 5;
    }
}
