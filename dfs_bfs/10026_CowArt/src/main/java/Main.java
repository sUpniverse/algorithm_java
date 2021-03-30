import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int N;
  static int[] dx = {-1,0,1,0};
  static int[] dy = {0,-1,0,1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String num = br.readLine();
    N = Integer.parseInt(num);

    char[][] map = new char[N][N];
    char[][] copyMap = new char[N][N];

    for(int i = 0; i < N; i++) {
      String s = br.readLine();
      for(int j = 0; j < N; j++) {
        char c = s.charAt(j);
        map[i][j] = c;
        copyMap[i][j] = c;
      }
    }

    int count = 0;
    int nCount = 0;

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
        if(map[i][j] != 'N') {
          dfs(i, j, map[i][j], map, false);
          count++;
        }
        if(copyMap[i][j] != 'N') {
          dfs(i, j, copyMap[i][j], copyMap, true);
          nCount++;
        }
      }
    }

    System.out.println(count + " " + nCount);
  }

  public static void dfs(int x, int y, char c, char[][] newMap, boolean isGreen) {
    newMap[x][y] = 'N';
    for(int i = 0; i < 4; i++) {
      int ax = x + dx[i];
      int ay = y + dy[i];
      if(ax < 0 || ax >= N || ay < 0 || ay >= N)
        continue;

      if(newMap[ax][ay] == c) {
        dfs(ax, ay, c, newMap, isGreen);
      } else if(isGreen && (c == 'R' || c == 'G')){
        if(newMap[ax][ay] == 'R' || newMap[ax][ay] == 'G')
          dfs(ax, ay, c, newMap, isGreen);
      }
    }
  }

//  public static void ndfs(int x, int y, char c, char[][] newMap) {
//    newMap[x][y] = 'N';
//    for(int i = 0; i < 4; i++) {
//      int ax = x + dx[i];
//      int ay = y + dy[i];
//      if(ax < 0 || ax >= N || ay < 0 || ay >= N)
//        continue;
//
//      if(newMap[ax][ay] == c) {
//        ndfs(ax, ay, c, newMap);
//      } else if(c == 'R' || c == 'G'){
//        if(newMap[ax][ay] == 'R' || newMap[ax][ay] == 'G')
//          ndfs(ax, ay, c, newMap);
//      }
//    }
//  }
}
