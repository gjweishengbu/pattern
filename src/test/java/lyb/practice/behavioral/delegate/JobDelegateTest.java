package lyb.practice.behavioral.delegate;

import org.junit.*;

/**
 * JobDelegate Tester.
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
 * @since <pre>08/05/2019</pre>
 */
public class JobDelegateTest {

    private static JobDelegate testedClass;

    @BeforeClass
    public static void init() {
        testedClass = new JobDelegate();
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: dispatchJob(String order)
     */
    @Test
    public void testDispatchJob() throws Exception {
        testedClass.dispatchJob("coding");
        testedClass.dispatchJob("design");
        testedClass.dispatchJob("clean");
        testedClass.dispatchJob("");
        testedClass.dispatchJob(null);
    }


} 
