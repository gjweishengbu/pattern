package lyb.practice.creational.singleton.register;

import lyb.practice.creational.Fruit;
import lyb.practice.util.ConcurrentExecutor;
import org.junit.*;

import java.util.HashSet;

/**
 * ThreadLocalSingleton Tester.
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
public class ThreadLocalSingletonTest {

    private static ThreadLocalSingleton testedClass;

    /**
     * 使用set检查生成的单例唯一
     */
    static volatile HashSet<Object> hungrySingletons = new HashSet<>();

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
     */
    @Test
    public void testGetInstance() throws Exception {
        // 主线程
        ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+""+instance);
        hungrySingletons.add(instance);
        instance = ThreadLocalSingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+""+instance);
        hungrySingletons.add(instance);

        ConcurrentExecutor.execute(()->{
            ThreadLocalSingleton instance1 = ThreadLocalSingleton.getInstance();
            System.out.println(Thread.currentThread().getName()+""+instance1);
            hungrySingletons.add(instance1);
            instance1 = ThreadLocalSingleton.getInstance();
            System.out.println(Thread.currentThread().getName()+""+instance1);
            hungrySingletons.add(instance1);
        },2,2);

        // 有几个线程将产生几个不同的单例
        System.out.println("instance count expected is 3,truely is " + hungrySingletons.size());
        Assert.assertTrue(hungrySingletons.size() == 3);

    }


} 
