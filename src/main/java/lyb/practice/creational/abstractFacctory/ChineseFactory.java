package lyb.practice.creational.abstractFacctory;

import lyb.practice.creational.*;

/**
 * 项目名称：pattern
 * 功能说明: :中国超级工厂
 * 创建日期：2019/7/14
 *
 * @author: LYB
 */
public class ChineseFactory extends StandardSuperFactoey {
    @Override
    public Food createFood() {
        food = new Fruit("米饭4");
        return food;

    }

    @Override
    public Tool createTool() {
        tool = new Kuaizi("筷子");
        return tool;
    }


}
