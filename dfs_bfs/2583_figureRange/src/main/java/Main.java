import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static int[][] map;
  static int M;
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    String[] split = s.split(" ");
    M = Integer.parseInt(split[0]);
    N = Integer.parseInt(split[1]);
    int K = Integer.parseInt(split[2]);

    map = new int[M][N];

    for(int i = 0; i < K; i++) {
      String line = br.readLine();
      String[] num = line.split(" ");
      int x1 = Integer.parseInt(num[0]);
      int y1 = Integer.parseInt(num[1]);
      int x2 = Integer.parseInt(num[2]);
      int y2 = Integer.parseInt(num[3]);

      for(int k = x1; k < x2; k++) {
        for(int l = y1; l < y2; l++) {
          map[l][k] = 1;
        }
      }

    }

    int count = 0;

    List<Integer> list = new ArrayList<>();

    for(int i = 0; i < M; i++) {
      for(int j = 0; j < N; j++) {
        if(map[i][j] == 0) {
          count++;
           list.add(dfs(i,j));
        }
      }
    }

    System.out.println(count);
    Collections.sort(list);
    for(int a: list) {
      System.out.print(a+" ");
    }
  }

  private static int dfs(int x, int y) {
    if(x < 0 || x >= M || y < 0 || y >= N)
      return 0;
    if(map[x][y] == 1)
      return 0;

     map[x][y] = 1;
     return 1 + dfs(x+1, y) + dfs(x-1, y) + dfs(x, y+1) + dfs(x, y-1);
  }

}
