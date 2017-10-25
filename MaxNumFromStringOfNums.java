// GeeksForGeeks facebook

//Given a string of numbers, the task is to find the maximum value from the string,
// you can add a ‘+’ or ‘*’ sign between any two numbers.

//Input : 01231
//        Output :
//        ((((0 + 1) + 2) * 3) + 1) = 10
//        In above manner, we get the maximum value i.e. 10
//
//        Input : 891
//        Output :73
//        As 8*9*1 = 72 and 8*9+1 = 73.So, 73 is maximum.


public class MaxNumFromStringOfNums {

    public static void main(String args[]){

        String string = "21119";

        int[] numbers = new int[string.length()];

        int index = 0;
        for (char c: string.toCharArray()){

            numbers[index] = Integer.parseInt(String.valueOf(c));

            index++;
        }

        int max = getMaxNumber(numbers);

        System.out.println("Answer: " + max);
    }

    private static int getMaxNumber(int[] numbers) {
        int finalAns = numbers[0];
        int index = 0;
        for (int num: numbers){

            if (index == 0){
                index++;
                continue;
            }

            if (finalAns*num > (finalAns + num))
                finalAns *= num;
            else
                finalAns += num;

            index++;

        }
        return finalAns;
    }

}
