import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    static boolean[][] map;
    static int n;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new boolean[n][n];

        queen(0);

        System.out.println(count);

    }

    static void queen(int depth) {
        if(depth == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if(possible(depth,i)) {
                map[depth][i] = true;
                queen(depth+1);
                map[depth][i] = false;
            }
        }

    }

    private static boolean possible(int x, int y) {
        //가로,세로, 대각선에 해당하는 queen이 있는지 확인하면 됌

        //가로
        for(int i = 0; i < n; i++) {
            if(i != y && map[x][i])
                return false;
        }

        //세로
        for(int i = 0; i < n; i++){
            if(i != x && map[i][y])
                return false;
        }

        //대각선
        for(int i = 0; i <n; i++) {
            // 오른쪽 아래
            if(x+i < n && y+i < n && map[x+i][y+i])
                return false;

            // 왼쪽 아래
            if(x+i < n && y-i >= 0 && map[x+i][y-i])
                return false;
            // 오른쪽 위
            if(x-i >= 0 && y+i < n && map[x-i][y+i])
                return false;

            // 오른쪽 아래
            if(x-i >= 0 && y-i >= 0 && map[x-i][y-i])
                return false;
        }

        return true;
    }


}
