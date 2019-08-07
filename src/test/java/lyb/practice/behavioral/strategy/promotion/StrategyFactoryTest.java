package lyb.practice.behavioral.strategy.promotion;

import org.junit.*;

/**
 * StrategyFactory Tester.
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
 * @since <pre>08/06/2019</pre>
 */
public class StrategyFactoryTest {

    private static StrategyFactory testedClass;

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
     * Method: getPromotionStrategy(String promotionKey)
     */
    @Test
    public void testGetPromotionStrategy() throws Exception {
        StrategyFactory.getPromotionStrategy("COUPON").doPromotion();
        StrategyFactory.getPromotionStrategy("CASHBACK").doPromotion();;
        StrategyFactory.getPromotionStrategy("GROUPBUY").doPromotion();;
        StrategyFactory.getPromotionStrategy("NULL").doPromotion();;
        StrategyFactory.getPromotionStrategy(null).doPromotion();;








    }


} 
