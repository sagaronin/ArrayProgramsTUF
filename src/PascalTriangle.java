public class PascalTriangle {
    //      1
    //     1 1
    //    1 2 1
    //   1 3 3 1
    //  1 4 6 4 1

    //we have to use nCr formula to compute the tuples of triangle
    
    public static void main(String[] args) {
        //Find the element on given row and column
        //System.out.println(PascalTriangle.pascalTriangle(4, 2));
        PascalTriangle.printPascalTrianngleRow(5);

    }
    public static int pascalTriangle(int row, int column) {
        //given row and column number find the exact element
        //use nCr formula to find the element
        int answer=1;
        for (int i = 1; i < column; i++) {
           answer *= (row-i);
           answer /= (i); 
        }
        return answer;
    }
    public static void printPascalTrianngleRow(int row){
        int ans=1;
        System.out.print("1 ");
        for (int i = 1; i < row; i++) {
            //using above formula to get each element
            //System.out.print(pascalTriangle(row, i)+" ");   
            ans=ans*(row-i);
            ans=ans/i;
            System.out.print(ans+" ");         
        }
    }
}
