package lyb.practice.structure.adapter.login.versionAdapter;

import org.junit.*;

/**
 * PassportForThirdAdapter Tester.
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
public class PassportForThirdAdapterTest {

    private static PassportForThirdAdapter testedClass;

    @BeforeClass
    public static void init() {
        testedClass = new PassportForThirdAdapter();
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: loginForQQ(String id)
     */
    @Test
    public void testLoginForQQ() throws Exception {

        testedClass.loginForQQ("fff");
    }

    /**
     * Method: loginForWechat(String id)
     */
    @Test
    public void testLoginForWechat() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: loginForToken(String token)
     */
    @Test
    public void testLoginForToken() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: loginForTelphone(String telphone, String code)
     */
    @Test
    public void testLoginForTelphone() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: loginForRegist(String username, String passport)
     */
    @Test
    public void testLoginForRegist() throws Exception {
//TODO: Test goes here... 
    }


    /**
     * Method: processLogin(String key, Class<? extends LoginAdapter> adapterCLazz)
     */
    @Test
    public void testProcessLogin() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = PassportForThirdAdapter.getClass().getMethod("processLogin", String.class, Class<?.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
