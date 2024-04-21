import java.util.Arrays;

public class SortArrayOfZeroOneTwos {
    public static void main(String[] args) {
        int arr[]={0,1,1,0,1,2,1,2,0,0,0};
        //SortArrayOfZeroOneTwos.sortBrute(arr);
        SortArrayOfZeroOneTwos.sortOptimal(arr);

    }
    public static void sortBrute(int[] arr) {
        int oneCount=0,twoCount=0,zeroCount=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==0)
                zeroCount++;
            else if(arr[i]==1)
                oneCount++;
            else if(arr[i]==2)
                twoCount++;
        }
        for (int i = 0; i < zeroCount; i++) {
            arr[i]=0;
        }
        for (int i = zeroCount; i < zeroCount+oneCount; i++) {
            arr[i]=1;
        }
        for (int i = zeroCount+oneCount; i < zeroCount+oneCount+twoCount; i++) {
            arr[i]=2;
        }
        System.out.println("Sorted array(Brute Force) : "+Arrays.toString(arr));
    }

    //Also known as Dutch national Flag Algorithm
    public static void sortOptimal(int[] arr) {
        int low=0, mid=0, high=arr.length-1;
        while(mid<=high) {
            if(arr[mid]==0){
                int temp= arr[low];
                arr[low]= arr[mid];
                arr[mid]= temp;
                low++;
                mid++;                
            }
            else if(arr[mid]==1){
                mid++;                
            }
            else{
                int temp= arr[mid];
                arr[mid]= arr[high];
                arr[high]=temp;
                high--;
            }            
        }
        System.out.println("Sorted array(Optimal) : "+Arrays.toString(arr));
        
    }
    
}
