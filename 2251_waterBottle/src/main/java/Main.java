import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static boolean[][] visited;
    static ArrayList<Integer> answer;
    static int a,b,c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        visited = new boolean[201][201];

        answer = new ArrayList<>();
        String[] split = br.readLine().split(" ");
        a = Integer.parseInt(split[0]);
        b = Integer.parseInt(split[1]);
        c = Integer.parseInt(split[2]);

        exchange(0, 0, c);

        Collections.sort(answer);

        for(int a : answer) {
            System.out.print(a + " ");
        }


    }

    static void exchange(int da, int db, int dc) {
        if(visited[da][db]) {
            return;
        }

        visited[da][db] = true;

        if(da == 0) {
            answer.add(dc);
        }

        //A to B
        if(da+db > b) {
            exchange((da+db)-b, b, dc);
        } else {
            exchange(0, da+db, dc);
        }

        //B to A
        if(da+db > a) {
            exchange(a, (da+db)-a, dc);
        } else {
            exchange(da+db, 0, dc);
        }

        //C to A
        if(da+dc > a) {
            exchange(a, db, (da+dc)-a);
        } else {
            exchange((da+dc), db, 0);
        }

        //C to A
        if(db+dc > b) {
            exchange(da, b, (db+dc)-b);
        } else {
            exchange(da, db+dc, 0);
        }

        //A to C
        exchange(0,db,da+dc);

        //B to C
        exchange(da, 0, db+dc);

    }


}
