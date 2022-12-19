package lab0;

public class Variant1 {
    public enum DAY_OF_WEEK {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    /**
     * @param a is square side
     * @return perimeter
     */
    public int inputOutputTask(int a) {
        assert a > 0 : "a must be  > 0";
        return 4 * a;
    }

    /**
     * @param k is distance in cm
     * @return distance in m
     */

    public int integerNumbersTask(int k) {
        assert k > 0 : "Parameter k must be  > 0";
        return k / 100;
    }

    /**
     * @param number
     * @return true, if number is possitive
     */
    public boolean booleanTask(int number) {
        return number > 0;
    }

    /**
     * @param parameter is integer number
     * @return transformed number+1
     */
    public int ifTask(int parameter) {
        if (parameter > 0) {
            return parameter + 1;
        }
        return parameter;
    }

    /**
     * @param number1
     * @return day of week day represented number1
     */
    public DAY_OF_WEEK switchTask(int number1) {
        assert number1 >= 0 : "Parameter number1 must be  > 0";
        switch (number1) {
            case 1:
                return DAY_OF_WEEK.SUNDAY;
            case 2:
                return DAY_OF_WEEK.MONDAY;
            case 3:
                return DAY_OF_WEEK.TUESDAY;
            case 4:
                return DAY_OF_WEEK.WEDNESDAY;
            case 5:
                return DAY_OF_WEEK.THURSDAY;
            case 6:
                return DAY_OF_WEEK.FRIDAY;
            case 7:
                return DAY_OF_WEEK.SATURDAY;
            default:
                throw new IllegalArgumentException("number must not be more than 7");
        }
    }

    /**
     * @param n is integer number
     * @return k n times
     */
    public int[] forTask(int n, int k) {
        assert n > 0 : "Argument should be more than zero";
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = array[i] + k;
        }
        return array;
    }

    /**
     * @param a,b are integer numbers
     * @return k the length of the unoccupied part of segment a
     */
    public int whileTask(int a, int b) {
        assert a > b : "Argument a should be more than b";
        assert a > 0 || b > 0 : "Argument should be more than zero";
        while (a - b >= 0) {
            a = a - b;
        }
        return a;
    }

    /**
     * @param n the length of array
     * @returnarray of size N containing the first N positive odd numbers: 1, 3, 5
     */
    public double[] arrayTask(int n) {
        assert n > 0 : "Argument should be more than zero";
        double array[] = new double[n];
        for (int i = 0; i < n; i++) {
            array[i] = 1 + i * 2;
        }
        return array;
    }

    /**
     * @param m
     * @param n
     * @return returned a matrix value of elements = 10·I (I = 1, …, M).
     */
    public int[][] matrixTask(int m, int n) {
        assert n > 0 && m > 0 : "m,n must be greater than 1";
        int array[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = 10 * i;
            }
        }
        return array;
    }

}
