package lyb.practice.structure.proxy.simpleStatic;

import lyb.practice.structure.subject.MaleSinglePerson;
import org.junit.*;

/**
 * SimpleProxy Tester.
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
 * @since <pre>07/26/2019</pre>
 */
public class SimpleProxyTest {

    private static SimpleProxy testedClass;

    @BeforeClass
    public static void init() {
//        testedClass = new SimpleProxy(new FemaleSinglePerson());
        testedClass = new SimpleProxy(new MaleSinglePerson());
    }


    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: findLover()
     */
    @Test
    public void testContainerSingleton() throws Exception {
        testedClass.findLover();
    }


} 
