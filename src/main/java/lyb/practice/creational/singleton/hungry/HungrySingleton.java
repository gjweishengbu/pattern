package lyb.practice.creational.singleton.hungry;

/**
 * 项目名称：pattern
 * 功能说明: :饿汉单列
 *            类加载时初始化构造
 *       优点：没有锁，执行效率高
 *             用户体验比懒汉式高
 *       缺点：类加载时初始化，可能用不上缺占内存
 *
 *       绝对的线程安全，
 *
 *创建日期：2019/7/16
 *
 * @Author: LYB
 */
public class HungrySingleton {

    /**
     * 必须是static final
     * 直接定义构造或在静态代码块中一样
     */
    private static final HungrySingleton instance = new HungrySingleton();

    /**
     * 一定隐藏构造
     */
    private HungrySingleton(){};

    public static HungrySingleton getInstance(){
        return instance;
    }

}
