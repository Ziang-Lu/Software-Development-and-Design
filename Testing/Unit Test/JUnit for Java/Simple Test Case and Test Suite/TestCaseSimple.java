import junit.framework.TestCase;
import org.junit.Test;

/*
 * A test case must inherit junit.framework.TestCase
 *
 * @author Ziang Lu
 */
public class TestCaseSimple extends TestCase {

    /**
     * Two values used for testing.
     */
    private int val1, val2;

    /*
     * This method will be called to set up the testing environment for each
     * single test.
     * e.g., If a single test requires connecting to a database, we can make the
     * connection in this setUp() method.
     * @see junit.framework.TestCase#setUp()
     */
    @Override
    protected void setUp() {
        val1 = 2;
        val2 = 3;
    }

    /*
     * This method will be called to clean up the testing environment for each
     * single test.
     * e.g., If a single test connects to a database, we can close the
     * connection in this tearDown() method.
     * @see junit.framework.TestCase#tearDown()
     */
    @Override
    protected void tearDown() {
        val1 = 0;
        val2 = 0;
    }

    /*
     * Any single method annotated "@Test" will be tested by JUnit framework.
     */
    @Test
    public void testAdd() {
        System.out.println(this.getName());
        int result = val1 + val2;
        assertEquals(result, 5);
        // Positive test
    }

    @Test
    public void testSubtract() {
        int result = val1 - val2;
        assertEquals(result, 0);
        // Negative test
    }

}
