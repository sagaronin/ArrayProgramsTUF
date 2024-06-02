package sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        //in bubble sort you check individual elements with its neighbor.
        // you verify if its larger than its neighbor
        // if yes then swap it with that element.
        // at end of every iteration you will have largest element towards end of array
        int arr[] = { 2, 5, 9, 3, 7, 4, 11, 19 };
        System.out.println("Bubble Sort: " + Arrays.toString(BubbleSort.bubbleSort(arr)));
    }

    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if(arr[j] > arr[j+1]){
                    //swap them
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]= temp;
                }
            }
        }
        return arr;
    }
}
