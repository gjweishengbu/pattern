package lyb.practice.behavioral.observer.jdk;

import org.junit.*;

/**
 * Gper Tester.
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
 * @since <pre>08/19/2019</pre>
 */
public class GperTest {

    private static Gper testedClass;

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
     * Method: getInstance()
     */
    @Test
    public void testGetInstance() throws Exception {
        testedClass = Gper.getInstance();
    }

    /**
     * Method: deleveQuestion(Teacher teacher, Question question)
     */
    @Test
    public void testDeleveQuestion() throws Exception {
        testedClass = Gper.getInstance();

        Teacher teacher = new Teacher("Tom");
        Question question =  new Question();
        question.setAsker("lyb");
        question.setContent("问题内容！");
        testedClass.deleveQuestion(teacher,question);
    }




} 
