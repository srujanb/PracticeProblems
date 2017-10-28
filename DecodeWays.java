public class DecodeWays {

    public static void main(String args[]){

        String encodedString = "0711189";

        int previousNumber = Character.getNumericValue(encodedString.charAt(0));

        int previousToPreviousCombinations = 1;

        int previousCombinations = 1;

        int currentCombinations = 1;

        for (int index = 1; index < encodedString.length(); index++){

            char c = encodedString.charAt(index);
            int currentNumber = Character.getNumericValue(c);

            Boolean canCombine = canCombine(previousNumber,currentNumber);

            if ((index == 1 && previousNumber == 0) ||(currentNumber == 0 && !canCombine)){
                currentCombinations = 0;
                break;
            }

            currentCombinations = previousCombinations;

            if (canCombine)
                currentCombinations += previousToPreviousCombinations;

            previousToPreviousCombinations = previousCombinations;
            previousCombinations = currentCombinations;
            previousNumber = currentNumber;

        }

        System.out.println("Total combinations = " + currentCombinations);

    }

    private static Boolean canCombine(int previousNumber, int current) {

        if (previousNumber + current == 0)
            return false;

        return (previousNumber * 10 + current) < 27;

    }

}
