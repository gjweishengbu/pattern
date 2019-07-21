package lyb.practice.creational.singleton.hungry;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * HungrySingleton Tester.
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
 * @since <pre>07/16/2019</pre>
 */

//需重复测试时
@RunWith(Parameterized.class)
public class HungrySingletonTest implements Runnable {
    static final int threadCount = 3; //单次线程数
    /**
     * 使用CountDownLatch准备线程并 并发，全部完成后主线程退出
     */
    static CountDownLatch latch = new CountDownLatch(threadCount);

    /**
     * 使用set检查生成的单例唯一
     */
    static volatile HashSet<HungrySingleton> hungrySingletons = new HashSet<>();


    private static HungrySingleton testedClass;

    @BeforeClass
    public static void init() {

    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    // 设置重复次数及参数
    @Parameterized.Parameters
    public static Collection data() {
        Object[][] objects = new Object[1][0];
        return Arrays.asList(objects);
    }

    /**
     * Method: getInstance()
     * 创建多个线程，并发获取单例，用Set 监测实例唯一性
     */
    @Test
    public void testGetInstance() throws Exception {
        // 线程池
        ExecutorService exec = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < threadCount; i++) {
            exec.submit(new HungrySingletonTest());
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
            HungrySingleton instance = HungrySingleton.getInstance();
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
