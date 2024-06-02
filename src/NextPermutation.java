import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {
    public static void main(String[] args) {
        Integer elements[]={2,1,5,4,3,0,0};
        
        System.out.println("Next Permutation - "+Arrays.toString(NextPermutation.nextPermutation(elements)));

    }
    public static Integer[] nextPermutation(Integer[] elements) {
        //find the first element which is smaller element starting from last elements
        int index=-1;
        for(int i = elements.length-2;i>=0;i--){
            if(elements[i]<elements[i+1]){
                index = i;
                System.out.println("break at: "+elements[i]);
                break;
            }
        }
        if(index==-1){
            //reverse the original array as that was the last permutation in its series
            // which is apparently the largest number
            Collections.reverse(Arrays.asList(elements)); 
            return elements;  
        }
        // if the index!=-1 means there is next permutation available.
        // so in order to find the next permutation in this series
        // find the smallest number which is greater than element at index, 
        // starting from index to the length of array(index->n)
        //Integer elements[]={2,1,5,4,3,0,0};
        int j=index+1;
        int min = Integer.MAX_VALUE, minIndex=-1;
        while(j<elements.length){
            if(elements[j]>elements[index]){
                if(min>elements[j]){
                    min=elements[j];
                    minIndex=j;
                }
            }
            j++;
        }
        System.out.println("Min: "+min);
        //swap the elements at minIndex and index location
        int temp = elements[minIndex];
        elements[minIndex] = elements[index];
        elements[index] = temp;
        System.out.println("After swap - "+Arrays.toString(elements));

        // now reverse the elements starting from index to array length in ASC order.
        int length = elements.length-index;
        for (int i = 0; i < length / 2; i++)
        {
            int tempswap = elements[index+1]; 
            elements[index+1] = elements[elements.length - 1 -(i)]; 
            elements[elements.length - 1 - (i)] = tempswap;    
            index++;         
        }
        return elements;

    }
}
