import java.util.Arrays;

public class LeftRotate {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};
        //LeftRotate.leftRotateByOneOptimal(arr);
        LeftRotate.leftRotateByKPlacesBruteForce(arr, 2);
        //LeftRotate.leftRotateByKPlacesBetter(arr, 3);
    }

    public static void leftRotateByOneOptimal(int arr[]) {
        int temp= arr[0];
        for (int i = 0; i < arr.length-1; i++) {
            arr[i]=arr[i+1];
        }
        arr[arr.length-1]= temp;
        System.out.println("Brute force - "+Arrays.toString(arr));
    }

    public static void leftRotateByKPlacesBruteForce(int arr[], int k) {
        //store first "k" elements in temp array
        k = k % arr.length;
        int temp[]= new int[k];
        for (int i = 0; i < k; i++) {
            temp[i]=arr[i];
        }
        //shift the elements starting from 'k'th position
        for (int i =k; i < arr.length; i++) {
            arr[i-k] =arr[i];
        }
        //put the first "k" elements back in original array
        for (int i = arr.length-k; i < arr.length; i++) {
            arr[i]=temp[i-(arr.length-k)];
        }
        System.out.println("Brute force Left Rotate by K palces - "+Arrays.toString(arr));
    }

    public static void leftRotateByKPlacesBetter(int arr[], int k) {
        reverse(arr, 0, k-1);
        System.out.println("first k elements rotation - "+Arrays.toString(arr));
        reverse(arr, k, arr.length-1);
        System.out.println("remaining n-k elements rotation - "+Arrays.toString(arr));
        reverse(arr, 0, arr.length-1);
        System.out.println("Optimal solution - "+Arrays.toString(arr));
    }
    public static void reverse(int arr[], int start, int end){
        while(start<=end) {
            int temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
      
        
    
}
