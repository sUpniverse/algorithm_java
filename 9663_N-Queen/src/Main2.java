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

    }

    static void queen(int depth) {
        if(depth == n)
            count++;

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
        for(int i = 0; i < n; i++) {
            if(i != y && map[x][i])
                return false;
        }

        for(int i = 0; i < n; i++){
            if(i != x && map[i][y])
                return false;
        }

        for()

        return true;
    }


}
