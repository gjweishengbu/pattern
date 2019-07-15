package lyb.practice.creational.abstractFacctory;

import lyb.practice.creational.Food;
import lyb.practice.creational.Tool;
import lyb.practice.creational.abstractFacctory.StandardSuperFactoey;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * StandardSuperFactoey Tester.
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
 * @since <pre>07/14/2019</pre>
 */

public class StandardSuperFactoeyTest {

    private static StandardSuperFactoey testedClass;

    @BeforeClass
    public static void init() {
        testedClass = new StandardSuperFactoey();
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: createFood()
     */
    @Test
    public void testCreateFood() throws Exception {
        Food food = testedClass.createFood();
        Assert.assertTrue(food.getClass().getSimpleName().equals("Meat"));
    }

    /**
     * Method: createTool()
     */
    @Test
    public void testCreateTool() throws Exception {
        Tool tool = testedClass.createTool();
        Assert.assertTrue(tool.getClass().getSimpleName().equals("Knife"));

    }




    /**
     *
     * Method: use()
     *
     */
    @Test
    public void testUse() throws Exception {
        Food food = testedClass.createFood();
        Tool tool = testedClass.createTool();
        testedClass.use();
    }


}
