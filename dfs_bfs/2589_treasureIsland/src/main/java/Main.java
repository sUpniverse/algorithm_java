import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  static int[] ax = {-1, 0, 1, 0};
  static int[] ay = {0, -1, 0, 1};
  static int n;
  static int m;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    String[] split = s.split(" ");
    n = Integer.parseInt(split[0]);
    m = Integer.parseInt(split[1]);

    char[][] map = new char[n][m];

    Queue<Point> queue = new LinkedList<>();

    for(int i = 0; i < n; i++) {
      String c = br.readLine();
      for(int j = 0; j < m; j++) {
        map[i][j] = c.charAt(j);
      }
    }


    char[][] cmap = new char[n][m];
    int max = 0;
    Point check = null;
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        if(map[i][j] == 'L') {
          int count = 0;
          queue.add(new Point(i, j, -1));
          for(int k = 0; k < n; k++) {
            for(int l = 0; l < m; l++) {
              cmap[k][l] = map[k][l];
            }
          }
          while (!queue.isEmpty()) {
            Point p = queue.remove();
            if(cmap[p.x][p.y] == 'Q') {
              count = Math.max(count, p.count);
              continue;
            }
            cmap[p.x][p.y] = 'Q';
            for(int q = 0; q < 4; q++) {
              int dx = p.x + ax[q];
              int dy = p.y + ay[q];
              if(dx >= 0 && dx < n && dy >= 0 && dy < m && map[dx][dy] == 'L') {
                queue.add(new Point(dx, dy, p.count+1));
              }
            }
          }
          max = Math.max(count, max);
        }
      }
    }
    System.out.println(max);
  }

  public static class Point {

    int x;
    int y;
    int count;

    public Point(int x, int y, int count) {
      this.x = x;
      this.y = y;
      this.count = count;
    }
  }
}

