package lyb.practice.creational.prototype.deep;

import org.junit.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * DeeplyPrototype Tester.
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
 * @since <pre>07/23/2019</pre>
 */
public class DeeplyPrototypeTest {

    private static DeeplyPrototype testedClass;

    @BeforeClass
    public static void init() {
        testedClass = new DeeplyPrototype();
        testedClass.setBirthday(new Date());
        testedClass.setWeight(12);
        testedClass.setHeight(24);
        testedClass.setJinGuBang(new JinGuBang());
        testedClass.setHaomaos(new ArrayList<Haomao>());
        testedClass.getHaomaos().add(new Haomao(34L));
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }


    /**
     * Method: deepclone()
     */
    @Test
    public void testDeepclone() throws Exception {
        DeeplyPrototype clone = (DeeplyPrototype)testedClass.deepclone();
        // 克隆的对象应该不同
        Assert.assertNotSame(clone,testedClass);
        // 深克隆应该有独立的引用属性对象
        Assert.assertNotSame(clone.getBirthday(),testedClass.getBirthday());
        Assert.assertNotSame(clone.getHaomaos(),testedClass.getHaomaos());
        Assert.assertNotSame(clone.getHaomaos().get(0),testedClass.getHaomaos().get(0));

        // 克隆的基本数据类型应该相等
        Assert.assertEquals(clone.getHaomaos().get(0).getLength(),testedClass.getHaomaos().get(0).getLength(),1e-6);
    }

    /**
     * Method: superficialClone()
     */
    @Test
    public void testSuperficialClone() throws Exception {
        DeeplyPrototype clone = (DeeplyPrototype)testedClass.superficialClone();
        // 克隆的对象应该不同
        Assert.assertNotSame(clone,testedClass);
        // 深克隆应该有相同的引用属性对象
        Assert.assertSame(clone.getBirthday(),testedClass.getBirthday());
        Assert.assertSame(clone.getHaomaos(),testedClass.getHaomaos());
        Assert.assertSame(clone.getHaomaos().get(0),testedClass.getHaomaos().get(0));

        // 克隆的基本数据类型应该相等
        Assert.assertEquals(clone.getHaomaos().get(0).getLength(),testedClass.getHaomaos().get(0).getLength(),1e-6);
    }


} 
