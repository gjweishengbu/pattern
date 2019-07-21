package lyb.practice.creational.factory.factoryMethod;

import lyb.practice.creational.Fruit;

/**
 * 项目名称：pattern
 * 功能说明: :Fruit 工厂
 * 创建日期：2019/7/11
 *
 * @author: LYB
 */
public class FruitFactory implements IFactory<Fruit>{

    @Override
    public Fruit create(String name) throws Exception {
        if (name == null) {
            return null;
        }
        return new Fruit(name);
    }


}
