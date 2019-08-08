package lyb.practice.behavioral.template.jdbc.dao;

import org.junit.*;

import java.util.List;

/**
 * MemberDao Tester.
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
 * @since <pre>08/08/2019</pre>
 */
public class MemberDaoTest {

    private static MemberDao testedClass;

    @BeforeClass
    public static void init() {
        testedClass = new MemberDao(null);
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: selectAll()
     */
    @Test
    public void testSelectAll() throws Exception {
        List<?> result = testedClass.selectAll();
        System.out.println(result);
    }


} 
