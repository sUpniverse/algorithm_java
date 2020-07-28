import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};

        int solution = solution(citations);

        System.out.println(solution);
    }

    public static int solution(int[] citations) {
        int answer = 0;

        Integer[] arr = new Integer[citations.length];
        for(int i = 0; i < citations.length; i++)
            arr[i] = citations[i];

        Arrays.sort(arr, Collections.reverseOrder());
        for(int i = arr[0]; i >= 0; i--) {
            int count = 0;
            for(int j = 0; j < arr.length; j++) {
                if(i <= arr[j])
                    count++;
            }
            if(i <= count) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
