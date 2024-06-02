package sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        // in selection sort you iterate through the array and try to find the lowest
        // element.
        // once you find it you swap it with index variable whose value starts from 0.
        // once swapped you know one element is sorted hence you increment index by one.
        int arr[] = { 2, 5, 9, 3, 7, 4, 11, 19 };
        System.out.println("Selection Sort: " + Arrays.toString(SelectionSort.selectionSort(arr)));
    }

    public static int[] selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < n; j++)
                if (arr[minElementIndex] > arr[j])
                    minElementIndex = j;
            int temp = arr[i];
            arr[i] = arr[minElementIndex];
            arr[minElementIndex] = temp;

        }
        return arr;
    }
}
