package lyb.practice.creational.singleton.register;

/**
 * 项目名称：pattern
 * 功能说明: 线程内单例
 *          仅限线程内部单例，且天生线程安全
 * 创建日期：2019/7/21
 *
 * @Author: LYB
 */
public class ThreadLocalSingleton {

    private ThreadLocalSingleton(){}

    // 将唯一的实例放在线程内部全局变量中
    private static final ThreadLocal<ThreadLocalSingleton>  threadLocal = new ThreadLocal<ThreadLocalSingleton>(){
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };

    // 将线程唯一实例返回
    public static ThreadLocalSingleton getInstance(){
        return threadLocal.get();
    }

}
