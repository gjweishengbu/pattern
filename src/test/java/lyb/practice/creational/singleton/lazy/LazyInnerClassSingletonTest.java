package lyb.practice.creational.singleton.lazy;

import lyb.practice.creational.singleton.lazy.LazyInnerClassSingleton;
import org.junit.*;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * LazyInnerClassSingleton Tester.
 * run report state:1 Failure where does not fit you want.
 * 2 error test code has bug.
 * used often 1 @BeforeClass: run first when class was loaded,for configation.
 * 2 @AfterClass: run at the end of test.
 * 3 @Before,@After run at everytest method Before or After.
 * 4 @Test(excepted=XX.class) run Ignore with same Exception.
 * 5 @Test(timeout=millisecond) millisecond was allowed to ru.
 * 6 @Ignore Ignored by test executer
 *
 * @author $user
 * @version 1.0
 * @since <pre>07/18/2019</pre>
 */
public class LazyInnerClassSingletonTest {

    private static LazyInnerClassSingleton testedClass;

    @BeforeClass
    public static void init() {
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getInstance()
     * 反射破坏 需在构造器中增加禁止的代码
     * // 防止反射攻击
     *         if (LazyInnerClassSingletonHolder.HOLD_INSTANCE != null) {
     *             throw new RuntimeException("reflect is not accepted!");
     *         }
     */
    @Test(expected = InvocationTargetException.class)
//    @Test
    public void testGetInstance() throws Exception {
        // 推荐获取方法获取的对象
        LazyInnerClassSingleton instanceRightWay = LazyInnerClassSingleton.getInstance();
        System.out.println(instanceRightWay);

        Constructor<LazyInnerClassSingleton> declaredConstructor = LazyInnerClassSingleton.class.getDeclaredConstructor(null);
        //私有构造授权，强行调用
        declaredConstructor.setAccessible(true);
        // 反射获取的对象
        LazyInnerClassSingleton instanceIllegalWay = declaredConstructor.newInstance();
        System.out.println(instanceIllegalWay);

        // 处理后不能通过反射获取


        Assert.assertNotSame(instanceIllegalWay,instanceRightWay);

    }


    /**
     * Method: getInstance()
     * 测试序列化破坏单列胡情况
     */
    @Test(expected = InvocationTargetException.class)
    public void testGetInstanceBySeriable() throws Exception {
        // 推荐获取方法获取的对象
        LazyInnerClassSingleton instanceRightWay = LazyInnerClassSingleton.getInstance();
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
            LazyInnerClassSingleton instanceIllegalWay = (LazyInnerClassSingleton) ois.readObject();
            System.out.println(instanceIllegalWay);

            Assert.assertNotSame(instanceIllegalWay,instanceRightWay);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
        }

    }


} 
