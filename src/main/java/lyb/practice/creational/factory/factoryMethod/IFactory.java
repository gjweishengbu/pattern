package lyb.practice.creational.factory.factoryMethod;

import lyb.practice.creational.Food;

/**
 * 项目名称：pattern
 * 功能说明: :共产功能要求
 * 创建日期：2019/7/9
 * 创建人：LYB
 */
public interface IFactory<T extends Food> {
    /**
     * 创建餐点
     *
     * @param name
     * @return
     */
    T create(String name) throws Exception;
}

