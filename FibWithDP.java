import java.util.Arrays;

public class FibWithDP {

    static Integer[] fabValue;
    public static void main(String args[]){

        int param = 4000;

        setInitialFabValue(param);

        Integer result = getFabValue(param);

        System.out.println("result: " + result);
    }

    private static Integer getFabValue(int param) {

        int response;
        if (param == 0)
            return 0;
        else if (param == 1)
            return 1;
        else if (fabValue[param] != null) {
            response = fabValue[param];
            fabValue[param] = response;
            return response;
        }

        response = getFabValue(param - 1) + getFabValue(param - 2);
        fabValue[param] = response;
        return response;

    }


    private static void setInitialFabValue(int param) {
        fabValue = new Integer[param + 1];
        fabValue[0] = 0;
        fabValue[1] = 1;
    }
}
