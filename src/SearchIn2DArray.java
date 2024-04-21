public class SearchIn2DArray {
    public static void main(String[] args) {
        // given sorted NxM size matrix
        int arr[][] = {
                { 3, 4, 7, 9 },
                { 12, 13, 16, 18 },
                { 20, 21, 23, 29 }
        };
        int target = 29;
        //SearchIn2DArray.searchBrute(arr, target);
        SearchIn2DArray.searchOptimal(arr, target);
    }

    public static boolean searchBrute(int[][] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i].length - 1; j >= 0; j--) {
                if (arr[i][j] < target) {
                    break;
                } else if (arr[i][j] == target) {
                    System.out.println("Index - [" + i + "," + j+"]");
                    return true;
                }
            }
        }
        return false;

    }

    public static boolean searchOptimal(int[][] arr, int target) {
        // Over here we are trying to imagine the 2D array as 1D array
        // It will be easy to do BS(Binary Search) on 1D array.
        // In order to do that we have to use below formula for
        // calculating row and column as 1D array equivalent indexes.
        // n = #row
        // m = #column
        // Row = index / m
        // Column = index % m
        int n = arr.length; // #row
        int m = arr[0].length; // #column
        int low = 0, high = (n * m) - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / m, column = mid % m;
            if (arr[row][column] == target){
                System.out.println("index : ["+row+","+column+"]");
                return true;
            }
            else if (arr[row][column] < target)
                low = mid + 1;
            else
                high = mid - 1;

        }
        return false;

    }
}
