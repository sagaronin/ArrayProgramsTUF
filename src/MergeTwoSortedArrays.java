import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int arr1[] = {1,3,5,7};
        int arr2[] = {0,2,6,8,9};
        MergeTwoSortedArrays.mergeTwoSortedArraysBruteForce(arr1, arr2);
    }

    public static void mergeTwoSortedArraysBruteForce(int[] arr1, int arr2[]) {
        int n = arr1.length, m = arr2.length;
        int ans[] = new int[n + m];
        int left = 0, right = 0, index = 0;

        while (left < n && right < m) {
            if (arr1[left] <= arr2[right])
                ans[index++] = arr1[left++];
            else
                ans[index++] = arr2[right++];

        }
        // copy remaining from left
        while (left < n) {
            ans[index++] = arr1[left++];
        }
        // copy remaining from right
        while (right < m) {
            ans[index++] = arr2[right++];
        }

        for (int i = 0; i < n + m; i++) {
            if (i < n)
                arr1[i] = ans[i];
            else
                arr2[i - n] = ans[i];
        }
        System.out.println("Array 1: "+Arrays.toString(arr1));
        System.out.println("Array 2: "+Arrays.toString(arr2));
    }

}
