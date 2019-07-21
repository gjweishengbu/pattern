package lyb.practice.creational.factory.abstractFacctory;

import lyb.practice.creational.Food;
import lyb.practice.creational.Knife;
import lyb.practice.creational.Meat;
import lyb.practice.creational.Tool;

/**
 * 项目名称：pattern
 * 功能说明: :标准超级工厂
 * 创建日期：2019/7/14
 *
 * @author: LYB
 */
public class StandardSuperFactoey implements ISuperFactory {
    protected Food food;
    protected Tool tool;

    @Override
    public Food createFood() {
        food = new Meat("通用食物");
        return food;
    }

    @Override
    public Tool createTool() {
        tool = new Knife("通用工具");
        return tool;
    }

    public void use() {
        System.out.println("eating "+food.name+ " by "+tool.name);
    }


}
