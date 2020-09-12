package principles.ioc.v2;

import java.util.ArrayList;
import java.util.List;

public class JunitApplication {

    private static final List<TestCase> testCases = new ArrayList<>();

    public static void register(TestCase testCase) {
        testCases.add(testCase);
    }

    public static void run() {
        for (TestCase testcase : testCases) {
            testcase.run();
        }
    }

}
