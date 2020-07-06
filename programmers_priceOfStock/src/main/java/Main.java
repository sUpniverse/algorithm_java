import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        int[] pr = {1, 2, 3, 2, 3};

        int[] solution = solution(pr);

        for(int i = 0 ; i < solution.length; i++)
            System.out.print(solution[i]+" ");


    }

    static public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        boolean[] check = new boolean[prices.length];


        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        int now = 0;

        while (now < prices.length-1) {
            now++;

            Iterator<Integer> iterator = queue.iterator();
            while (iterator.hasNext()) {
                Integer index = iterator.next();
                if(!check[index] && prices[index] <= prices[now]) {
                    answer[index]++;
                } else {
                    check[index] = false;

                }
            }

            queue.add(now);
        }

        return answer;
    }


}
