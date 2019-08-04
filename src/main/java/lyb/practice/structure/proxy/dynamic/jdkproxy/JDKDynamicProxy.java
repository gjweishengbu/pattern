package lyb.practice.structure.proxy.dynamic.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 项目名称：pattern
 * 功能说明: JDK反射机制实现动态代理
 * 需实现
 * 创建日期：2019/7/26
 *
 * @Author: LYB
 */
public class JDKDynamicProxy implements InvocationHandler {

    /**
     * 被代理对象
     */
    private Object targetProxied;

    /**
     * 传入一个被代理对象，返回一个包含被代理对象的代理
     * @param targetProxied
     * @return
     */
    public Object getInstance(Object targetProxied) {
        this.targetProxied = targetProxied;
        Class<?> aClass = targetProxied.getClass();
        return Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), this);
    }

    /**
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(this.targetProxied, args);
        after();
        return obj;

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
