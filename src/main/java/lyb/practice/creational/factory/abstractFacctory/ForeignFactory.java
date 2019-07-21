package lyb.practice.creational.factory.abstractFacctory;

import lyb.practice.creational.*;

/**
 * 项目名称：pattern
 * 功能说明: :外国工厂
 * 创建日期：2019/7/14
 *
 * @author: LYB
 */
public class ForeignFactory extends StandardSuperFactoey {
    @Override
    public Food createFood() {
        food = new Meat("牛肉");
        return food;
    }

    @Override
    public Tool createTool() {
        tool = new Knife("刀");
        return tool;
    }
}
