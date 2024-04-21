public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int arr[]={1,1,0,0,1,1,1,1,0,1};
        int number=1;
        System.out.println("Max Consecutive number(optimal) : "+MaxConsecutiveOnes.maxConsecutiveOnesOptimal(arr, number));

    }
    public static int maxConsecutiveOnesOptimal(int[] arr, int number) {
        int maxCounnt=0,count=0;
        if(arr.length==0){
            return 0;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==number)
                count++;
            else
                count=0;
            if(maxCounnt<count)
                maxCounnt=count;
        }
        return maxCounnt;
    }
    
}
