package lyb.practice.behavioral.strategy.promotion; 

import org.junit.*;

/** 
* Activity Tester. 
* run report state:1 Failure where does not fit you want.
*                  2 error test code has bug.
* used often 1 @BeforeClass: run first when class was loaded,for configation.
*            2 @AfterClass: run at the end of test.
*            3 @Before,@After run at everytest method Before or After.
*            4 @Test(excepted=XX.class) run Ignore with same Exception.
*            5 @Test(timeout=millisecond) millisecond was allowed to ru.
*            6 @Ignore Ignored by test executer
* @author $user
* @since <pre>08/06/2019</pre> 
* @version 1.0 
*/ 
public class ActivityTest { 

private static Activity  testedClass;

@BeforeClass
public static void init(){

}

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: execute() 
* 
*/ 
@Test
public void testExecute() throws Exception {
    // 调用者需要知道所有策略
    new Activity(new CashbackStrategy()).execute();
    new Activity(new CouponStrategy()).execute();
    new Activity(new EmptyStrategy()).execute();
    new Activity(new GroupbuyStrategy()).execute();

}
    /**
     *
     * Method: executeByName(String promotionKey)
     *
     */
    @Test
    public void testExecuteByName() throws Exception {
        Activity.executeByName("COUPON");
        Activity.executeByName("CASHBACK");
        Activity.executeByName("GROUPBUG");
        Activity.executeByName("NULL");
        Activity.executeByName(null);
    }

} 
