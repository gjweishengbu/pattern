package lyb.practice.creational.singleton.lazy;

/**
 * 项目名称：pattern
 * 功能说明: 懒汉式单例 Double Checked 优化
 *           外部首次调用才初始化构造
 *           需注意防范线程安全问题
 * 创建日期：2019/7/16
 *
 * @Author: LYB
* @deprecated  性能问题 replaced by {@link LazyInnerClassSingleton}
 */
public class LazyDoubleCheckSingleton {
    /**
     * 必须是static
     * 直接定义构造或在静态代码块中一样
     */
    private static LazyDoubleCheckSingleton instance;

    /**
     * 一定隐藏构造
     */
    private LazyDoubleCheckSingleton(){};

    /**
     * 公开获取实例，
     * @return
     */
    public static LazyDoubleCheckSingleton getInstance(){
        if (instance == null){
            synchronized (LazyDoubleCheckSingleton.class){
                if (instance == null){
                    instance = new LazyDoubleCheckSingleton();
                }
            }
        }

        return instance;
    }


}
