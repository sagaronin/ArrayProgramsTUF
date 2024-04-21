import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveZeroToEnd {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 0, 5, 0, 6 };
        // MoveZeroToEnd.moveZerotoEndBruteForce(arr);
        MoveZeroToEnd.moveZerotoEndOptimal(arr);
    }

    public static void moveZerotoEndBruteForce(int[] arr) {
        // store non zero in separate list
        int count = 0;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0)
                list.add(arr[i]);
            else
                count = count + 1;
        }
        // move all non zero values starting from one
        for (int i = 0; i < arr.length - count; i++) {
            arr[i] = list.get(i);
        }
        for (int i = arr.length - count; i < arr.length; i++) {
            arr[i] = 0;
        }
        System.out.println("Brute Force : " + Arrays.toString(arr));
    }

    public static void moveZerotoEndOptimal(int[] arr) {
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }
        if (j == -1) {
            System.out.println("There are no zeroes!");
        } else {
            for (int i = j + 1; i < arr.length; i++) {
                if (arr[i] != 0) {
                    arr[j] = arr[i];
                    arr[i] = 0;
                    j = j + 1;
                }
            }
            System.out.println("Optimal : " + Arrays.toString(arr));
        }
        

    }

}
