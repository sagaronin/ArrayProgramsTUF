class Largest{
    public static void main(String[] args) {
        int elements[]={1,2,40,6,10,5,9,40};
        
        System.out.println("Largest - "+Largest.LargestNum(elements));
        System.out.println("Second Largest - "+Largest.secondLargest(elements));

    }

    public static int LargestNum(int elements[]){
        int maxNum=0;
        for (int i : elements) {
            if(i>maxNum){
                maxNum=i;
            }
        }
       
        return maxNum;
    }

    public static int secondLargest(int elements[]){
        int maxNum2=-1, maxNum=elements[0];
        for (int i=1; i<elements.length;i++) {
            if(elements[i]>maxNum){
                maxNum2=maxNum;
                maxNum=elements[i];
            }else if(elements[i]<maxNum && elements[i]>maxNum2){
                maxNum2=elements[i];
            }
        }
        return maxNum2;
    }
}