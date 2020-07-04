import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        int[][] h = {{6,9,5,7,4},{3,9,9,3,5,7,2},{1,5,3,6,7,6,5}};

        for(int i = 0; i < 3; i++) {
            int[] solution = solution(h[i]);
            for(int j = 0; j < solution.length; j++)
                System.out.print(solution[j]+" ");
            System.out.println();
        }


    }

    static int[] solution(int[] heights) {
        int[] answer = new int[heights.length];

        int now = heights.length - 1;
        Stack<Integer> stack = new Stack<>();

        while (now > 0) {

            stack = new Stack<>();
            for(int i = 0; i < now; i++)
                stack.add(heights[i]);

            int count = now;
            while (count > 0 && stack.peek() <= heights[now]) {
                stack.pop();
                count--;
            }

            answer[now] = count;

            now--;
        }

        return answer;
    }

}

