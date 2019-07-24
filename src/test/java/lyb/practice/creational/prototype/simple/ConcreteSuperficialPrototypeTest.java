package lyb.practice.creational.prototype.simple;

import org.junit.*;

import java.util.ArrayList;

/**
 * ConcreteSuperficialPrototype Tester.
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
 * @since <pre>07/22/2019</pre>
 */
public class ConcreteSuperficialPrototypeTest {

    private static ConcreteSuperficialPrototype testedClass;

    @BeforeClass
    public static void init() {
        testedClass = new ConcreteSuperficialPrototype();
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: clone()
     */
    @Test
    public void testClone() throws Exception {
        testedClass.setList(new ArrayList());
        testedClass.setName("efe");
        testedClass.setAge(34);

        ConcreteSuperficialPrototype clone = (ConcreteSuperficialPrototype)testedClass.clone();
        // 克隆的对象应该不同
        Assert.assertNotSame(clone,testedClass);
        // 克隆的对象基本数据类型修改前应该不同
        Assert.assertEquals(clone.getAge(),testedClass.getAge());
        // 克隆的对象引用数据类型修改前应该相同
        Assert.assertSame(clone.getList(),testedClass.getList());

        // 修改克隆的属性
        clone.setAge(testedClass.getAge()+1);
        clone.setName(testedClass.getName()+"1");
        clone.setList(new ArrayList());
        // 克隆的对象基本数据类型修改后应该不同
        Assert.assertNotEquals(clone.getAge(),testedClass.getAge());
        Assert.assertNotEquals(clone.getName(),testedClass.getName());
        // 克隆的对象引用数据类型修改后应该相同
        Assert.assertNotSame(clone.getList(),testedClass.getList());

    }


} 
