public class FindMissing {
    public static void main(String[] args) {
        int arr[]={2,3,4,5};
        int n=5;
        //System.out.println("Missing number(Brute) : "+FindMissing.findMissingBrute(arr, n));
        //System.out.println("Missing number(Better) : "+FindMissing.findMissingBetter(arr, n));
        System.out.println("Missing number(Better) : "+FindMissing.findMissingOptimal(arr, n));
    }

    public static int findMissingBrute(int arr[], int n) {
        for (int i = 1; i <=n; i++) {
            int flag=0;
            for (int j = 0; j < arr.length; j++) {
                if(arr[j]==i){
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                return i;
            }
        }
        return -1;
    }
    public static int findMissingBetter(int arr[], int n) {
        int hash[] = new int[n+1];
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }
        for (int i = 1; i < hash.length; i++) {
            if(hash[i]==0){
                return i;
            }
        }
        return -1;
    }
    public static int findMissingOptimal(int arr[], int n) {
        int sum=n*((n+1)/2);
        int add=0;
        for (int i = 0; i < arr.length; i++) {
            add+=arr[i];
        }
        return sum-add;
        
    }
    
}
