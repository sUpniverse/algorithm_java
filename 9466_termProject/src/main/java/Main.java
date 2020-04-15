import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
    2
    7
    3 1 3 7 3 4 6
    8
    1 2 3 4 5 6 7 8

    6
    2 3 4 5 6 2
    output : 1

    5
    2 5 4 5 2
    output : 3

    6
    1 3 4 3 2 6
    output : 2

    13
    2 4 5 2 4 1 8 9 10 11 9 10 10
    output : 8

    10
    2 5 7 1 6 8 8 3 5 10
    output : 6

    10
    2 7 10 5 3 3 9 10 6 3
    output : 8

    6
    2 1 1 2 6 3
    output : 4
 */

public class Main {

    static boolean[] visited;
    static boolean[] team;
    static int[] map;
    static ArrayList<Integer> list;
    static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            visited = new boolean[size+1];
            team = new boolean[size+1];
            map = new int[size+1];
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= size; i++) {
                map[i]  = Integer.parseInt(st.nextToken());
            }
            count = 0;
            for(int i = 1; i <= size; i++) {
                if(team[i]) continue;
                dfs(i);
            }
            System.out.println(size-count);
        }
    }

    static void dfs(int v) {
        visited[v] = true;

        if(!visited[map[v]]) {
            dfs(map[v]);
        } else if(visited[map[v]] && !team[map[v]]) {
            for(int i = map[v]; i!=v; i=map[i]) {
                count++;
            }
        count++;
        }
        team[v] = true;
        return;
    }
}
