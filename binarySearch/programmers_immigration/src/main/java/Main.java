import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        int[] times2 = {1,1,1,1,1};

        long solution = solution(n, times2);

        System.out.println(solution);

    }

    public static long solution(int n, int[] times) {

        Arrays.sort(times);

        long l = 0;
        long r = (long) times[times.length-1] * (long) n;
        long mid = 0;
        long answer = 0;


        while (l <= r) {
            mid = (l+r) / 2;

            long sum = 0;
            for(int i = 0; i < times.length; i++)
                sum += mid / times[i];

            if(sum >= n){
                answer = mid;
                r = mid-1;
            } else {
                l = mid+1;
            }
        }

        return answer;
    }



}
