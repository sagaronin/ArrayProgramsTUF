class Smallest{
    public static void main(String[] args) {
        int elements[]={11,22,40,6,10,5,9,40,4};
        
        System.out.println("Smallest - "+Smallest.SmallestNum(elements));
        System.out.println("Second Smallest - "+Smallest.secondSmallest(elements));

    }

    public static int SmallestNum(int elements[]){
        int smallest=elements[0];
        for (int i : elements) {
            if(i<smallest){
                smallest=i;
            }
        }
        return smallest;
    }

    public static int secondSmallest(int elements[]){
        int ssmallest=Integer.MAX_VALUE, smallest=elements[0];
        for (int i=1; i<elements.length;i++) {
            if(elements[i]<smallest){
                ssmallest=smallest;
                smallest=elements[i];
            }else if(elements[i]!=smallest && elements[i]<ssmallest){
                ssmallest=elements[i];
            }
        }
        return ssmallest;
    }
}