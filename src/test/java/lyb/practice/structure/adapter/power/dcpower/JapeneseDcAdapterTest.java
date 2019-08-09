package lyb.practice.structure.adapter.power.dcpower;

import lyb.practice.structure.adapter.power.acpower.ChineseAcPower;
import lyb.practice.structure.adapter.power.acpower.JapeneseAcPower;
import org.junit.*;

/**
 * JapeneseDcAdapter Tester.
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
 * @since <pre>08/09/2019</pre>
 */
public class JapeneseDcAdapterTest {

    private static JapeneseDcAdapter testedClass;

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
     * Method: support()
     */
    @Test
    public void testSupport() throws Exception {
        testedClass = new JapeneseDcAdapter(new JapeneseAcPower());
        System.out.println(testedClass.support());
        testedClass = new JapeneseDcAdapter(new ChineseAcPower());
        System.out.println(testedClass.support());

    }

    /**
     * Method: outPutV()
     */
    @Test
    public void testOutPutV() throws Exception {
        testedClass = new JapeneseDcAdapter(new JapeneseAcPower());
        System.out.println(testedClass.outPutV());
        testedClass = new JapeneseDcAdapter(new ChineseAcPower());
        System.out.println(testedClass.outPutV());
    }


} 
