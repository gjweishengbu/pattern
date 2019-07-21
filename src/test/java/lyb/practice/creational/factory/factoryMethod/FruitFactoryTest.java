package lyb.practice.creational.factory.factoryMethod;

import lyb.practice.creational.Food;
import org.junit.*;

/** 
* FruitFactory Tester. 
* run report state:1 Failure where does not fit you want.
*                  2 error test code has bug.
* used often 1 @BeforeClass: run first when class was loaded,for configation.
*            2 @AfterClass: run at the end of test.
*            3 @Before,@After run at everytest method Before or After.
*            4 @Test(excepted=XX.class) run Ignore with same Exception.
*            5 @Test(timeout=millisecond) millisecond was allowed to ru.
*            6 @Ignore Ignored by test executer
* @author $user
* @since <pre>07/12/2019</pre> 
* @version 1.0 
*/ 
public class FruitFactoryTest { 

private static FruitFactory  testedClass;

@BeforeClass
public static void init(){
    testedClass = new FruitFactory();
}

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: create(String name) 
* 
*/ 
@Test
public void testCreate() throws Exception {
    Food fruit = testedClass.create("水果");
    Assert.assertTrue(fruit.getClass().getSimpleName().equals("Fruit"));
    Food meal = testedClass.create("火龙果");
    meal.show();
    Food nullMeal = testedClass.create(null);
    Assert.assertNull(nullMeal);
}


} 
