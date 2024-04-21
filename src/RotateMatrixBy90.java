import java.util.Arrays;

public class RotateMatrixBy90 {
    public static void main(String[] args) {
        int arr[][]={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        //RotateMatrixBy90.rotateMatrixBy90Brute(arr);
        RotateMatrixBy90.rotateMatrixBy90Optimal(arr);
    }
    public static void rotateMatrixBy90Brute(int[][] arr) {
        int temp[][] = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                temp[j][(arr.length-1)-i]=arr[i][j];
            }
        }
        System.out.println("Rotate by 90 Degrees(Brute) : "+Arrays.deepToString(arr));
    }

    public static void rotateMatrixBy90Optimal(int[][] arr) {
        //Transpose and reverse strategy
        
        //Transpose
        //rows will traverse from i=0 to i=n-2
        //column will traverse from j=i+1 to j<n-1
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                arr[i][j]=arr[i][j]+arr[j][i];
                arr[j][i]=arr[i][j]-arr[j][i];
                arr[i][j]=arr[i][j]-arr[j][i];
            }
        }
        System.out.println("transpose. : "+Arrays.deepToString(arr));
        for (int i = 0; i < arr.length; i++) {
            reverse(arr[i]);
        }
        System.out.println("Rotate by 90 Degrees(Optimal) : "+Arrays.deepToString(arr));

    }

    public static void reverse(int[] a) {
        int n= a.length;
        for (int i = 0; i < n / 2; i++) { 
            a[i] = a[i]+a[n - i - 1]; 
            a[n - i - 1] = a[i]-a[n - i - 1];
            a[i] = a[i]-a[n - i - 1];
        } 
        
    }
}
