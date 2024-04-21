
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int arr[] = { 0, 1, 1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9, 10, 10 };
        System.out.println("Original Array - "+Arrays.toString(arr));
        int n=0;
        // brute force
        /* 
        n = RemoveDuplicatesFromSortedArray.removeDuplicateBruteForce(arr);
        System.out.print("Unique elements array - {");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.print("}");
        */
        // optimal solution
        n=removeDuplicateOptimal(arr);
        System.out.print("Unique elements array - {");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.print("}");
        

    }

    public static int removeDuplicateBruteForce(int arr[]){
        Set<Integer> uniqueElement= new TreeSet<Integer>();
        //time complexity for below loop and adding element in set is (N log N)
        for (int elements : arr) {
            uniqueElement.add(elements);
        }
        int index=0;
        //time complexity for below code is (N)
        for (Integer integer : uniqueElement) {
            arr[index]=integer;
            index++;
        }
        return index;
    }

    public static int removeDuplicateOptimal(int[] arr) {
        int j=0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[j]<arr[i]){
                // this is logic changes the actual array elements
                //j++;
                //arr[j]=arr[i];

                //This logic keeps the array elements same with swapping logic
                j++;
                arr[j] = arr[j]+arr[i];
                arr[i] = arr[j]-arr[i];
                arr[j] = arr[j]-arr[i];
            }
        }
        System.out.println("modified array - "+Arrays.toString(arr));
        return j;
    }

}
