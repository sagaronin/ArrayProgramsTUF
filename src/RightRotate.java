import java.util.Arrays;
public class RightRotate {
    

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};
        //RightRotate.rightRotateByOneOptimal(arr);
        //RightRotate.rightRotateByKPlacesBruteForce(arr, 2);
        RightRotate.rightRotateByKPlacesBetter(arr, 3);
    }

    public static void rightRotateByOneOptimal(int arr[]) {
        int temp= arr[arr.length-1];
        for (int i = arr.length-1; i > 0 ; i--) {
            arr[i]=arr[i-1];
        }
        arr[0]= temp;
        System.out.println("Brute force - "+Arrays.toString(arr));
    }

    public static void rightRotateByKPlacesBruteForce(int arr[], int k) {
        // Take the mod value because no matter the original value of k, we will have to rotate by mod value of it.
        k = k % arr.length;
        //store first "k" elements in temp array
        int temp[]= new int[k];
        for (int i = 0; i <k; i++) {
            temp[i]=arr[arr.length-k+i];
        }
        System.out.println("temp - "+Arrays.toString(temp));
        System.out.println("arr - "+Arrays.toString(arr));
        //shift the elemnts starting from last to 'k'th position(backwards)
        for (int i = arr.length-1; i >= k; i--) {
            arr[i] = arr[i-k];
        }
        //put the last "k" elements back in original array
        for (int i = 0; i < k; i++) {
            arr[i]=temp[i];
        }
        System.out.println("Brute force Left Rotate by K palces - "+Arrays.toString(arr));
    }

    public static void rightRotateByKPlacesBetter(int arr[], int k) {
        // Take the mod value because no matter the original value of k, we will have to rotate by mod value of it.
        k = k % arr.length;
        reverse(arr, arr.length-k, arr.length-1); // k to n
        System.out.println("n-k elements rotation - "+Arrays.toString(arr));
        reverse(arr, 0, arr.length-k-1); // 0 to k
        System.out.println("first k elements rotation - "+Arrays.toString(arr));
        reverse(arr, 0, arr.length-1);// 0 to n
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
