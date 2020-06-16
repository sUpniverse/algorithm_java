import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static ArrayList<Dot> arrayList;
    static int size,flag;
    static int[] array;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        array = new int[10];
        arrayList = new ArrayList<Dot>();
        map = new int[9][9];

        for(int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
                if (a == 0) {
                    arrayList.add(new Dot(i, j));
                    continue;
                }
                array[a]++;
            }
        }
        flag = 0;
        size = arrayList.size();
        search(0);

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

    }

    static void search(int now) {
        if (flag == 1) return;

        if(now == size) {
            flag = 1;
            return;
        }

        for(int i = 1; i < 10; i++) {
            if(array[i] < 9 && isCorrect(arrayList.get(now).x,arrayList.get(now).y,i)) {
                array[i]++;
                map[arrayList.get(now).x][arrayList.get(now).y] = i;
                search(now+1);
                if (flag == 1) return;
                array[i]--;
                map[arrayList.get(now).x][arrayList.get(now).y] = 0;
            }
        }
    }

    static boolean isCorrect(int x, int y, int v) {
        // 가로, 세로
        for (int i = 0; i < 9; i++) {
            if(map[i][y] == v || map[x][i] == v) {
                return false;
            }
        }
        // 3x3 격자 내부
        for (int i = (x/3)*3; i < (x/3)*3 + 3; i++) {
            for (int j = (y/3)*3; j < (y/3)*3 +3; j++) {
                if(map[i][j] == v) {
                    return false;
                }
            }
        }
        return true;
    }

    static class Dot {
        int x;
        int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
