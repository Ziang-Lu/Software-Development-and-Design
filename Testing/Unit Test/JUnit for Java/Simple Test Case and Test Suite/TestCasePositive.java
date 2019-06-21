import junit.framework.TestCase;
import org.junit.Test;

/**
 * Test case that should pass.
 *
 * @author Ziang Lu
 */
public class TestCasePositive extends TestCase {

    /**
     * Message string for this test case.
     */
    private final String msg = "Robert";
    /**
     * Message utility for this test case.
     */
    private MessageUtil msgUtil = new MessageUtil(msg);

    @Test
    public void testPrintMsg() {
        System.out.println("Inside " + getName());
        assertEquals(msgUtil.printMessage(), msg);
    }

}
