//Suppose we could access yesterday's stock prices as an array, where:
//
//The indices are the time in minutes past trade opening time, which was 9:30am local time.
//The values are the price in dollars of Apple stock at that time.
//So if the stock cost $500 at 10:30am, stockPricesYesterday[60] = 500.
//
//Write an efficient method that takes stockPricesYesterday and returns the best profit I could have made from 1 purchase and 1 sale of 1 Apple stock yesterday.
//
// Efficiency : O(n)

public class AppleStock {

    public static void main(String args[]){

        int[] stock_prices_yesterday = {9,8,7,6,5,4,3};


        int max_profit = get_max_profit(stock_prices_yesterday);

        if (max_profit == -1)
            System.out.println("No such value");
        else
            System.out.println("Max profit: " + max_profit);
    }

    private static int get_max_profit(int[] arr) {
        int max_profit = -1;
        int min_pos = 0;

        for (int i = 1; i < arr.length; i++){
            if (arr[i] < arr[min_pos]) {
                min_pos = i;
                continue;
            }
            if (arr[i] - arr[min_pos] > max_profit){
                max_profit = arr[i] - arr[min_pos];
            }
        }

        return max_profit;
    }

}

