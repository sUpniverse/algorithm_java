import java.util.LinkedList;

public class Solution2 {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int[][] office = {{5,1,4},{6,3,1},{2,-1,1}};


    public static void main(String[] args) {
        int r = 0;
        int c = 1;
        String[] move = {"go","go","right","go","right","go","left","go"};

        int n = office.length;
        int my = 1;
        int answer = 0;

        for(int i = 0; i < move.length; i++) {
            if(move[i].equals("go")) {
                int nx = r + dx[my];
                int ny = c + dy[my];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if(office[r][c] != -1) {
                        answer += office[r][c];
                        office[r][c] = 0;
                        r = nx;
                        c = ny;
                    }
                }

            } else if(move[i].equals("left")) {
                int nx = r + dx[my-1];
                int ny = c + dy[my-1];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if(office[r][c] != -1) {
                        answer += office[r][c];
                        my = my - 1;
                        office[r][c] = 0;
                        r = nx;
                        c = ny;
                    }
                }
            } else if(move[i].equals("right")) {
                int nx = r + dx[my+1];
                int ny = c + dy[my+1];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if(office[r][c] != -1) {
                        answer += office[r][c];
                        my = my +1;
                        office[r][c] = 0;
                        r = nx;
                        c = ny;
                    }
                }
            }
        }

        System.out.println(answer);

    }
}
