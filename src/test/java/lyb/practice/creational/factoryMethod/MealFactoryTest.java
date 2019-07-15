package lyb.practice.creational.factoryMethod; 

import lyb.practice.creational.Meat;
import org.junit.*;

/** 
* MealFactory Tester. 
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
public class MealFactoryTest { 

private static MealFactory  testedClass;

@BeforeClass
public static void init(){
    testedClass = new MealFactory();
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
    Meat fruit = testedClass.create("猪肉");
    Assert.assertTrue(fruit.getClass().getSimpleName().equals("Meat"));
    fruit.show();
    Meat meal = testedClass.create("牛肉");
    meal.show();
    Meat nullMeal = testedClass.create(null);
    Assert.assertNull(nullMeal);
} 


} 
