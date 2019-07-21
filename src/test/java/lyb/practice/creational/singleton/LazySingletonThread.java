package lyb.practice.creational.singleton;

import lyb.practice.creational.singleton.lazy.LazySimpleSingleton;

/**
 * 项目名称：pattern
 * 功能说明: 饿汉单例测试
 * 创建日期：2019/7/17
 *
 * @Author: LYB
 */
public class LazySingletonThread implements Runnable {
    @Override
    public void run() {
        //LazySimpleSingleton instance = LazySimpleSingleton.getInstance();
        LazySimpleSingleton instance = LazySimpleSingleton.getInstanceSynchronized();
        System.out.println(Thread.currentThread().getName()+":"+instance);
    }
}
