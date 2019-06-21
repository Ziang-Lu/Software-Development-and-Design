import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/*
 * A test suite binds several test cases, and run them at the same time.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ TestCasePositive.class, TestCaseNegative.class })
public class TestSuiteSimple extends TestSuite {}
