package lyb.practice.structure.proxy.dynamic.jdkproxy.myjdk;

import lyb.practice.structure.subject.MaleSinglePerson;
import lyb.practice.structure.subject.SinglePerson;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * MyDynamicProxy Tester.
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
 * @since <pre>07/29/2019</pre>
 */
public class MyDynamicProxyTest {

    private static MyDynamicProxy testedClass;

    @BeforeClass
    public static void init() {
        testedClass = new MyDynamicProxy();
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getInstance(Object targetProxied)
     */
    @Test
    public void testGetInstance() throws Exception {
        // 两种方式均产生一个新的类，在内存中加载，调用新类的方法。
//        Object obj = testedClass.getInstance(new FemaleSinglePerson());
//        Method method = obj.getClass().getMethod("findLover",null);
//        method.invoke(obj);

        SinglePerson person = (SinglePerson) testedClass.getInstance(new MaleSinglePerson());
        person.findLover();
    }
}


