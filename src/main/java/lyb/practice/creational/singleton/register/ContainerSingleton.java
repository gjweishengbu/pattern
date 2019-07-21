package lyb.practice.creational.singleton.register;

import lyb.practice.creational.singleton.lazy.LazyInnerClassSingleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 项目名称：pattern
 * 功能说明: Spring 常用的注册式单例
 * 创建日期：2019/7/21
 *
 * @Author: LYB
 */

public class ContainerSingleton {
    private ContainerSingleton() {
    }

    private static Map<String, Object> ioc = new ConcurrentHashMap<>();

    /**
     * @param clazz
     * @return
     * @deprecated replaced by <code>getInstanceSynchronized(Class clazz)</code>
     */
    public static Object getInstance(Class clazz) {
        if (ioc.containsKey(clazz.getName())) {
            return ioc.get(clazz.getName());
        }

        try {
            Object obj = clazz.newInstance();
            ioc.put(clazz.getName(), obj);
            // ConcurrentHashMap 是线程安全的，即便是多个对象同时put只能put一个
            // System.out.println("ioc size" +ioc.size());
            return obj;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
        }

        return null;
    }

    /**
     * @param clazz
     * @return
     */
    public static Object getInstanceSynchronized(Class clazz) {
        synchronized (ioc) {
            return getInstance(clazz);
        }
    }


}
