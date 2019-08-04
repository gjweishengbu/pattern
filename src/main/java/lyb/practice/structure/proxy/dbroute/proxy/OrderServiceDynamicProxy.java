package lyb.practice.structure.proxy.dbroute.proxy;

import lyb.practice.structure.proxy.dbroute.db.DynamicDataSourceEntity;
import lyb.practice.structure.proxy.dynamic.jdkproxy.myjdk.MyClassLoader;
import lyb.practice.structure.proxy.dynamic.jdkproxy.myjdk.MyInvocationHandler;
import lyb.practice.structure.proxy.dynamic.jdkproxy.myjdk.MyProxy;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 项目名称：pattern
 * 功能说明: 订单服务动态代理
 *           采用自定义动态代理或JDK方式
 * 创建日期：2019/8/3
 *
 * @Author: LYB
 */
public class OrderServiceDynamicProxy implements MyInvocationHandler {
    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    Object proxyObj;

    public Object getInstance(Object proxyObj) {
        this.proxyObj = proxyObj;
        Class<?> clazz = proxyObj.getClass();
        return MyProxy.newProxyInstance(new MyClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object myInvoke(Object myPproxy, Method method, Object[] args) throws Throwable {
        before(args[0]);

        Object invoke = method.invoke(proxyObj, args);

        after();

        return invoke;
    }

    private void after() {
        System.out.println("Proxy after method");
        //还原成默认的数据源
        DynamicDataSourceEntity.reset();
    }

    //target 应该是订单对象Order
    private void before(Object target) {
        try {
            //进行数据源的切换
            System.out.println("Proxy before method");

            //约定优于配置
            Long time = (Long) target.getClass().getMethod("getCreateTime").invoke(target);
            Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
            System.out.println("静态代理类自动分配到【DB_" + dbRouter + "】数据源处理数据");
            DynamicDataSourceEntity.set(dbRouter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
