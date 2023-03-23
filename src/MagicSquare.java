public class MagicSquare {

    /**
     *
     * @param array2d
     * @return the sum of the first row in array2d.
     */
    public static int calculateCheckSum(int[][] array2d) {
        int sum = 0;
        for (int i : array2d[0]) sum += i;

        return (sum);
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each row in array2d is equal to checkSum or not.
     *         Because we have already determined the sum of the first row
     *         via the method 'calculateCheckSum', this method can begin
     *         iterating from the second row.
     */
    public static boolean magicRows(int[][] array2d, int checkSum) {
        int sum = 0;
        for (int[] ints : array2d) {
            for (int a : ints) sum += a;
            if (sum != checkSum) {
                return(false);
            }
            sum = 0;
        }
        return(true);
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each column in array2d is equal to checkSum or not.
     */
    public static boolean magicColumns(int[][] array2d, int checkSum) {
        int sum = 0;
        for (int i = 0; i < array2d[0].length; i++){
            for (int[] ints : array2d) {
                sum += ints[i];
            }
            if (sum != checkSum) {
                return(false);
            }
            sum = 0;
        }
        return(true);
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each of the two main diagonals is equal to checkSum or not.
     */
    public static boolean magicDiagonals(int[][] array2d, int checkSum) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < array2d.length; i++){
            sum1 += array2d[i][array2d.length - 1 - i];
            sum2 += array2d[i][i];

        }
        return sum1 == checkSum && sum2 == checkSum;
    }

    /**
     *
     * @param array2d
     * @return whether array2d is magic or not.
     */
    public static boolean isMagic(int[][] array2d) {
        int num = calculateCheckSum(array2d);
        return (magicRows(array2d, num) && magicColumns(array2d, num) && magicDiagonals(array2d, num));
    }

}
