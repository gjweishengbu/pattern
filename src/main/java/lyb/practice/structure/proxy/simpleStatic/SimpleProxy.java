package lyb.practice.structure.proxy.simpleStatic;

import lyb.practice.structure.subject.SinglePerson;

/**
 * 项目名称：pattern
 * 功能说明: 代理模式的基本结构
 *           静态持有被代理对象
 *           对被代理对象进行保护和增强
 *
 *           当代理类修改时需同步修改，不符合开闭原则
 * 创建日期：2019/7/26
 *
 * @Author: LYB
 */
public class SimpleProxy implements SinglePerson {
    /**
     * 持有被代理对象
     */
    private SinglePerson sp;

    public SimpleProxy(SinglePerson sp) {
        this.sp = sp;
    }

    @Override
    public void findLover() {
        before();
        sp.findLover();
        after();
    }

    @Override
    public void getMarried() {

    }

    /**
     * 后置事件
     */
    private void after() {
        System.out.println("收尾工作！");
    }

    /**
     * 前置事件
     */
    private void before() {
        System.out.println("准备工作！");
    }


}
