import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestJunitAnnotationRunner {

    /**
     * Test runner.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestJunitAnnotation.class);
        System.out.println("Test passed? -> " + result.wasSuccessful());
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
    }

}
