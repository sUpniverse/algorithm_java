import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        int[] progresses = {93,30,55};
        int[] speed = {1,30,5};

        int[] solution = solution(progresses, speed);

        for(int i = 0 ; i < solution.length; i++)
            System.out.print(solution[i]+" ");

    }

    static public int[] solution(int[] progresses, int[] speeds) {

        int pointer = 0;
        int size = progresses.length;

        Queue<Integer> queue = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();

        while (pointer < size) {

            for(int i = 0; i < size; i++) {
                progresses[i] += speeds[i];
            }

            while (pointer < size && progresses[pointer] > 100) {
                if(progresses[pointer] > 100) {
                    queue.add(progresses[pointer]);
                    pointer++;
                }
            }

            int count = 0;
            while (!queue.isEmpty()) {
                queue.remove();
                count++;
            }

            if(count > 0)
                list.add(count);
        }

        int[] answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);

        return answer;
    }

}
