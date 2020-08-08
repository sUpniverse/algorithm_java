import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

    }

    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> max = new PriorityQueue<Integer>(Collections.<Integer>reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<Integer>();

        for(int i = 0; i < operations.length; i++) {
            String[] split = operations[i].split(" ");
            String order = split[0];
            int number = Integer.parseInt(split[1]);

            if(order.equals("I")) {
                max.add(number);
                min.add(number);
                continue;
            }

            if(!max.isEmpty() && number == -1) {
                Integer poll = min.poll();
                max.remove(poll);
            } else if(!min.isEmpty() && number == 1) {
                Integer poll = max.poll();
                min.remove(poll);
            }
        }
        int[] answer = new int[2];
        if(max.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        }
        answer[0] = max.peek();
        answer[1] = min.peek();
        return answer;
    }
}
