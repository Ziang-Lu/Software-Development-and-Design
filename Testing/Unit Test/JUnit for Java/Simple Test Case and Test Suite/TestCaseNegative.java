import junit.framework.TestCase;
import org.junit.Test;

public class TestCaseNegative extends TestCase {

    /**
     * Message string for this test case.
     */
    private String msg = "Robert";
    /**
     * Message utility for this test case.
     */
    MessageUtil msgUtil = new MessageUtil(msg);

    @Test
    public void testPrintMsg() {
        System.out.println("Inside " + getName());
        msg = "Hi! Robert";
        assertEquals(msgUtil.printMessage(), msg);
    }

}
