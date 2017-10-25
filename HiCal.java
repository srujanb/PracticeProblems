//Your company built an in-house calendar tool called HiCal.
// You want to add a feature to see the times in a day when everyone is available

//To do this, you’ll need to know when any team is having a meeting.
// In HiCal, a meeting is stored as an object of a Meeting class with integer variables startTime and endTime.
// These integers represent the number of 30-minute blocks past 9:00am.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HiCal {

    public static void main(String args[]){

        List<Meeting> listOfMeetings = new ArrayList<>();

        Meeting meeting = new Meeting(1,10);
        listOfMeetings.add(meeting);

        meeting = new Meeting(2,6);
        listOfMeetings.add(meeting);

        meeting = new Meeting(3,5);
        listOfMeetings.add(meeting);

        meeting = new Meeting(7,9);
        listOfMeetings.add(meeting);

        List<Meeting> listOfMeetingChunks = mergeRanges(listOfMeetings);


//        System.out.println("Size of list1: " + listOfMeetings.size());
//        System.out.println("Size of list2: " + listOfMeetingChunks.size());
        for (Meeting current : listOfMeetingChunks){
            System.out.println("Meeting: " + current.getStartTime() + " , " + current.getEndTime());
        }
    }

    private static List<Meeting> mergeRanges(List<Meeting> listOfMeetings) {

        int[] startTimes = new int[listOfMeetings.size()];
        int[] endTimes = new int[listOfMeetings.size()];


        int index = 0;
        for (Meeting meeting: listOfMeetings){

            startTimes[index] = meeting.getStartTime();
            endTimes[index] = meeting.getEndTime();

            index++;
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        List<Meeting> listOfMeetingChunks = new ArrayList<>();

        int noOfMeetingsOnGoing = 0;

        Meeting meetingChunk = new Meeting(0,0);

        for (int i = 0, j = 0; true; ){

            if (i < startTimes.length && startTimes[i] <= endTimes[j]){
                if (noOfMeetingsOnGoing == 0){
                    meetingChunk = new Meeting(0,0);
                    meetingChunk.setStartTime(startTimes[i]);
                }
                noOfMeetingsOnGoing++;
                i++;
            }
            else{
                noOfMeetingsOnGoing--;
                if (noOfMeetingsOnGoing == 0){
                    meetingChunk.setEndTime(endTimes[j]);
                    listOfMeetingChunks.add(meetingChunk);
                }
                j++;
            }

            if (j == endTimes.length)
                return listOfMeetingChunks;
        }

    }
}
