public class LinearSearch {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6};
        int n= LinearSearch.linearSearch(arr, 6);
        if(n==-1){
            System.out.println("Element does not exist");
        }else{
            System.out.println("Element exists at "+n+" index: "+arr[n]);
        }
    }

    public static int linearSearch(int[] args, int searchTuple) {
        for (int i =0;i<args.length;i++) {
            if(args[i]==searchTuple){
                return i;
            }
        }
        return -1;
    }
}
