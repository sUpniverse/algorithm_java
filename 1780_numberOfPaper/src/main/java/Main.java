import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] count;
    static int[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        array = new int[n][n];
        count = new int[3];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0,0,n);

        for(int i = 0; i < 3; i++) {
            System.out.println(count[i]);
        }
    }

    static void divide(int x,int y,int size) {
        if(check(x,y,size)) {
           return;
        }
        int n = size/3;
        for(int i = x; i < x+size; i=i+n) {
            for(int j = y; j < y+size; j=j+n) {
                divide(i,j,n);
            }
        }
    }

    static boolean check(int x,int y, int size) {
        for(int i = x; i < x+size; i++) {
            for(int j = y; j < y+size; j++) {
                if(array[i][j] != array[x][y]) {
                    return false;
                }
            }
        }
        count[array[x][y]+1]++;
        return true;
    }
}
