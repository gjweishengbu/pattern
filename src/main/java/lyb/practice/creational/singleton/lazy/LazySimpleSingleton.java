package lyb.practice.creational.singleton.lazy;

/**
 * 项目名称：pattern
 * 功能说明: 懒汉式单例
 *           外部首次调用才初始化构造
 *           需注意防范线程安全问题
 * 创建日期：2019/7/16
 *
 * @Author: LYB
* @deprecated  性能问题 replaced by {@link LazyInnerClassSingleton}
 */
public class LazySimpleSingleton {
    /**
     * 必须是static
     * 直接定义构造或在静态代码块中一样
     */
    private static LazySimpleSingleton instance;

    /**
     * 一定隐藏构造
     */
    private LazySimpleSingleton(){};

    /**
     * 公开获取实例，
     * @return
     * @deprecated not safe replaced by <code>getInstanceSynchronized()</code>
     */
    @Deprecated
    public static LazySimpleSingleton getInstance(){
        if (instance == null){
            instance = new LazySimpleSingleton();
        }
        return instance;
    }

    /**
     * 公开获取实例，
     * 会导致锁类
     */
    public synchronized static LazySimpleSingleton getInstanceSynchronized (){
        if (instance == null){
            instance = new LazySimpleSingleton();
        }
        return instance;
    }

}
