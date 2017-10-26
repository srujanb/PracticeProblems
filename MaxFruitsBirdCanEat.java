//1. There are n trees in a circle.
// Each tree has a fruit value associated with it.
// A bird can sit on a tree for 0.5 sec and then he has to move to a neighbouring tree.
// It takes the bird 0.5 seconds to move from one tree to another.
// The bird gets the fruit value when she sits on a tree.
// We are given n and m (the number of seconds the bird has), and the fruit values of the trees.
// We have to maximise the total fruit value that the bird can gather.
// The bird can start from any tree.



public class MaxFruitsBirdCanEat {

    public static void main(String args[]){

        int window = 2;
        int[] fruitValues = {9,9,6,7,8,5,3,1,4,9};

        int maxSum = -1;
        int startWith = -1;

        for (int i = 0; i < fruitValues.length; i++){

            int sumOfWindow = 0;

            for (int j = 0; j < window; j++){

                sumOfWindow += fruitValues[(i+j) % fruitValues.length];

                if (sumOfWindow >= maxSum){
                    maxSum = sumOfWindow;
                    startWith = i;
                }
            }

        }

        System.out.println("Max: " + maxSum);
        System.out.println("Start from: " + startWith);

    }

}
