import java.util.Arrays;
import java.util.Collections;

public class Main2 {

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};

        int solution = solution(citations);

        System.out.println(solution);
    }

    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        // 원소의 값이 작아지면, 원소 값 이상의 갯수도 작아진다.
        // 그렇기에 정렬된 배열에서 원소의 값보다 원소의 갯수가 큰경우가 가장 근접한 답이다.
       for(int i=0; i<citations.length; i++){
            int smaller = Math.min(citations[i], citations.length-i);
            answer = Math.max(answer, smaller);
        }
        return answer;
    }
}
