package lyb.practice.creational.factoryMethod;

import lyb.practice.creational.Meat;

/**
 * 项目名称：pattern
 * 功能说明: 餐饮工厂
 * 创建日期：2019/7/11
 *
 * @author: LYB
 */
public class MealFactory implements IFactory<Meat> {
    @Override
    public Meat create(String name) throws Exception {
        if (name == null) {
            return null;
        }
        return new Meat(name);
    }
}
