package lyb.practice.structure.proxy.dynamic.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 项目名称：pattern
 * 功能说明: Cglib方式代理
 *           与JDK的区别是：采用继承被代理类，改写父类方法实现代理功能
 *
 *           JDK需要代理的类必须实现一个接口，CGLib无限制
 *           CGLib方式生成一个包含所有逻辑的fastClass,代理逻辑复杂，效率、性能更高，无需反射动态调用
 *
 *           CGLib 不能代理 final 修饰的方法
 *
 *
 *           FastClass 机制，它的原理简单来说就是：为代理类和被代理类各生成一个Class，这个Class 会为代
 *           理类或被代理类的方法分配一个index(int 类型)。这个index 当做一个入参，FastClass
 *           就可以直接定位要调用的方法直接进行调用，这样省去了反射调用，所以调用效率比JDK
 *           动态代理通过反射调用高
 *
 *
 * 创建日期：2019/8/4
 *
 * @Author: LYB
 */
public class CGLibProxy implements MethodInterceptor {

    public Object getInstance(Class<?> aClass) throws Exception{
        // 相当于Proxy 的工具类
        Enhancer enhancer = new Enhancer();
        // 设置被代理类为超类
        enhancer.setSuperclass(aClass);
        // 业务增强处理类为本类
        enhancer.setCallback(this);
        // 实现类似JDK方式自动编码、编译、加载、使用
        return enhancer.create();
    }

    /**
     * 实现被代理类的业务增强,回调方法
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object obj = methodProxy.invokeSuper(o,objects);
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
