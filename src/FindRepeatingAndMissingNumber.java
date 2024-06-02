
import java.util.LinkedList;
import java.util.List;

public class FindRepeatingAndMissingNumber {
    public static void main(String[] args) {
        int arr[] = { 4, 3, 6, 2, 1, 1 };
        System.out.println("Repeating(x) and Missing(y) Number is [x,y]: "+FindRepeatingAndMissingNumber.findRepeatingAndMissingNumber(arr));
    }

    public static List<Integer> findRepeatingAndMissingNumber(int[] arr) {
        List<Integer> ans = new LinkedList<>();
        int n = arr.length;
        long SN = (n * (n + 1)) / 2; // sum of n natural numbers
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6; // sum of squares of n natural numbers
        long S = 0, S2 = 0;
        for (int i = 0; i < arr.length; i++) {
            S += arr[i];
            S2 += arr[i] * arr[i];
        }
        long val1 = S - SN;// x-y
        long val2 = S2 - S2N;// x^2-y^2 = (x+y)*(x-y)
        val2 = val2 / val1;// x+y
        long x = (val1 + val2) / 2;
        long y = x - val1;
        ans.add((int)x);
        ans.add((int)y);
        return ans;
    }
}
