import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        int[] scoville =  {1, 2, 3, 9, 10, 12};
        int[] scoville2 =  {0, 0, 0, 0, 0, 0};
        int K = 7;
        System.out.println(solution(scoville2, K));;

    }

    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> min = new PriorityQueue();

        int index = -1;
        for(int i = 0; i < scoville.length; i++) {
            min.add(scoville[i]);
        }

        int sum = 0;
        int count = 0;
        while (min.peek() < K && min.size() >= 2) {
            count++;
            Integer first = min.poll();
            Integer second = min.poll();
            sum = first + (second * 2);
            min.add(sum);
        }
        if(min.peek() >= K) index = count;
        return index;
    }
}
