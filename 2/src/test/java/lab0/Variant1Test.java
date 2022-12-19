package lab0;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import lab0.Variant1.DAY_OF_WEEK;
import org.testng.annotations.Test;

public class Variant1Test {

    ////////////////////////////////////////////////
    //    Testing inputOutputTask +
    @Test(dataProvider = "inputProvider")
    public void inputTest(int p1, long p3) {
        assertEquals(new Variant1().inputOutputTask(p1), p3);
    }

    @DataProvider
    public Object[][] inputProvider() {
        return new Object[][] { { 2, 8 }, { 6, 24 } };
    }

    @Test(expectedExceptions = AssertionError.class)
    public void negativeInputTest() {
        new Variant1().inputOutputTask(-2);
    }

    ////////////////////////////////////////////////
    //    Testing integerNumbersTask +
    @Test(dataProvider = "integerProvider")
    public void inputTest(int p1, int p3) {
        assertEquals(new Variant1().integerNumbersTask(p1), p3);
    }

    @DataProvider
    public Object[][] integerProvider() {
        return new Object[][] { { 100, 1 }, { 12, 0 }, { 139, 1 } };
    }

    @Test(expectedExceptions = AssertionError.class)
    public void negativeIntegerTest() {
        new Variant1().integerNumbersTask(-10);
    }

    //////////////////////////////////////////////////
    //    Testing booleanTask +
    @Test(dataProvider = "booleanProvider")
    public void booleanTest(int p1, boolean p3) {
        assertEquals(new Variant1().booleanTask(p1), p3);
    }

    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][] { { 5, true }, { 0, false }, { -3, false } };
    }

    ////////////////////////////////////////////////
    //    Testing ifTask +
    @Test(dataProvider = "ifProvider")
    public void ifTest(int p1, int p3) {
        assertEquals(new Variant1().ifTask(p1), p3);
    }

    @DataProvider
    public Object[][] ifProvider() {
        return new Object[][] { { 2, 3 }, { 0, 0 }, { -3, -3 } };
    }


    //////////////////////////////////////////////////
    //    Testing switchTask +
    @Test(dataProvider = "switchProvider")
    public void switchTest(int p1, DAY_OF_WEEK p2) {
        assertEquals(new Variant1().switchTask(p1), p2);
    }

    @DataProvider
    public Object[][] switchProvider() {
        return new Object[][] { { 3, DAY_OF_WEEK.TUESDAY }, { 6, DAY_OF_WEEK.FRIDAY }};
    }

    @Test(expectedExceptions = AssertionError.class)
    public void switchNegativeTest() {
        new Variant1().switchTask(-2);
    }

    ///////////////////////////////////////////////////-----
    //    Testing forTest +
    @Test(dataProvider = "forProvider")
    public void forTest(int n, int k, int[] p) {
        assertEquals(new Variant1().forTask(n,k), p);
    }

    @DataProvider
    public Object[][] forProvider() {
        return new Object[][] { {3, 4,  new int[]{4,4,4}}, {5, 2,  new int[]{2,2,2,2,2}}};
    }

    //////////////////////////////////////////
    //    Testing whileTask +
    @Test(dataProvider = "whileProvider")
    public void whileTest(int a, int b, int c) {
        assertEquals(new Variant1().whileTask(a, b), c);
    }

    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][] { { 5, 2, 1 },{ 12, 10, 2 } };
    }

    @Test(expectedExceptions = AssertionError.class)
    public void negativeWhileTest() {
        new Variant1().whileTask(-2,-5);
    }

    //////////////////////////////////////////
    //    Testing arrayTask +
    @Test(dataProvider = "arrayProvider")
    public void arrayTest(int value, double[] array1) {
        assertEquals(new Variant1().arrayTask(value), array1);
    }

    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][] { { 3, new double[]{1, 3, 5} },{ 5, new double[]{1, 3, 5, 7, 9} } };
    }

    @Test(expectedExceptions = AssertionError.class)
    public void arrayNegativeTest() {
        new Variant1().arrayTask(-2);
    }

    //////////////////////////////////////////
    //    Testing matrixTask +
    @Test(dataProvider = "matrixProvider")
    public void matrixTaskTest(int from, int to, int[][] output) {
        assertEquals(new Variant1().matrixTask(from, to), output);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void matrixTaskNegativeTest() {
        new Variant1().matrixTask(-2,0);
    }

    @DataProvider
    public Object[][] matrixProvider() {

        int[][] output1 = {
                {0, 0, 0, 0},
                {10, 10, 10, 10},
                {20, 20, 20, 20},
                {30, 30, 30, 30},
        };
        int[][] output2 = {
                {0, 0, 0, 0},
                {10, 10, 10, 10},
        };

        return new Object[][] { {4, 4, output1},{2, 4, output2}};

    }
}

