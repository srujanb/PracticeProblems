//GeeksforGeeks http://www.geeksforgeeks.org/decode-string-recursively-encoded-count-followed-substring/

//uses recursion

//Decode a string recursively encoded as count followed by substring
//An encoded string (s) is given, the task is to decode it.
//The pattern in which the strings are encoded is as follows.
//Input : str[] = "1[b]"
//Output : b
//
//Input : str[] = "2[ab]"
//Output : abab
//
//Input : str[] = "2[a2[b]]"
//Output : abbabb
//
//Input : str[] = "3[b2[ca]]"
//Output : bcacabcacabcaca


public class DecodeStringRecursively {

    public static void main(String args[]){

        String encodedString = "3[b2[ca]]";

        String decodedString = decodeString(encodedString);

        System.out.println("Answer: " + decodedString);

    }

    private static String decodeString(String encodedString) {

        if (encodedString.length() == 0)
            return "";

        char firstChar = encodedString.charAt(0);
        String restOfTheString = encodedString.substring(1,encodedString.length());
        String returnValue = "";
        int times = 1;

        if ((String.valueOf(firstChar)).equals("[")){
            getStringContent(restOfTheString);
            returnValue = decodeString(restOfTheString);

        }else if( Character.getNumericValue(firstChar) < 10){
            times = Character.getNumericValue(firstChar);
            returnValue = decodeString(restOfTheString);
        }else{
            returnValue = decodeString(restOfTheString);
        }

        String temp = returnValue;
        for (int i = 1; i < times; i++)
            returnValue += temp;

        if (String.valueOf(firstChar).equals("[") || Character.getNumericValue(firstChar) < 10)
            return returnValue;
        else
            return (firstChar + returnValue);

    }


    private static String getStringContent(String substring) {

        int depth = 0;
        int index = 0;

        for (char c: substring.toCharArray()){
            if (c == '['){
                depth++;
            }else if (c == ']'){
                depth--;
            }

            if (depth == -1){
                break;
            }

            index++;
        }

        return substring.substring(0,index - 1);
    }
}
