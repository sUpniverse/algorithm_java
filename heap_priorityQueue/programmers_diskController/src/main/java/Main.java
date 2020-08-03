import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        int solution = solution(jobs);
        System.out.println(solution);
    }

    public static int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1,o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        Queue<Process> queue = new PriorityQueue<Process>();

        int sum = 0;

        for(int i = 0; i < jobs.length; i++)
            sum += jobs[i][1];

        int answer = 0;
        int index  = 0;
        int time = 0;
        while (index < jobs.length || !queue.isEmpty()) {
            while (index < jobs.length && jobs[index][0] <= time) {
                queue.add(new Process(jobs[index][0], jobs[index][1]));
                index++;
            }

            if(!queue.isEmpty()) {
                Process process = queue.poll();
                time += process.workingTime;
                answer += time - process.requestTime;
            } else {
                time = jobs[index][0];
            }
        }
        return answer / jobs.length;
    }

    static class Process implements Comparable<Process>{
        int requestTime;
        int workingTime;

        public Process(int requestTime, int workingTime) {
            this.requestTime = requestTime;
            this.workingTime = workingTime;
        }

        @Override
        public int compareTo(Process o) {
            return this.workingTime - o.workingTime;
        }
    }
}
