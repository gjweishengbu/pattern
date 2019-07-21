package lyb.practice.creational.factory.simpleFactory;

import lyb.practice.creational.Food;
import lyb.practice.creational.Fruit;
import lyb.practice.creational.Meat;

/**
 * 项目名称：pattern
 * 功能说明: :简单工厂设计
 * 创建日期：2019/7/9
 * 创建人：LYB
 */

public class SimpleFactory {
    /**
     * 普通参数方法
     * @param name
     * @return
     * @throws Exception
     * @deprecated replaced by <code>createNew(String name)</code>
     */
    @Deprecated
    public Food create(String name) throws Exception {
        if (name == null) {
            return  null;
        }
        switch (name) {
            case "MEAT":
                return new Meat(name);
            case "FRUIT":
                return new Fruit(name);
            default:
                return  null;
        }
    }

    /**
     * 类名反射方法
     * @param clazz
     * @return
     * @throws Exception
     */
    public Food createNew(Class<? extends Food> clazz) throws Exception {
        try {
            if (clazz != null) {
                return clazz.newInstance();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
        }


        return null;
    }

}
