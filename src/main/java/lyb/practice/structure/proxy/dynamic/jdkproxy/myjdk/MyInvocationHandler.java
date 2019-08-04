package lyb.practice.structure.proxy.dynamic.jdkproxy.myjdk;

import java.lang.reflect.Method;

/**
 * 项目名称：pattern
 * 功能说明: 自定义业务处理接口
 * 创建日期：2019/7/29
 *
 * @Author: LYB
 */
public interface MyInvocationHandler {
    /**
     * 代理中需增强和保护的方法
     * @param myPproxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    Object myInvoke(Object myPproxy, Method method, Object[] args) throws Throwable;

}
