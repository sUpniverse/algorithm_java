import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
    boolean eat = false;
    int maxDistance = 0;

    int time = 0;
    Queue<Pair> queue = new LinkedList<>();
    Queue<Pair> priority = new PriorityQueue<>();


    queue.add(pair);

    while (true) {
      while (!queue.isEmpty()) {
        Pair remove = queue.remove();
        int count = remove.count;
        int size = remove.size;
        remove.distance++;
        for(int i = 0; i < 4; i++) {
          int dx = remove.x + ax[i];
          int dy = remove.y + ay[i];
          if(dx < 0 || dx >= n || dy < 0 || dy >= n)
            continue;
          if(map[dx][dy] > remove.size || visited[dx][dy] == 1)
            continue;
          if(eat && remove.distance > maxDistance)
            continue;

          if(map[dx][dy] != 0 && map[dx][dy] < size) {

            //처음으로 먼저 먹은 물고기의 거리를 저장해 놓고
            // 똑같은 거리의 물고기들까지만 순회한 뒤에 가장 우선순위가 높은 물고기를 먹는다.
            Pair fish = new Pair(dx, dy, size, count, remove.distance);
            if(!priority.contains(fish))
              priority.add(fish);
            if(!eat) {
              eat = true;
              maxDistance = remove.distance;
            }
          }

          visited[dx][dy] = 1;
          queue.add(new Pair(dx, dy, size, count, remove.distance));
        }
       }
      if(!priority.isEmpty()) {
        Pair first = priority.remove();
        first.count++;
        if(first.count == first.size) {
          first.size++;
          first.count = 0;
        }
        visited = new int[n][n];
        map[first.x][first.y] = 0;
        time+= first.distance;
        first.distance = 0;
        queue.clear();
        priority.clear();
        queue.add(first);
        eat = false;
      } else {
        System.out.println(time);
        return;
      }
      }
    }

  static class Pair implements Comparable<Pair>{
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

    @Override
    public int compareTo(Pair o) {
      if(this.distance == o.distance) {
        if(this.x == o.x) {
          return this.y - o.y;
        }
        return this.x - o.x;
      }
      return this.distance - o.distance;
    }
  }
}



