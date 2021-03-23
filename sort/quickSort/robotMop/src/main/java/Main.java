import java.util.Scanner;

public class Main {

  static int count = 0;
  static int[][] map;
  static int[][] cmap;
  static int[][] dir = {{0,-1},{1,0},{0,1},{-1,0}};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    map = new int[n][m];
    cmap = new int[n][m];

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


    findWay(r,c,d);

    System.out.println(count);


  }

  static void findWay(int x, int y, int d) {

    if(map[x][y] == 0) {
      map[x][y] = 2;
      count++;
      cmap[x][y] = count;
    }

    int dr = d;
    for(int i = 0; i < 4; i++) {
      dr = (dr + 3) % 4;
      int dx = x + dir[dr][0];
      int dy = y + dir[dr][1];
      if(map[dx][dy] == 0) {
        findWay(dx,dy, dr);
        return;
      }
    }

    int bx = x - dir[d][0];
    int by = y - dir[d][1];
    if(map[bx][by] != 1) {
      findWay(bx, by, d);
    }
    return;
  }
}
