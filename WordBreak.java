import java.util.ArrayList;
import java.util.List;

public class WordBreak {

    static String word = "catdogs";
    static Boolean[][] canBeSeg;
    static List<String> dict;

    public static void main(String args[]){

        dict = new ArrayList<>();
        canBeSeg = new Boolean[word.length()][word.length()];
        dict.add("dog");
        dict.add("cat");

        System.out.println("Answer: " + isSegmentable(0,word.length() - 1).toString());


    }

    private static Boolean isSegmentable(int beg, int end) {

        if (canBeSeg[beg][end] != null){
            return canBeSeg[beg][end];
        }
        else{
            String subString = word.substring(beg,end+1);
            if (dict.contains(subString)){
                canBeSeg[beg][end] = true;
                return true;
            }else{
                if (subString.length() == 1) {
                    canBeSeg[beg][end] = false;
                    return false;
                }
                else{
                    for (int split = 0; split < end-beg; split++){
                        if (isSegmentable(beg,beg+split) && isSegmentable(beg+split+1,end)) {
                            canBeSeg[beg][end] = true;
                            return true;
                        }
                    }
                }
            }
        }
        canBeSeg[beg][end] = false;
        return false;
    }
}
