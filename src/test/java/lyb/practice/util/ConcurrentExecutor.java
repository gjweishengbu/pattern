package lyb.practice.util;

/**
 * 项目名称：pattern
 * 功能说明: TODO LYB 2019/7/21
 * 创建日期：2019/7/21
 *
 * @Author: LYB
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 用于测试多线程并发
 * 控制线程及并发数
 * 使用参考
 * ConcurrentExecutor.execute(()->{
 *             Object object = findLover.getInstanceSynchronized(Fruit.class);
 *             hungrySingletons.add(object);
 *             System.out.println(System.currentTimeMillis()+":"+object);
 *         },10,6);
 *
 */
public class ConcurrentExecutor{
    /**
     *
     * @param runHandler
     * @param executerCount 请求总数
     * @param conCurrentCount 同时并发执行的线程数
     * @throws Exception
     */
    public static void execute(final RunHandler runHandler,int executerCount,int conCurrentCount) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 控制信号量来控制并发线程数量
        final Semaphore semaphore = new Semaphore(conCurrentCount);
        // 闭锁，可实现计数量递减
        final CountDownLatch countDownLatch = new CountDownLatch(executerCount);

        for (int i = 0; i < executerCount; i++) {
            executorService.execute(()->{
                try {
                    // 执行方法用于获取执行许可，当总计未释放的许可不超过executerCount时授权
                    // 否则线程阻塞等待，直到获得许可
                    semaphore.acquire();
                    runHandler.handler();
                    // 执行后释放许可
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }

            });
        }
        // 线程阻塞，直到闭锁值为0时，阻塞才能释放，继续往下执行
        countDownLatch.await();
        executorService.shutdown();//
    }

    public interface RunHandler{
        void handler();
    }
}

