import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  private static int[] ax = {-1,0,1,0};
  private static int[] ay = {0,-1,0,1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[][] map = new int[n][n];

    for(int i = 0; i < n; i++) {
      String[] split = br.readLine().split(" ");
      for(int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(split[j]);
      }
    }

    Pair pair = null;
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        if(map[i][j] == 9) {
          pair = new Pair(i, j, 2, 0, 0);
          map[i][j] = 0;
        }
      }
    }

    int[][] visited = new int[n][n];

    int time = 0;
    Queue<Pair> queue = new LinkedList<>();

    queue.add(pair);

    while (!queue.isEmpty()) {
      Pair remove = queue.remove();
      int count = remove.count;
      int size = remove.size;
      for(int i = 0; i < 4; i++) {
        int dx = remove.x + ax[i];
        int dy = remove.y + ay[i];
        if(dx < 0 || dx >= n || dy < 0 || dy >= n)
          continue;
        if(map[dx][dy] > remove.size || visited[dx][dy] == 1)
          continue;

        if(map[dx][dy] != 0 && map[dx][dy] < size) {
          count++;
          if(count == size) {
            size++;
            count = 0;
          }
          map[dx][dy] = 0;
          Arrays.fill(visited, 0);
          queue.clear();
          time = remove.distance+1;
          visited[dx][dy] = 1;
          queue.add(new Pair(dx, dy, size, count, remove.distance+1));
          break;
        }

        visited[dx][dy] = 1;
        queue.add(new Pair(dx, dy, size, count, remove.distance+1));
      }
    }

    System.out.println(time);

  }


  static class Pair {
    int x;
    int y;
    int size;
    int count;
    int distance;

    public Pair(int x, int y, int size, int count, int distance) {
      this.x = x;
      this.y = y;
      this.size = size;
      this.count = count;
      this.distance = distance;
    }
  }

}
