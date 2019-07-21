package lyb.practice.creational.singleton.lazy;

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
public class LazyInnerClassSerializableSingletonTest {

    private static LazyInnerClassSerializableSingleton testedClass;

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
     * Method:
     * 测试序列化破坏单列胡情况
     */
    @Test
    public void testGetInstanceBySeriable() throws Exception {
        // 推荐获取方法获取的对象
        LazyInnerClassSerializableSingleton instanceRightWay = LazyInnerClassSerializableSingleton.getInstance();
        System.out.println(instanceRightWay);

        // 序列化一个实例，反序列构造
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("LazyInnerClassSerializableSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(instanceRightWay);

            // 反序列化
            FileInputStream fis = new FileInputStream("LazyInnerClassSerializableSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            LazyInnerClassSerializableSingleton instanceIllegalWay = (LazyInnerClassSerializableSingleton) ois.readObject();
            System.out.println(instanceIllegalWay);

            // 序列化class 未复写readResolve 时将反序列化出一个新的对象
//            Assert.assertNotSame(instanceIllegalWay,instanceRightWay);
            // 序列化class 复写readResolve 时将唯一实例直接返回 则相同
            Assert.assertSame(instanceIllegalWay,instanceRightWay);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
        }

    }


} 
