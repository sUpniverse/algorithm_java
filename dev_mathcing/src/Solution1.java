import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution1 {

    public static void main(String[] args) {

    }

    public int solution(int n, String[] customers) {
        int answer = 0;

        Queue<Machine> machines = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            machines.add(new Machine(0,0, 0));
        }

        for(int i = 0; i < customers.length; i++) {

        }

        return answer;
    }

    static class Machine implements Comparable<Machine>{
        int index;
        int count;
        int time;

        public Machine(int index, int count, int time) {
            this.index = index;
            this.count = count;
            this.time = time;
        }

        @Override
        public int compareTo(Machine o) {
            if(this.time == o.time) {
                return this.index - o.index;
            }
            return this.time - o.time;
        }
    }

}
