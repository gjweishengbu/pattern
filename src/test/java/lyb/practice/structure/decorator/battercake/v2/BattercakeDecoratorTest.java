package lyb.practice.structure.decorator.battercake.v2;

import org.junit.*;

/**
 * BattercakeDecorator Tester.
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
 * @since <pre>08/15/2019</pre>
 */
public class BattercakeDecoratorTest {

    private static BattercakeDecorator testedClass;

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
     * Method: getMsg()
     */
    @Test
    public void testGetMsg() throws Exception {
        testedClass = new EggBattercakeDecorator(new BaseBattercake());
        System.out.println(testedClass.getMsg()+" 总价："+testedClass.getPrice());

        testedClass = new EggBattercakeDecorator(testedClass);
        System.out.println(testedClass.getMsg()+" 总价："+testedClass.getPrice());

        testedClass = new HotdogBattercakeDecorator(testedClass);
        System.out.println(testedClass.getMsg()+" 总价："+testedClass.getPrice());



        for (int i = 0; i < 2; i++) {
            testedClass = new HotdogBattercakeDecorator(testedClass);
            System.out.println(testedClass.getMsg()+" 总价："+testedClass.getPrice());
        }
    }



} 
