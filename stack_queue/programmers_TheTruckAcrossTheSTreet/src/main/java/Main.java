import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        int[] br = {2,100,100};
        int[] we = {10,100,100};
        int[][] tr = {{7,4,5,6},{10},{10,10,10,10,10,10,10,10,10,10}};

        for(int i = 0; i < 3; i++){
            System.out.println(solution(br[i],we[i], tr[i]));
        }

    }

    static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();

        int sum = 0;
        int point = 0;

        for(int i = 0; i < bridge_length; i++) {
            queue.add(0);
        }

        while (point < truck_weights.length) {
            sum -= queue.remove();
            answer++;

            // 현재의 무게가 무거울 경우엔 차가 올라오지 못한다. 그럴땐 + 0 으로
            if(sum + truck_weights[point] > weight) {
                queue.add(0);

            } else {                //그게 아니라면, 다리에 차를 올린다.
                queue.add(truck_weights[point]);
                sum += truck_weights[point];
                point++;
            }

        }

        return answer+bridge_length;
    }
}

