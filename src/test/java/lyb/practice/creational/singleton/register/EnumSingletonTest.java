package lyb.practice.creational.singleton.register;

import org.junit.*;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * EnumSingleton Tester.
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
 * @since <pre>07/21/2019</pre>
 */
public class EnumSingletonTest {

    private static EnumSingleton testedClass;

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
     * 测试反序列化对单例的破坏
     */
    @Test
    public void testGetInstance() throws Exception {
        // 推荐获取方法获取的对象
        EnumSingleton instanceRightWay = EnumSingleton.getInstance();
        instanceRightWay.setData(new Object());
        System.out.println(instanceRightWay.getData());
        // 序列化一个实例，反序列构造
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("EnumSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(instanceRightWay);

            // 反序列化
            FileInputStream fis = new FileInputStream("EnumSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            EnumSingleton instanceIllegalWay = (EnumSingleton) ois.readObject();
            System.out.println(instanceIllegalWay.getData());

            Assert.assertSame(instanceIllegalWay.getData(),instanceRightWay.getData());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
        }
    }

    /**
     * Method: getInstance()
     */
    @Test(expected = IllegalArgumentException.class)
//    @Test
    public void testGetInstanceByReflects() throws Exception {
        // 推荐获取方法获取的对象
        EnumSingleton instanceRightWay = EnumSingleton.getInstance();
        System.out.println(instanceRightWay);

        // 经Jad 反编译可知Enum 类中无默认无参构造器
        //Constructor<EnumSingleton> declaredConstructor = EnumSingleton.class.getDeclaredConstructor(null);
        /*编译后只会有下列构造器，且无法显示写出
        private EnumSingleton(String s, int i)
        {
            super(s, i);
        }*/
        Constructor<EnumSingleton> declaredConstructor = EnumSingleton.class.getDeclaredConstructor(String.class,int.class);
        //私有构造授权，强行调用
        declaredConstructor.setAccessible(true);
        // 反射获取的对象
        // 不能通过反射构建Enum对象，即便是用其静态加载时的真实参数 会抛出异常
        EnumSingleton instanceIllegalWay = declaredConstructor.newInstance("INSTANCE",0);
        System.out.println(instanceIllegalWay);

        Assert.assertNotSame(instanceIllegalWay,instanceRightWay);

    }


} 
