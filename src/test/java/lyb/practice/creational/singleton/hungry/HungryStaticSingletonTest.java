package lyb.practice.creational.singleton.hungry;

import org.junit.*;

import java.util.HashSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * HungryStaticSingleton Tester.
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
 * @since <pre>07/19/2019</pre>
 */
public class HungryStaticSingletonTest implements Runnable {
    static final int threadCount = 3; //单次线程数
    /**
     * 使用CountDownLatch准备线程并 并发，全部完成后主线程退出
     */
    static CountDownLatch latch = new CountDownLatch(threadCount);

    /**
     * 使用set检查生成的单例唯一
     */
    static volatile HashSet<HungryStaticSingleton> hungrySingletons = new HashSet<>();

    private static HungryStaticSingleton testedClass;

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
        // 线程池
        ExecutorService exec = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < threadCount; i++) {
            exec.submit(new HungryStaticSingletonTest());
        }

        // 检查并执行
        latch.await();

        System.out.println("完毕");

        System.out.println("instance count expected is 1,truely is " + hungrySingletons.size());
        Assert.assertTrue(hungrySingletons.size() == 1);
    }

    /**
     * 线程业务
     */
    @Override
    public void run() {
        try {
            HungryStaticSingleton instance = HungryStaticSingleton.getInstance();
            hungrySingletons.add(instance);
            System.out.println(Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //计数减一
            //放在finally避免任务执行过程出现异常，导致countDown()不能被执行
            latch.countDown();
        }
    }

} 
