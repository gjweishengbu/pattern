package lyb.practice.behavioral.template.cooking;

import org.junit.*;

/**
 * VegetableCooking Tester.
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
 * @since <pre>08/08/2019</pre>
 */
public class VegetableCookingTest {

    private static VegetableCooking testedClass;

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
     * Method: cooking()
     */
    @Test
    public void testCooking() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: noMaterial()
     */
    @Test
    public void testNoMaterial() throws Exception {
        testedClass = new VegetableCooking(true,"空心菜");
//        testedClass = new VegetableCooking(false,"油麦菜");
        testedClass.createMeal();
    }


} 
