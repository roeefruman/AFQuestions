import javafx.util.Pair;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


class subtractTests {
    public interface RunMyTest {
        List<Pair> runTest(List<Pair> a, List<Pair> b);
    }

    enum ListType {
        LINKED_LIST,
        ARRAY_LIST,
        STACK,
        VECTOR
    }

    @org.junit.jupiter.api.Test
    void substractListsHashSolution() {
        RunMyTest substractListsHashSolution = (List<Pair> a, List<Pair> b) -> SubtractList.substractListsHashSolution(a, b);
        runTestSeriesForAllListTypes(substractListsHashSolution, "substractListsHashSolution", true);
    }

    @org.junit.jupiter.api.Test
    void substractListsShortCode() {
        RunMyTest substractListsShortCode = (List<Pair> a, List<Pair> b) -> SubtractList.substractListsShortCode(a, b);
        runTestSeriesForAllListTypes(substractListsShortCode, "substractListsShortCode", false);

    }

    @org.junit.jupiter.api.Test
    void substractListsPlain() {
        RunMyTest substractListsPlain = (List<Pair> a, List<Pair> b) -> SubtractList.substractListsPlain(a, b);
        runTestSeriesForAllListTypes(substractListsPlain, "substractListsPlain", false);
    }

    private void runTestSeriesForAllListTypes(RunMyTest f, String functionTested, boolean extraPerformanceTest) {
        for (ListType t : ListType.values()) {
            runTestSeries(f, functionTested, t, extraPerformanceTest);
        }
    }

    private void runTestSeries(RunMyTest f, String functionTested, ListType t, boolean extraPerformanceTest) {
        // Empty A and B
        testCase(f, t,functionTested+"Empty A and Empty B",1, 0, 1,
                1, 0, 1,
                51, 0, 1, false, extraPerformanceTest);

        // Empty A and single item B
        testCase(f, t,functionTested+"Empty A and single item B",1, 0, 1,
                1, 1, 3,
                1, 0, 3, false, extraPerformanceTest);

        // Empty A and multi items B including negative 0 and positive
        testCase(f, t,functionTested+"Empty A and multi items B",1, 0, 1,
                -50, 100, 3,
                1, 0, 3, false, extraPerformanceTest);
        //=================================================================
        // single item A and Empty B
        testCase(f, t,functionTested+ "signle A and Empty B",0, 0, 1,
                1, 0, 1,
                0, 0, 1, false, extraPerformanceTest);

        // single item A and single item B NOT InterSecting
        testCase(f, t,functionTested+" single A and single item B NOT InterSecting",-7, -7, 1,
                1, 1, 3,
                -7, -7, 3, false, extraPerformanceTest);

        // single item A and single item B  InterSecting
        testCase(f, t,functionTested+" single A and single item B InterSecting",-7, -7, 1,
                -7, -7, 3,
                -7, -8, 3, false, extraPerformanceTest);

        // multi A and multi items B non-intersecting
        testCase(f, t,functionTested+" multi A and multi items B non-intersecting",-100, 100, 3,
                -99, 100, 3,
                -100, 100, 3, false, extraPerformanceTest);

        // multi A and multi items B intersecting
        testCase(f, t,functionTested+" multi A and multi items B intersecting 1",-100, 100, 3,
                -1, 100, 3,
                -100, -2, 3, false, extraPerformanceTest);

        // multi A and multi items B intersecting
        testCase(f, t,functionTested+" multi A and multi items B intersecting 2",-100, 100, 3,
                -100, 100, 6,
                -97, 100, 6, false, extraPerformanceTest);


        // multi A and multi items B intersecting Large Input performance test
        testCase(f, t,functionTested+" 40,000 multi A and multi items B intersecting",-20000, 20000, 1,
                -20000, 20000, 2,
                -20000+1, 20000, 2, true, extraPerformanceTest);

        // multi A and multi items B intersecting Large Input performance test
        if (extraPerformanceTest) {
            testCase(f, t, functionTested + " 4,000,000 multi A and multi items B intersecting", -2000000, 2000000, 1,
                    -2000000, 2000000, 2,
                    -2000000 + 1, 2000000, 2, true, extraPerformanceTest);
        }
    }

    private Runtime runtime = Runtime.getRuntime();

    private void runGc() {
        for (int i = 0; i < 5; i++) {
            runtime.gc();
        }
    }

    private void testCase(RunMyTest f, ListType t, String testName, int aFrom, int aTo, int aSkip,
                          int bFrom, int bTo, int bSkip,
                          int resultFrom, int resultTo,
                          int resultSkips, boolean shouldPrintPerformanceTiming, boolean extraPerformanceTest) {
        List<Pair> a = getList(t);
        List<Pair> b = getList(t);
        List<Pair> expectedResult = getList(t);
        populateList(a, aFrom, aTo, aSkip);
        populateList(b, bFrom, bTo, bSkip);
        populateList(expectedResult, resultFrom, resultTo, resultSkips);

            runGc();
            long startTimeMilis = System.currentTimeMillis();


        assertEquals(f.runTest(a,b), expectedResult , "Failed:"+testName+ " - " + t.name());
           long endTime = System.currentTimeMillis();

        if (shouldPrintPerformanceTiming) {
            System.out.printf(testName + " - " + t.name() + " - took " + (endTime - startTimeMilis) + "ms\n");
        }
            runGc();
    }

    private static List<Pair> getList(ListType listType) {
        switch (listType){
            case LINKED_LIST:
                return new LinkedList<>();
            case ARRAY_LIST:
                return new ArrayList<>();
            case STACK:
                return new Stack<>();
            case VECTOR:
                return new Vector<>();
            default:
                return null;
        }

    }



    private void populateList(List<Pair> items, int from, int to, int skips) {
        for (int i = from; i <= to; i+=skips) {
            items.add(new Pair(i,"P" +i));
        }
    }
}