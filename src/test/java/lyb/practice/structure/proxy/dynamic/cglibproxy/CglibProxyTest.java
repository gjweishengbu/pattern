package lyb.practice.structure.proxy.dynamic.cglibproxy;

import lyb.practice.structure.subject.FemaleSinglePerson;
import lyb.practice.structure.subject.MaleSinglePerson;
import lyb.practice.structure.subject.NormalSinglePerson;
import org.junit.*;
import org.springframework.cglib.core.DebuggingClassWriter;

/**
 * CGLibProxy Tester.
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
 * @since <pre>08/04/2019</pre>
 */
public class CglibProxyTest {

    private static CGLibProxy testedClass;

    @BeforeClass
    public static void init() {
        testedClass = new CGLibProxy();
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getInstance(Class<?> aClass)  intercept
     */
    @Test
    public void testGetInstance() throws Exception {
        // 借助工具类检查生成的代码
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"E://cglib_proxy_classes");

        NormalSinglePerson instance = (NormalSinglePerson)testedClass.getInstance(NormalSinglePerson.class);
//        MaleSinglePerson instance = (MaleSinglePerson)testedClass.getInstance(MaleSinglePerson.class);


        instance.findLover();

        // 增加方法
        instance.getMarried();

        // 尝试调用final方法,结果展示并没有增强
        instance.getMarriedFinal();


    }






} 
