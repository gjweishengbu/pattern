package lyb.practice.creational.singleton.register;

import lyb.practice.creational.Fruit;
import lyb.practice.util.ConcurrentExecutor;
import org.junit.*;

import java.util.HashSet;

/**
 * findLover Tester.
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
public class ContainerSingletonTest {

    private static ContainerSingleton testedClass;
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
     * Method: getInstance(Class clazz)
     */
    @Test
    public void testGetInstance() throws Exception {
        long start = System.currentTimeMillis();
        ConcurrentExecutor.execute(()->{
            Object object = ContainerSingleton.getInstance(Fruit.class);
            hungrySingletons.add(object);
            System.out.println(System.currentTimeMillis()+":"+object);
        },10,6);

        System.out.println("instance count expected is 1,truely is " + hungrySingletons.size());
        Assert.assertTrue(hungrySingletons.size() == 1);

        long end = System.currentTimeMillis();
        System.out.println("总耗时："+(end - start)+"ms.");
    }

    /**
     * Method: getInstanceSynchronized(Class clazz)
     */
    @Test
    public void testGetInstanceSynchronized() throws Exception {
        long start = System.currentTimeMillis();
        ConcurrentExecutor.execute(()->{
            Object object = ContainerSingleton.getInstanceSynchronized(Fruit.class);
            hungrySingletons.add(object);
            System.out.println(System.currentTimeMillis()+":"+object);
        },10,6);

        System.out.println("instance count expected is 1,truely is " + hungrySingletons.size());
        Assert.assertTrue(hungrySingletons.size() == 1);

        long end = System.currentTimeMillis();
        System.out.println("总耗时："+(end - start)+"ms.");
    }


} 
