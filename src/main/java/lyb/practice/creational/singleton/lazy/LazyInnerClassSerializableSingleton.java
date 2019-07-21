package lyb.practice.creational.singleton.lazy;

import org.junit.Assert;

import java.io.*;

/**
 * 项目名称：pattern
 * 功能说明: 内部类单列 可序列化
 * 饿汉式调用才初始化，无synchronized语句限制，具有最高性能
 * 使用JVM 内部类加载特性现实
 * 静态内部类和非静态内部类一样，都不会因为外部内的加载而加载；
 * 同时静态内部类的加载不需要依附外部类，在使用时才加载；
 * 不过在加载静态内部类的过程中也会加载外部类
 * <p>
 * 创建日期：2019/7/18
 *
 * @Author: LYB
 */
public class LazyInnerClassSerializableSingleton implements Serializable {

    // 禁止反射方式构造
    public LazyInnerClassSerializableSingleton() throws RuntimeException {
        // 防止反射攻击
        if (LazyInnerClassSingletonHolder.HOLD_INSTANCE != null) {
            throw new RuntimeException("reflect is not accepted!");
        }
    }

    /**
     * final 禁止重写、重载
     *
     * @return
     */
    public static final LazyInnerClassSerializableSingleton getInstance() {
        // 首次返回前 加载内部类
        return LazyInnerClassSingletonHolder.HOLD_INSTANCE;
    }

    // 外部类加载时不加载内部类，首次请求时加载并返回唯一实例
    private static class LazyInnerClassSingletonHolder {
        private static final LazyInnerClassSerializableSingleton HOLD_INSTANCE = new LazyInnerClassSerializableSingleton();
    }

    /**
     * 按反序列化规则，如果有下列方法则通过该方法获取对象，将抛弃反序列化的对象
     *
     * @return
     */
    private Object readResolve() {
        return LazyInnerClassSingletonHolder.HOLD_INSTANCE;
    }


    public static void main(String[] args) {
        LazyInnerClassSerializableSingleton instanceRightWay = LazyInnerClassSerializableSingleton.getInstance();
        System.out.println(instanceRightWay);

        // 序列化一个实例，反序列构造
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("LazyInnerClassSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(instanceRightWay);

            // 反序列化
            FileInputStream fis = new FileInputStream("LazyInnerClassSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            LazyInnerClassSerializableSingleton instanceIllegalWay = (LazyInnerClassSerializableSingleton) ois.readObject();
            System.out.println(instanceIllegalWay);

            Assert.assertNotSame(instanceIllegalWay, instanceRightWay);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
        }
    }


}
