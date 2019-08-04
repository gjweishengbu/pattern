package lyb.practice.structure.proxy.dbroute.proxy; 

import lyb.practice.structure.proxy.dbroute.entity.Order;
import lyb.practice.structure.proxy.dbroute.mvc.OrderService;
import org.junit.*;

import java.util.Date;

/** 
* OrderServiceStaticProxy Tester. 
* run report state:1 Failure where does not fit you want.
*                  2 error test code has bug.
* used often 1 @BeforeClass: run first when class was loaded,for configation.
*            2 @AfterClass: run at the end of test.
*            3 @Before,@After run at everytest method Before or After.
*            4 @Test(excepted=XX.class) run Ignore with same Exception.
*            5 @Test(timeout=millisecond) millisecond was allowed to ru.
*            6 @Ignore Ignored by test executer
* @author $user
* @since <pre>08/03/2019</pre> 
* @version 1.0 
*/ 
public class OrderServiceStaticProxyTest { 

private static OrderServiceStaticProxy  testedClass;

@BeforeClass
public static void init(){
    testedClass = new OrderServiceStaticProxy(new OrderService());
}

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: createOrder(Order order) 
* 
*/ 
@Test
public void testCreateOrder() throws Exception {
    Order order = new Order();
    order.setCreateTime(new Date().getTime());
    testedClass.createOrder(order);
}


} 
