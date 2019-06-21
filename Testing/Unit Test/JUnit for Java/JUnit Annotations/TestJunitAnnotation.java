import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class TestJunitAnnotation {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("In beforeClass(): this method is executed before all tests.");
    }

    @Before
    public void before() {
        System.out.println("In before(): this method is executed before each single test.");
        // This is similar to TestCase.setUp() method.
    }

    @After
    public void after() {
        System.out.println("In after(): this method is executed after each single test.");
        // This is similar to TestCase.tearDown() method.
    }

    @Test
    public void test1() {
        System.out.println("In test1");
    }

    @Test
    public void test2() {
        System.out.println("In test2");
    }

    @Ignore
    @Test
    public void test3() {
        System.out.println("This test should be ignored and not executed.");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("In afterClass(): this method is executed after all tests.");
    }

}
