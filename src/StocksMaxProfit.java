public class StocksMaxProfit {
    public static void main(String[] args) {
        int stockPrice[]={7,1,5,3,6,4};
        StocksMaxProfit.maxProfit(stockPrice);
    }
    public static void maxProfit(int[] a) {
        int profit=0, min=a[0];
        for (int i = 1; i < a.length; i++) {
            //cost to buy share
            int cost= a[i] - min;
            //if this cost is greater than profit, change profit to that value
            if(profit < cost){
                profit= cost;
            }
            //if a[i] is less than min, thennnn change value of min to a[i]
            if(a[i]<min){
                min= a[i];
            }
        }
        System.out.println("Profit: "+profit);
    }
    
}
