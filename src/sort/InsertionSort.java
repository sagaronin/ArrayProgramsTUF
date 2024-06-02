package sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        //in insertion sort you take one element and try to find it best position in array
        // you swap it until that position is found.
        int arr[] = { 2, 5, 9, 3, 7, 4, 11, 19 };
        System.out.println("Insertion Sort: " + Arrays.toString(InsertionSort.insertionSort(arr)));
    }

    public static int[] insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1; // j =indexOfElementbeforeKey
            while (j >= 0 && arr[j] > key) {
                //swap with that element and reduce the value of indexOfElementbeforeKey
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        return arr;
    }
}
