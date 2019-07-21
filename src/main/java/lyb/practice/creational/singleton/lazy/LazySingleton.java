package lyb.practice.creational.singleton.lazy;

/**
 * 项目名称：pattern
 * 功能说明: 懒汉式单例
 *           首次调用才初始化构造
 *           需注意防范线程安全问题
 * 创建日期：2019/7/16
 *
 * @Author: LYB
 */
public class LazySingleton {
    /**
     * 必须是static final 防止反射破坏
     * 直接定义构造或在静态代码块中一样
     */
    private static LazySingleton instance;

    /**
     * 一定隐藏构造
     */
    private LazySingleton(){};

    /**
     * 公开获取实例，
     * @return
     * @deprecated not safe replaced by <code>getInstanceSynchronized()</code>
     */
    @Deprecated
    public static LazySingleton getInstance(){
        if (instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }

    /**
     * 公开获取实例，
     * @deprecated not safe replaced by <code>getInstanceDoubleCheched()</code>
     * 会导致锁类
     */
    @Deprecated
    public synchronized static LazySingleton getInstanceSynchronized (){
        if (instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }

    /**
     * 公开获取实例，
     * DoubleChech方式，synchronized代码块
     */
    public static LazySingleton getInstanceDoubleCheched (){
        if (instance == null){
            synchronized (LazySingleton.class){
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }


}
