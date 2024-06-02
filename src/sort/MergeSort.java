package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        // in merge sort you break down big array in small equal size chunk and try to
        // sort the small chunks. 
        //After those are solved you merge them together to ultimately
        // reach to sorted array
        int arr[] = { 2, 5, 9, 3, 7, 4, 11, 19 };
        MergeSort.mergeSort(arr, arr.length);
        System.out.println("Merge Sort: " + Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int numberOfElements) {
        if (numberOfElements < 2)
            return;
        // find the mid and create left and right partition
        int mid = numberOfElements / 2;
        int leftArr[] = new int[mid];
        int rightArr[] = new int[numberOfElements - mid];

        // fill up left partition
        for (int i = 0; i < mid; i++) {
            leftArr[i] = arr[i];
        }

        // fill up right partition
        for (int i = mid; i < numberOfElements; i++) {
            rightArr[i - mid] = arr[i];
        }

        // apply merge sort on left partition
        mergeSort(leftArr, mid);
        // apply merge sort on right partition
        mergeSort(rightArr, numberOfElements - mid);

        // merge both partitions
        merge(arr, leftArr, rightArr, mid, numberOfElements - mid);
    }

    private static void merge(int[] arr, int[] leftArr, int[] rightArr, int left, int right) {
        int i = 0, j = 0, k = 0;

        // Merge arrays based on the smaller values
        while (i < left && j < right) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        // Fill out remaining values if any
        while (i < left) {
            arr[k++] = leftArr[i++];
        }
        while (j < right) {
            arr[k++] = rightArr[j++];
        }
    }
}
