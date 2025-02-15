import java.util.Arrays;
import java.util.PriorityQueue;

public class FindKthLargest {
    //Was asked in ServiceNow - Oct 2024

    public static void main(String[] args) {
        int nums[] = { 7, 1, 5, 3, 6, 4 };
        //FindKthLargest.findKthLargest(nums,2);
        //System.out.println("Brute: "+FindKthLargest.brute(nums,4));
        System.out.println("Optimal: "+FindKthLargest.findKthLargest(nums,2));
    }
    public static int findKthLargest(int[] nums, int k) {
        //Priority queue maintains natural sorting order
        // in this case of integers it maintains ASCENDING insertion order
        PriorityQueue<Integer> pq= new PriorityQueue<Integer>();
        for(int i=0; i<nums.length;i++){
            pq.add(nums[i]);
            System.out.println("After adding: "+pq);
            if(pq.size()>k){
                System.out.println("Before Removing: "+pq);
                pq.poll();
                System.out.println("After Removing: "+pq);
            }
        }
        return pq.poll();
    }

    public static int brute(int[] nums, int k){
        for(int i=0; i<nums.length;i++){
            for(int j=i+1; j<nums.length;j++){
                if(nums[i]<nums[j]){
                    int temp= nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums[k-1];
    }
}
