package lyb.practice.structure.decorator.battercake.v2;

import java.io.BufferedReader;

/**
 * 项目名称：pattern
 * 功能说明: 煎饼装饰器
 *           一种特别的适配器模式，与适配器的对比
 *           装饰                             适配器
 *           有层级关系                       没有
 *           需要实现同一接口，保持oop关系    没有必然关系，继承或者静态代理方式
 *           满足is-a 关系                    has -a 关系
 *           注重覆盖中扩展                   注重兼容转换
 *           前置考虑                         后置考虑
 *
 *           可以没有这层，看是否需要规范
 *           符合开闭原则，可拓展其他装饰类
 *           使用组合交由用户自己选择
 * 创建日期：2019/8/15
 *
 * @Author: LYB
 */
public abstract class BattercakeDecorator extends Battercake{

    // 代理方式传入待装饰的对象
    private Battercake battercake;

    public BattercakeDecorator(Battercake battercake) {
        this.battercake = battercake;
    }

    // 可增加拓展功能
    protected void doSomething(){
    }

    @Override
    protected  String getMsg(){
        return this.battercake.getMsg();
    }

    @Override
    protected int getPrice(){
        return this.battercake.getPrice();
    }
}
