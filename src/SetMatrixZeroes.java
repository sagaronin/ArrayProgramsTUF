import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int arr[][] = {
                { 1, 1, 1, 1 },
                { 1, 0, 0, 1 },
                { 1, 1, 0, 1 },
                { 1, 1, 1, 1 }
        };
        // SetMatrixZeroes.setMatrixZeroBrute(arr);
        SetMatrixZeroes.setMatrixZeroBetter(arr);
    }

    public static void setMatrixZeroBrute(int arr[][]) {
        // mark all affcted rown and column with -1
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    setValue(arr, i, j);
                }
            }
        }

        // change all -1 occurences to 0
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == -1) {
                    arr[i][j] = 0;
                }
            }
        }
        System.out.println("Set matrix zeroes(Brute) : " + Arrays.deepToString(arr));
    }

    private static void setValue(int[][] arr, int rowNum, int columnNum) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[rowNum][i] == 1)
                arr[rowNum][i] = -1;
            if (arr[i][columnNum] == 1)
                arr[i][columnNum] = -1;
        }
    }

    public static void setMatrixZeroBetter(int arr[][]) {
        int row[] = new int[arr.length];
        int column[] = new int[arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (row[i] == 1)
                setRowToZero(arr, i);
            if (column[i] == 1)
                setColumnToZero(arr, i);
        }
        System.out.println("Set Matrix zero(Better) : " + Arrays.deepToString(arr));

    }

    private static void setColumnToZero(int[][] arr, int i) {
        for (int j = 0; j < arr.length; j++) {
            arr[i][j] = 0;
        }
    }

    private static void setRowToZero(int[][] arr, int i) {
        for (int j = 0; j < arr.length; j++) {
            arr[j][i] = 0;
        }
    }

    private static void setMatrixZeroAlternateBetter(int arr[][]) {
        boolean frow = false, fcol = false;
        // set markers in first row and first column
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    if (i == 0)
                        frow = true;
                    if (j == 0)
                        fcol = true;
                    arr[0][j] = 0;
                    arr[i][0] = 0;
                }
            }
        }

        // replace zero values in inner matrix
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (arr[0][j] == 0 || arr[i][0] == 0) {
                    arr[i][j] = 0;
                }
            }
        }

        // if there was zero in first row in original array then
        if (frow)
            for (int i = 0; i < arr.length; i++)
                arr[0][i] = 0;

        // if there was zero in first column in original array then
        if (fcol)
            for (int i = 0; i < arr[0].length; i++)
                arr[i][0] = 0;

    }

}
