package pa3.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
//import junit.tests.framework.TestListenerTest;
//import com.gradescope.pa0.tests.TestLineUsage;
import com.gradescope.jh61b.grader.GradedTestListenerJSON;
import com.gradescope.jh61b.junit.TestRunnerPrintAll;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestMatch.class,
      TestCoins.class,
	TestMTF.class,
            })
public class RunTests {
    public static void main(String[] args) {
        JUnitCore runner = new JUnitCore();
      runner.addListener(new GradedTestListenerJSON());
       //runner.addListener(new TestRunnerPrintAll());
        Result r = runner.run(RunTests.class);
    }
}
