package lyb.practice.creational.factory.simpleFactory;

import lyb.practice.creational.Food;
import lyb.practice.creational.Fruit;
import lyb.practice.creational.Meat;
import org.junit.*;

/** 
* SimpleFactory Tester. 
* run report state:1 Failure where does not fit you want.
*                  2 error test code has bug.
* used often 1 @BeforeClass: run first when class was loaded,for configation.
*            2 @AfterClass: run at the end of test.
*            3 @Before,@After run at everytest method Before or After.
*            4 @Test(excepted=XX.class) run Ignore with same Exception.
*            5 @Test(timeout=millisecond) millisecond was allowed to ru.
*            6 @Ignore Ignored by test executer
* @author $user
* @since <pre>07/11/2019</pre> 
* @version 1.0 
*/ 
public class SimpleFactoryTest { 

private static SimpleFactory  sf;

@BeforeClass
public static void  init(){
    sf = new SimpleFactory();
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
    Food fruit = sf.create("FRUIT");
    Assert.assertTrue(fruit.getClass().getSimpleName().equals("Fruit"));
    fruit.show();
    Food meal = sf.create("MEAT");
    Assert.assertTrue(meal.getClass().getSimpleName().equals("Meat"));
    meal.show();
    Food nullMeal = sf.create(null);
    Assert.assertNull(nullMeal);
    Food nuknow = sf.create("NUKNOW");
    Assert.assertNull(nuknow);
}
    /**
     *
     * Method: createNew(Class<? extends Food> clazz)
     *
     */
    @Test
    public void testCreateNew() throws Exception {

        Food fruit = sf.createNew(Fruit.class);
        Assert.assertTrue(fruit.getClass().getSimpleName().equals("Fruit"));
        fruit.setName("火龙果");
        fruit.show();
        Food meal = sf.createNew(Meat.class);
        Assert.assertTrue(meal.getClass().getSimpleName().equals("Meat"));
        meal.setName("牛肉");
        meal.show();
        Food nullMeal = sf.createNew(null);
        Assert.assertNull(nullMeal);

    }

} 
