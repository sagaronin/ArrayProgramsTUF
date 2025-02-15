import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int arr[]={2,2,3,3,1,2,2};
        //System.out.println("Majority element occurence(Brute Force) : "+MajorityElement.majorityElementBrute(arr));
        //System.out.println("Majority element occurence(Better) : "+MajorityElement.majorityElementBetter(arr));
        System.out.println("Majority element(Optimal) : "+MajorityElement.majorityElementOptimal(arr));
    }
    public static int majorityElementBrute(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int count=0;
            for (int j = 0; j < arr.length; j++) {
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            if(count >= arr.length/2)
                return count;          
        }
        return -1;
    }

    public static int majorityElementBetter(int arr[]) {
        Map<Integer, Integer> map= new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i])+1);
            else
                map.put(arr[i], 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > (arr.length/2))
                return entry.getValue();
        }
        return -1;
    }

    public static int majorityElementOptimal(int arr[]) {
        int count=1, element=arr[0];
        //This is also known as moores voting algorithm
        for (int i = 1; i < arr.length; i++) {
            if(count==0){
                element = arr[i];
                System.out.println("Element now - "+element);
            }
            if(element==arr[i]){
                count++;
            }else{
                count--;
            }
        }
        count=0;
        for (int i = 0; i < arr.length; i++) {
            if(element==arr[i])
                count++;
        }
        if(count>arr.length/2){
            return element;
        }        
        return -1;
    }
}
