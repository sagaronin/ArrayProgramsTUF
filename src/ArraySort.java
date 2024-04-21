public class ArraySort {
    public static void main(String[] args) {
        int arr[]={0,1,2,2,3,3,5,5,6,7,8,9};
        System.out.println("Is array sorted? "+ArraySort.checkIfArrayIsSorted(arr));


    }

    public static boolean checkIfArrayIsSorted(int arr[]){
        for (int i = 0; i < arr.length-1; i++) {
            if(!(arr[i]<=arr[i+1])){
                return false;
            }
        }
        return true;
    }
    
}
