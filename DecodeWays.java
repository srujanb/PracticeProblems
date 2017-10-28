import java.util.Arrays;

public class DecodeWays {

    public static void main(String args[]){

        String encodedString = "711109";

        System.out.println("Combinations = " + numDecodings(encodedString));


    }

    public static int numDecodings(String s) {

        String encodedString = s;

        if (encodedString == null)
            return 0;

        int[] combinationsTillHere = new int[encodedString.length()];
        Arrays.fill(combinationsTillHere,0);
        if (Character.getNumericValue(encodedString.charAt(0)) == 0)
            combinationsTillHere[0] = 0;
        else
            combinationsTillHere[0] = 1;

        for (int index = 1; index < encodedString.length(); index++){

            int previousNumber = Character.getNumericValue(encodedString.charAt(index-1));
            int currentNumber = Character.getNumericValue(encodedString.charAt(index));
            //without combining
            combinationsTillHere[index] += getIndependentCombinations(currentNumber)*combinationsTillHere[index-1];

            //With Combination
            try{
                combinationsTillHere[index] += getCombinationsWithPrevious(previousNumber,currentNumber)*combinationsTillHere[index-2];
            }catch(ArrayIndexOutOfBoundsException e){
                combinationsTillHere[index] += getCombinationsWithPrevious(previousNumber,currentNumber)*1;
            }
        }

        return combinationsTillHere[encodedString.length() - 1];

    }

    public static int getIndependentCombinations(int currentNumber){

        if  (currentNumber == 0)
            return 0;
        else
            return 1;
    }

    public static int getCombinationsWithPrevious(int previousNumber,int currentNumber){
        if (previousNumber == 0)
            return 0;
        if (previousNumber*10 + currentNumber < 27)
            return 1;
        return 0;
    }

}
