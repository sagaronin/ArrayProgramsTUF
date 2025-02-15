import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    //      1
    //     1 1
    //    1 2 1
    //   1 3 3 1
    //  1 4 6 4 1

    //we have to use nCr formula to compute the tuples of triangle
    
    public static void main(String[] args) {
        //Find the element on given row and column
        //System.out.println(PascalTriangle.pascalTriangleElement(6, 4));
        //PascalTriangle.printPascalTrianngleRow(6);
        PascalTriangle.printPascalTrianngleFull(6);

    }
    public static int pascalTriangleElement(int row, int column) {
        //given row and column number find the exact element
        //use nCr formula to find the element
        //e.g. row=6, column=4
        // so in zero based indexing we can use below formula
        //(row-1)C(column-1) = 5C3
        //5C3 = (5!)/(3!*(2!))
        // expand and resolve
        //5C3 = (5*4*3*(2!))/(3!*(2!))
        // cancel 2! from Ner and Der
        //5C3 = (5*4*3)/(3*2*1)
        // i.e. whatever is the r! value, decrease the Numerator value that many times(here 3 times(5*4*3))
        
        int answer=1;
        for (int i = 1; i < column; i++) {
           answer *= (row-i);
           answer /= (i); 
        }
        return answer;
    }
    public static void printPascalTrianngleRow(int row){
        //use nCr formula to find the element
        //refer above formula explaination to understand nCr formula
        //Now lets userstand how to generate row value effectively
        // using above formula for 6C2, 6C3 and 6C4
        //6C2 = 5/1 , 6C3 = (5/1)*(4/2), 6C4 = (5/1)*(4/2)*(3/3)
        // if you observe above pattern you can see next element is previous element answer plus new value.
        // we will use this trick to come to answer
        // NOte: if r!=3!, dont start adding the denominator like 3*2*1. Always add 1*2*3.

        int ans=1;
        System.out.print("1 ");
        for (int i = 1; i < row; i++) {   
            ans=ans*(row-i);
            ans=ans/i;
            System.out.print(ans+" ");         
        }
    }

    public static List<List<Integer>> printPascalTrianngleFull(int n){
        List<List<Integer>> ans=new ArrayList<>();
        if(n==0)
            return ans;
        List<Integer> frow= new ArrayList<>();
        frow.add(1);
        ans.add(frow);

        if(n==1)
            return ans;
        //Since we already added first row element, start from index 1
        for (int i = 1; i < n; i++) { 
            //Get previous row
            List<Integer> prev = ans.get(i-1);
            //create current row
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);
            for(int j=0;j<i-1;j++){
                curRow.add(prev.get(j)+prev.get(j+1));
            }
            curRow.add(1);
            ans.add(curRow);
        }
        System.out.println("Answer:" +ans);
        ans.forEach(list->
            list.forEach(item->System.out.print(item)));
        return ans;
    }
}
