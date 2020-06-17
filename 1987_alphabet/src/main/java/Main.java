import java.util.Scanner;

public class Main {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int[][] map;
    static int value  = Integer.MIN_VALUE;
    static int r,c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();

        map = new int[r][c];
        boolean[] visited = new boolean[26];

        for(int i = 0; i < r; i++) {
            String ch = sc.next();
            for(int j = 0; j < c; j++) {
                map[i][j] = ch.charAt(j)-'A';
            }
        }

        search(0, 0, 1,visited);

        System.out.println(value);

    }

    static void search(int x, int y,int count,boolean[] visited) {
        visited[map[x][y]] = true;
        value = Math.max(value,count);

        for(int i = 0; i < 4; i++) {
            int ax = x + dx[i];
            int ay = y + dy[i];

            if(ax >= 0 && ax < r && ay >= 0 && ay < c && !visited[map[ax][ay]]) {
                search(ax, ay, count+1,visited);
            }
        }
        visited[map[x][y]] = false;
    }
}
