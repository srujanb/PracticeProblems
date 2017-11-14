import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String args[]){


        List<int[]> intervals = new ArrayList<>();
        int[] arr ;
        arr = new int[]{1, 7};
        intervals.add(arr);
        arr = new int[]{5,5};
        intervals.add(arr);

        List<int[]> mergedIntervals= getMergedIntervals(intervals);


        for (int[] interval: mergedIntervals){
            System.out.println(String.format("%d,%d",interval[0],interval[1]));
        }

    }

    private static List<int[]> getMergedIntervals(List<int[]> intervals) {

        int intervalDepth = 0;

        int[] begTime = new int[intervals.size()];
        int[] endTIme = new int[intervals.size()];

        int headBeg = 0;
        int headEnd = 0;

        for (int i = 0; i < intervals.size(); i++){
            int[] arr = intervals.get(i);

            begTime[i] = arr[0];
            endTIme[i] = arr[1];
        }
        Arrays.sort(begTime);
        Arrays.sort(endTIme);

        List<int[]> mergedInt = new ArrayList<>();
        int[] interval = new int[2];

        for (; headBeg < intervals.size(); ){

            if (begTime[headBeg] <= endTIme[headEnd]){
                if (intervalDepth == 0){
                    System.out.println("new interval start time: " + begTime[headBeg]);
                    interval[0] = begTime[headBeg];
                }
                intervalDepth++;
                headBeg++;
            }else{
                intervalDepth--;
                if (intervalDepth == 0){
                    System.out.println("new interval end time: " + endTIme[headEnd]);
                    interval[1] = endTIme[headEnd];


                    mergedInt.add(interval.clone());
                }
                headEnd++;
            }
        }
        interval[1] = endTIme[endTIme.length-1];
        mergedInt.add(interval);

        return mergedInt;
    }

}
