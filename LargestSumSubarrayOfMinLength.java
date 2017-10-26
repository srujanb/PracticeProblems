//Geeksforgeeks http://www.geeksforgeeks.org/largest-sum-subarray-least-k-numbers/

//Largest sum subarray with at-least k numbers

// Does not give correct output:
// TODO - Create separate arrays: largestSum and largestSumWithoutWindow and move forward accordingly

public class LargestSumSubarrayOfMinLength {

    public static void main(String args[]){

        int[] arr = {-4,3,-2,1,-3};

        int k = 2;

        int[] result = getLargestSumSubArray(k,arr);

        for (int i: result)
            System.out.printf("" + i + ", ");

    }

    private static int[] getLargestSumSubArray(int k,int[] arr) {

        int[] largestSum = new int[arr.length];

        largestSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++){

            if (i < k - 1){
                if (largestSum[i-1] > 0)
                    largestSum[i] = arr[i] + largestSum[i-1];
                else
                    largestSum[i] = arr[i];
            }else{
                int sumOfWindow = 0;
                for (int j = 0; j < k; j++){
                    sumOfWindow += arr[i-j];
                }
                System.out.println(String.format("sum of window for i = %d : %s" , i,sumOfWindow));
                if (i-k >= 0){
                    if (largestSum[i-k] > 0) {
                        largestSum[i] = sumOfWindow + largestSum[i - k];
                        System.out.println(String.format("when i = %d and  i - k = %d, largestSum before = %d", i, i-k,largestSum[i-k]));
                    }
                    else {
                        largestSum[i] = sumOfWindow;
                        System.out.println(String.format("breakpoint 2 when i = %d, largestSum[i-k] = %d", i,largestSum[i-k]));
                    }
                }else{
                    largestSum[i] = sumOfWindow;
                }
            }

        }

        return largestSum;

    }

}
