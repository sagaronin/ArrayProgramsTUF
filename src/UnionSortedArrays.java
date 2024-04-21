import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UnionSortedArrays {
    public static void main(String[] args) {
        int arr1[]={1,2,2,4,5,6,6,7};
        int arr2[]={4,5,6,7,8,9};
        //UnionSortedArrays.unionBruteForce(arr1, arr2);
        UnionSortedArrays.unionOptimal(arr1, arr2);

    }
    public static void unionBruteForce(int[] arr1, int arr2[]) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        Object union[]=set.toArray();
        System.out.println("union : "+Arrays.toString(union));
    }

    public static List<Integer> unionOptimal(int[] arr1, int arr2[]) {
        int i=0,j=0;
        int n1= arr1.length;
        int n2= arr2.length;
        List<Integer> list = new ArrayList<Integer>();
        while(i<n1 && j<n2){
            // case 1 - arr1[i] < arr2[j]
            // case 2 - arr1[i] == arr2[j]
            // case 3 - arr1[i] > arr2[j]
            if(arr1[i]<=arr2[j]){ // case 1 and case 2
                if(list.size()==0 || list.get(list.size()-1)!=arr1[i])
                    list.add(arr1[i]);
                i++;
                
            }else //case 3 - arr1[i] > arr2[j]
            {
                if(list.size()==0 || list.get(list.size()-1)!=arr2[j])
                    list.add(arr2[j]);
                j++;
                
            }
        }
        while(i<n1){
            if(list.size()==0 || list.get(list.size()-1)!=arr1[i])
                list.add(arr1[i]);
            i++;
            
        }
        while(j<n2){
            if(list.size()==0 || list.get(list.size()-1)!=arr2[j])
                list.add(arr2[j]);
            j++;
            
        }
        System.out.println("Union optimal : "+list);
        return list;
    }
    
}
