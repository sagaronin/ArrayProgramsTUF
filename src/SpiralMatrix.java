import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int arr[][]={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        SpiralMatrix.printMatrixInSpiral(arr);
    }

    public static void printMatrixInSpiral(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;
        List<Integer> list = new ArrayList<Integer>();
        while (left <= right && top <= bottom) {
            // print left-right
            for (int i = left; i <= right; i++) {
                list.add(arr[top][i]);
            }
            top++;

            // print top to bottom
            for (int i = top; i <= bottom; i++) {
                list.add(arr[i][right]);
            }
            right--;

            // print right to left
            if(top<=bottom){
                for (int i = right; i >= left; i--) {
                    list.add(arr[bottom][i]);
                }
                bottom--;
            }

            // print bottom to top
            if(left<=right){
                for (int i = bottom; i >= top; i--) {
                    list.add(arr[i][left]);
                }
                left++;
            }
        }
        System.out.println("Spiral Matrix: "+list.toString());
    }

}
