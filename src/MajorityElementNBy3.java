import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MajorityElementNBy3 {
    public static void main(String[] args) {
        int arr[] = { 3, 2, 3, 3, 1, 2, 2 };
        System.out.println("Majority element N/3 (Optimal) : " + MajorityElementNBy3.majorityElementOptimal(arr));
    }

    private static List<Integer> majorityElementOptimal(int[] arr) {
        List<Integer> ans = new LinkedList<>();
        int count1 = 0, count2 = 0, el1 = -1, el2 = -1;
        for (int i = 0; i < arr.length; i++) {
            if (count1 == 0 && arr[i] != el2) {
                count1 = 1;
                el1 = arr[i];
            } else if (count2 == 0 && arr[i] != el1) {
                count2 = 1;
                el2 = arr[i];
            } else if (el1 == arr[i]) {
                count1++;
            } else if (el2 == arr[i]) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == el1) {
                count1++;
            } else if (arr[i] == el2) {
                count2++;
            }
        }
        if (count1 > arr.length / 3)
            ans.add(el1);
        if (count2 > arr.length / 3)
            ans.add(el2);

        Collections.sort(ans);
        return ans;
    }
}
