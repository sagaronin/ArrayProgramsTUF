public class StocksMaxProfit {
    public static void main(String[] args) {
        int stockPrice[] = { 7, 1, 5, 3, 6, 4 };
        StocksMaxProfit.maxProfit(stockPrice);
    }

    public static void maxProfit(int[] a) {
        int profit = 0, min = a[0];
        for (int i = 1; i < a.length; i++) {
            // cost to buy share
            // you have to buy share before selling it
            // hence assume the cost to buy is
            // current value minus the min value of share bought in past
            int cost = a[i] - min;
            // if this cost is greater than profit, change profit to that value
            if (profit < cost) {
                profit = cost;
            }
            // if a[i] is less than min, then change value of min to a[i]
            if (a[i] < min) {
                min = a[i];
            }
        }
        System.out.println("Profit: " + profit);
    }

    public int maxProfit2(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy)
                buy = prices[i];
            else if (prices[i] - buy > profit)
                profit = prices[i] - buy;
        }
        return profit;

    }

}
