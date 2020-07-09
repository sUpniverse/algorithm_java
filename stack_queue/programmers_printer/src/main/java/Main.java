import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        int[][] pri = {{2, 1, 3, 2},{1, 1, 9, 1, 1, 1}};
        int[] lo = {2,0};

        for(int i = 0; i < 2; i++)
            System.out.println(solution(pri[i],lo[i]));

    }

    static public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0 ; i < priorities.length; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            answer++;
            Integer remove = queue.remove();

            boolean possible = true;
            Iterator<Integer> iterator = queue.iterator();
            while (iterator.hasNext()) {
                if(priorities[remove] < priorities[iterator.next()]){
                    possible = false;
                    break;
                }
            }

            if(!possible) {
                queue.add(remove);
                answer--;
                continue;
            }

            if(remove == location)
                break;
        }

        return answer;
    }


}
