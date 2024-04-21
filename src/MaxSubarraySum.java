public class MaxSubarraySum {
    public static void main(String[] args) {
        int arr[]={-2,-3,4,-1,-2,1,5,-3};
        MaxSubarraySum.maxSubarraySumBrute(arr);
        MaxSubarraySum.maxSubarraySumOptimal(arr);
    }
    public static void maxSubarraySumBrute(int arr[]) {
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum=0;
            for (int j = i; j < arr.length; j++) {
                sum+=arr[j];
                if(max<sum)
                    max=sum;
            }
        }
        System.out.println("Max sum is "+max);
    }

    //Also known as Kadanes algorithm
    public static void maxSubarraySumOptimal(int arr[]) {
        int sum=0, start=0;
        int maxStart=-1, maxEnd=-1;
        int max= Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(sum==0)
                start=i;
            sum += arr[i];
            if(sum<0)
                sum=0;
            if(sum>max){
                max=sum;
                maxStart= start;
                maxEnd=i;
            }
        }
        System.out.println("Max sum is "+max);
        System.out.print("Array elements are : {");
        for (int i = maxStart; i <= maxEnd; i++) {
            System.out.print(arr[i]+",");
        }
        System.out.print("}");
    }
    
}
