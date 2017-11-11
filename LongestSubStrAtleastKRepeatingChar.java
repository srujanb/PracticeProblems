import java.util.HashMap;
import java.util.Map;

public class LongestSubStrAtleastKRepeatingChar {

    public static void main(String args[]){

        String str = "ababbc";
        int k = 2;

        Map<Integer,Map<Character,Integer>> map = getPreviousOccurencesMap(str);

        int maxSubArrayLength = 0;
        Boolean shouldBreak;
        for (int i = 0; i < str.length(); i++){
//            System.out.println("for i = " + i);
            Map<Character,Integer> submapI = map.get(i);

            for (int j = -1; j < i; j++){

//                System.out.println("for j = " + j);
                shouldBreak = false;
                Map<Character,Integer> submapJ = new HashMap<>();
                if (j != -1)
                    submapJ = map.get(j);

                for (Character c: submapI.keySet()){
                    int ci = submapI.get(c);
                    int cj = submapJ.getOrDefault(c,0);

//                    System.out.println("For char: " + c + ": ci = " + ci + ", cj = " + cj);

                    if (ci-cj < k){
                        shouldBreak = true;
                        break;
                    }
                }

                if (shouldBreak)
                    break;
                if (i-j>maxSubArrayLength)
                    maxSubArrayLength = i - j + 1;
            }
        }

        System.out.println("Max subarray: " + maxSubArrayLength);

    }

    public static Map<Integer,Map<Character,Integer>> getPreviousOccurencesMap(String str) {
        Map<Integer,Map<Character,Integer>> map = new HashMap<>();
        Map<Character,Integer> previousSubMap = null;
        for (int i = 0; i < str.length(); i++){

            Map<Character,Integer> subMap = previousSubMap;
            if (subMap == null)
                subMap = new HashMap<>();
            Character current =  str.charAt(i);

            subMap.putIfAbsent(current,0);
            subMap.put(current,subMap.get(current) + 1);

            map.put(i,new HashMap<>(subMap));

            previousSubMap = subMap;
        }

        return map;
    }
}
