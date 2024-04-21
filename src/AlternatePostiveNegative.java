import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlternatePostiveNegative {
    public static void main(String[] args) {
        int arr[]={1,-2,-4,2,7,-1};
        //AlternatePostiveNegative.alternatePostiveNegativeBrute(arr);
        AlternatePostiveNegative.alternatePostiveNegativeOptimal(arr);
    }
    public static void alternatePostiveNegativeBrute(int arr[]) {
        List<Integer> positive= new ArrayList<Integer>();
        List<Integer> negative= new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<0)
                negative.add(arr[i]);
            else
                positive.add(arr[i]);
        }
        // in place substitution with more variables
        // int p=0,n=0;
        // for (int i = 0; i < arr.length; i++) {
        //     if(i%2==0){
        //         arr[i]=positive.get(p);
        //         p++;
        //     }else{
        //         arr[i]=negative.get(n);
        //         n++;
        //     }
        // }

        //in place substitution with less variable
        for (int i = 0; i < arr.length/2; i++) {
            arr[i*2] = positive.get(i);
            arr[(i*2)+1] = negative.get(i);
        }
        System.out.println("Alternate positive negative(Brute Force) : "+Arrays.toString(arr));
        
    }

    public static void alternatePostiveNegativeOptimal(int arr[]) {
        int alternate[]= new int[arr.length];
        int p=0, n=1;
        for (int i = 0; i < alternate.length; i++) {
            if(arr[i]<0){
                alternate[n]=arr[i]; 
                n=n+2;   
            }else{
                alternate[p]=arr[i];
                p=p+2;
            }            
        }
        arr=alternate;
        System.out.println("Alternate positive negative(Optimal) : "+Arrays.toString(arr));
    }
}
