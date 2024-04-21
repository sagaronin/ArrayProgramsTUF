import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int arr[] = { 2, 6, 5, 8, 11 };
        int targetSum = 14;
        // System.out.println("Two Sum(Brute Force) :
        // "+Arrays.toString(TwoSum.twoSumBrute(arr, targetSum)));
        //System.out.println("Two Sum(Better) : " + Arrays.toString(TwoSum.twoSumBetter(arr, targetSum)));
        System.out.println("Two Sum(Optimal) : "+TwoSum.twoSumOptimal(arr, targetSum));
    }

    public static int[] twoSumBrute(int[] arr, int targetSum) {
        int indices[] = new int[2];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == targetSum) {
                    indices[0] = i;
                    indices[1] = j;
                    return indices;
                }
            }
        }
        return indices;
    }

    public static int[] twoSumBetter(int[] arr, int targetSum) {
        int indices[] = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            int difference = targetSum - arr[i];
            if (map.containsKey(difference)) {
                indices[0] = map.get(difference);
                indices[1] = i;
                return indices;
            } else {
                map.put(arr[i], i);
                System.out.println("Inserted: " + map);
            }

        }
        return indices;
    }

    // This is optimal for returning whether array contais elements whose sum is
    // equal to target sum
    public static boolean twoSumOptimal(int[] arr, int targetSum) {
        Arrays.sort(arr);
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int sum = arr[i] + arr[j];
            if ( sum == targetSum) {
                System.out.println("First Element : "+arr[i]);
                System.out.println("Second Element : "+arr[j]);
                return true;
            } else if (sum < targetSum) {
                i++;
            }else if(sum > targetSum){
                j--;
            }

        }
        return false;
    }

}
