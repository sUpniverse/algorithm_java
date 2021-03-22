import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

  static int count = 0;
  static int[][] map;
  static int[][] dir = {{0,-1},{1,0},{0,1},{-1,0}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    map = new int[n][m];

    sc.nextLine();

    int r = sc.nextInt();
    int c = sc.nextInt();
    int d = sc.nextInt();


    for(int i = 0; i < n; i++) {
      sc.nextLine();
      for(int j = 0; j < m; j++) {
        map[i][j] = sc.nextInt();
      }
    }


  }

  static void findWay(int x, int y, int d) {
    if(map[x][y] == 1 || map[x][y] == 2) {
      if(map[x-dir[d][0]][y-dir[d][1]] == 1 || map[x-dir[d][0]][y-dir[d][1]] == 2) {
        x
      }
    }

    map[x][y] = 2;

    for(int i = 0; i < 4; i++) {
      findWay(x+dir[i][0],y+dir[i][1],i);
    }
  }

}
