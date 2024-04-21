import java.util.HashMap;
import java.util.Map;

public class FindNumberAppearOnceAndOthersTwice {
    public static void main(String[] args) {
        int arr[]={1,1,2,3,3,4,4,2,6};
        //System.out.println("Number appearing once and others twice is(Brute Force) : "+FindNumberAppearOnceAndOthersTwice.findNumberAppearOnceAndOthersTwiceBrute(arr));
        //System.out.println("Number appearing once and others twice is(Better) : "+FindNumberAppearOnceAndOthersTwice.findNumberAppearOnceAndOthersTwiceBetter(arr));
        System.out.println("Number appearing once and others twice is(Optimal) : "+FindNumberAppearOnceAndOthersTwice.findNumberAppearOnceAndOthersTwiceOptimal(arr));
    }
    public static int findNumberAppearOnceAndOthersTwiceBrute(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];
            int count=0;
            for (int j = 0; j < arr.length; j++) {
                if(arr[j]==number){
                    count++;
                }
            }
            System.out.println("Count for "+number+" is : "+count);
            if(count==1)
                return number;
        }
        return -1;
    }
    public static int findNumberAppearOnceAndOthersTwiceBetter(int[] arr) {
        int max=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max)
                max=arr[i];            
        }
        int hash[]= new int[max+1];
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }
        for (int i = 0; i < hash.length; i++) {
            if(hash[i]==1)
                return i;
        }
        return -1;
    }
    public static int findNumberAppearOnceAndOthersTwiceOptimal(int[] arr) {
        Map<Integer, Integer> map= new HashMap<Integer,Integer>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i])+1);
            else
                map.put(arr[i], 1);        
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet())  
            System.out.println("Key = " + entry.getKey() + 
                         ", Value = " + entry.getValue()); 
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()==1)
                return entry.getKey();
        }
        return -1;

        
    }

}
