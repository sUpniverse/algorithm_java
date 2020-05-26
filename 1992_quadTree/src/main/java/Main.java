import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb;
    static int[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();


        int n = Integer.parseInt(br.readLine());
        array = new int[n][n];


        for(int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for(int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(split[j]);
            }
        }

        divide(0, 0, n);

        System.out.println(sb);

    }

    static void divide(int x, int y, int size) {
        if(check(x,y,size)) {
            sb.append(array[x][y]);
            return;
        }
        int n = size / 2;
        sb.append("(");
        for(int i = x; i < x+size; i+=n) {
            for(int j = y; j < y+size; j+=n) {
                divide(i,j,n);
            }
        }
        sb.append(")");
    }

    private static boolean check(int x, int y, int size) {
        for(int i = x; i < x+size; i++) {
            for(int j = y; j < y+size; j++) {
                if(array[i][j] != array[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }
}
