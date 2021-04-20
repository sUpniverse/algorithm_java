import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  private static int[] ax = {-1,0,1,0};
  private static int[] ay = {0,-1,0,1};
  private static int n;
  private static int[][] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    map = new int[n][n];

    for(int i = 0; i < n; i++) {
      String[] split = br.readLine().split(" ");
      for(int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(split[j]);
      }
    }

    int T = 0;
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        if(map[i][j] != 9 && map[i][j] > 2 && map[i][j] != 0 )
          T++;
      }
    }

    int time = 0;
    Queue<Pair> queue = new LinkedList<>();

    while (!queue.isEmpty()) {

    }

  }

  public static int find(int x, int y, int now) {

  }

  static class Pair {
    int x;
    int y;
  }

}
