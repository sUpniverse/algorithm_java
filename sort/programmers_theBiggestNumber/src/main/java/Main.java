import java.util.Arrays;
import java.util.Comparator;

public class Main {


    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        int[] numbers2 = {3, 30, 34, 5, 9};

        String solution = solution(numbers2);

        System.out.println(solution);
    }

    public static String solution(int[] numbers) {

        String[] arr = new String[numbers.length];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if(arr[0].equals("0")) return "0";

        for(int i = 0; i < arr.length; i++)
            sb.append(arr[i]);

        return sb.toString();
    }

}
