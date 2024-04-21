import java.util.ArrayList;
import java.util.List;

public class LeadersInArray {
    public static void main(String[] args) {
        int arr[]={10,22,12,3,0,6};
        LeadersInArray.findLeadersBrute(arr);
    }
    public static void findLeadersBrute(int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(arr[arr.length-1]);
        for (int i = arr.length-2; i >=0; i--) {
            boolean flag=true;
            for (int j = arr.length-1; j >i; j--) {
                if(arr[i]<arr[j]){
                    flag=false;
                    break;
                }                                
            }
            if(flag){
                list.add(arr[i]);
            }
        }
        System.out.println("Leaders(Brute Force) : "+list);
        
    }
    public static void findLeadersoptimal(int[] arr) {
        int max= Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = arr.length-1; i >=0 ; i++) {
            if(arr[i]>max){
                max=arr[i];
                list.add(max);
            }
        }
        System.out.println("Leaders(Optimal) : "+list);
    }
}
