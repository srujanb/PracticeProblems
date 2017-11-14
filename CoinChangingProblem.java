import java.util.Arrays;

public class CoinChangingProblem {

    public static void main(String args[]){

        int amount = 8;

        int[] denominations = {1,2,5};

        int ways = getTotalWays(denominations,amount);

        System.out.println("ways = " + ways);
    }

    private static int getTotalWays(int[] coins, int amount) {

        if (coins.length == 0){
            if (amount == 0){
                return 1;
            }else{
                return 0;
            }
        }

        Arrays.sort(coins);
        int[][] table = new int[coins[coins.length - 1] + 1][amount + 1];

        Arrays.fill(table[0],0);
        table[0][0] = 1;

        for (int row = 1; row < table.length; row++){

            for (int col = 0; col < table[row].length; col++){

                if (denominationExists(row,coins)){
                    if (col < row){
                        table[row][col] = table[row-1][col];
                    }else{
                        table[row][col] = table[row-1][col];
                        table[row][col] += table[row][col-row];
                    }
                }else{
                    table[row] = table[row-1];
                }

            }
        }

        return table[table.length - 1][table[0].length - 1];
    }

    private static boolean denominationExists(int row,int[] denominations) {
        for (int i:denominations){
            if (i == row)
                return true;
        }
        return false;
    }

}
