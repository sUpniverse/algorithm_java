import java.util.Collections;
import java.util.PriorityQueue;

public class Main2 {

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
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        int index = 0;
        for (int i = 0; i < k; i++) {
            if(index < dates.length && i == dates[index])
                priorityQueue.add(supplies[index++]);

            if(stock == 0) {
                stock += priorityQueue.poll();
                answer++;
            }
            stock -= 1;
        }
        return answer;
    }
}
