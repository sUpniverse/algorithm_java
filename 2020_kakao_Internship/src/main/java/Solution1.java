import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {

    public static void main(String[] args) {
        int[] numbers1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand1 = "right";
        int[] numbers2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand2 = "left";
        int[] numbers3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand3 = "right";

        int[] numbers4 = {5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        String hand4 = "right";

        System.out.println(solution(numbers4, hand4));
    }

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int[][] map = {{1,2,3},
                          {4,5,6},
                          {7,8,9},
                          {10,0,11}};
    static boolean[][] check;
    private static int n = 4;
    private static int m = 3;
    static Queue<Dot> leftQueue,rightQueue,dfsQueue;


    static String solution(int[] numbers, String hand) {

        leftQueue = new LinkedList<>();
        rightQueue = new LinkedList<>();
        dfsQueue = new LinkedList<>();

        leftQueue.add(new Dot(3,0,0));
        rightQueue.add(new Dot(3,2,0));

        StringBuilder st = new StringBuilder();

        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                leftQueue.remove();
                st.append("L");
                if(numbers[i] == 1) {
                    leftQueue.add(new Dot((numbers[i]/2), 0,0));
                } else {
                    leftQueue.add(new Dot((numbers[i]/2)-1, 0,0));
                }
            } else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                rightQueue.remove();
                st.append("R");
                if(numbers[i] == 3) {
                    rightQueue.add(new Dot((numbers[i]/2)-1, 2,0));
                } else {
                    rightQueue.add(new Dot((numbers[i]/2)-2, 2,0));
                }
            } else {
                Dot leftDot = leftQueue.peek();
                int leftDis = dfs(numbers[i], leftDot);
                Dot rightDot = rightQueue.peek();
                int rightDis = dfs(numbers[i],rightDot);

                if(leftDis > rightDis) {
                    change(rightQueue, numbers, i);
                    st.append("R");
                } else if(leftDis < rightDis) {
                    change(leftQueue, numbers, i);
                    st.append("L");
                } else {
                    if(hand.equals("right")) {
                       change(rightQueue, numbers, i);
                        st.append("R");
                    } else {
                        change(leftQueue, numbers, i);
                        st.append("L");
                    }
                }
            }
        }
        return st.toString();
    }

    static void change(Queue<Dot> queue,int[]numbers,int index) {
        queue.remove();
        if(numbers[index] == 0) {
            queue.add(new Dot(3, 1,0));
        } else if(numbers[index] == 8) {
            queue.add(new Dot((numbers[index]/2)-2, 1,0));
        } else {
            queue.add(new Dot((numbers[index]/2)-1, 1,0));
        }
    }

    static int dfs(int num, Dot dot) {
        check = new boolean[n][m];
        dfsQueue.clear();
        dfsQueue.add(dot);
        while(!dfsQueue.isEmpty()) {
            Dot remove = dfsQueue.remove();
            if(map[dot.x][dot.y] == num) {
                return 0;
            }
            for(int i = 0; i < 4; i++) {
                int a = remove.x + dx[i];
                int b = remove.y + dy[i];
                if(a >= 0 && a < n && b >= 0 && b < m && !check[a][b]){
                    if(map[a][b] == num) {
                        return remove.count+1;
                    }
                    dfsQueue.add(new Dot(a, b, remove.count+1));
                    check[a][b] = true;
                }
            }
        }

        return 0;
    }

    static class Dot {
        int x;
        int y;
        int count;

        public Dot(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

}
