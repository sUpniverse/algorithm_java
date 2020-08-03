    import java.util.Collections;
    import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        int stock  =4;
//        int[] dates = {4,10,15};
        int[] dates = {1, 2, 3, 4};
//        int[] supplies = {20,5,10};
        int[] supplies = {10, 40, 20, 30};
//        int k = 30;
        int k = 100;

        int solution = solution(stock, dates, supplies, k);
        System.out.println(solution);
    }

    public static int solution(int stock, int[] dates, int[] supplies, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder());

        int day = 0;
        int index = 0;
        int answer = 0;
        while ( day < k) {
            if(index < dates.length && dates[index] == day) {
                queue.add(supplies[index]);
                index++;
            }

            if(stock == 0) {
                stock += queue.poll();
                answer++;
            }

            stock--;
            day++;
        }

        return answer;
    }




}
