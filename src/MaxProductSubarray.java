

public class MaxProductSubarray {
    public static void main(String[] args) {
        int arr[]={2,3,-2,4};
        System.out.println("Max product subarray: "+MaxProductSubarray.maxProductSubarray(arr));
    }

    public static int maxProductSubarray(int[] arr) {
        int max=1, prefix=1, suffix=1;
        for (int i = 0; i < arr.length; i++) {
            if(prefix==0) prefix=1;
            if(suffix==0) suffix=1;
            prefix = prefix*arr[i];
            suffix = suffix*arr[arr.length-i-1];
            max = Math.max(max, Math.max(prefix, suffix));
        }
        return max;
    }
}
