//You have an array of integers,
// and for each index you want to find the product of every integer
// except the integer at that index.
//
//
//Write a method getProductsOfAllIntsExceptAtIndex() that takes an array of integers
// and returns an array of the products.
//
//Do not use division in your solution.
// Complexity: O(n)
//


public class ProductExceptCurrent {

    public static void main(String args[]){

        int[] arr = {0,1};

        int[] newArr = getProductsOfAllIntsExceptAtIndex(arr);

        for (int i: newArr){
            System.out.print("" + i + ",");
        }
    }

    private static int[] getProductsOfAllIntsExceptAtIndex(int[] arr) {

        int[] newArr = new int[arr.length];

        int productFromLeft = 1;
        int productFromRight = 1;


        for (int i = 0; i < arr.length ; i++){
            newArr[i] = 1;
        }

        for (int i = 0; i < arr.length; i++){
            productFromLeft *= arr[i];
            productFromRight *= arr[arr.length - i - 1];

            if (i+1 != arr.length){
                newArr[i+1] *= productFromLeft;
            }

            if (arr.length - i - 2 >= 0){
                newArr[arr.length - i - 2] *= productFromRight;
            }

        }


        return newArr;
    }
}
