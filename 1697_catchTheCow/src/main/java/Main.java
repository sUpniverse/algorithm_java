import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] map;
    static boolean[] check;
    static int[] run = {-1,1};
    static int move = 2;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        map = new int[100001];
        check = new boolean[100001];
        int su = Integer.parseInt(split[0]);
        int dong = Integer.parseInt(split[1]);
        queue = new LinkedList<Integer>();

        if((dong-su) <= 0) {
            System.out.println(su-dong);
            return;
        }

        queue.add(su);
        map[su] = 1;
        check[su] = true;

        while(!queue.isEmpty()) {
            int now = queue.remove();
            for (int i = 0; i < 3; i++) {
                int x = 0;
                if (i == 2) {
                    x = now * move;
                } else {
                    x = now + run[i];
                }


                if (x >= 0 && x < 100001 && !check[x]) {
                    map[x] = map[now] + 1;
                    check[x] = true;
                    if (x == dong) {
                        System.out.println(map[x] - 1);
                        return;
                    }
                    queue.add(x);
                }
            }
        }

    }

}
