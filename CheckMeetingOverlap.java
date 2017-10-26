

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckMeetingOverlap {

    public static void main(String args[]){

        List<Meeting> list = new ArrayList<>();

        Meeting meeting = new Meeting(1,4);
        list.add(meeting);

        meeting = new Meeting(7,9);
        list.add(meeting);

        meeting = new Meeting(4,6);
        list.add(meeting);

        Boolean result = checkOverlap(list);

        if (result)
            System.out.println("There is no overlap");
        else
            System.out.println("THERE IS OVERLAP");
    }

    private static Boolean checkOverlap(List<Meeting> list) {
        Collections.sort(list);

        for(int i = 0; i < list.size() - 1; i++){

            if (list.get(i).getEndTime() > list.get(i+1).getStartTime())
                return false;

        }

        return true;
    }

}
