import java.util.Scanner;

public class Main {
	static int[]map;
	static int n;    
    static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();        
        map = new int[n];
        
        queen(0);
        System.out.println(cnt);
    }
    
   public static void queen(int level) {
         
        if(level == n) {            
            cnt++;
            return;
        }   
        
        for(int i = 0; i < n; i++) {
            map[level] = i;     
            if(isPossilbe(level)) {
                queen(level+1);                
            }
        }
    }
    // 1. 직접 가로세로 대각선을 센것이 아니 해당 세로의 배열에 가로의 몇번째에 해당 값이 있는지 넣어놈
    // 2. 대각선의 위치에 있는지 확인하기 위해
    public static boolean isPossilbe(int level) {
        for(int i = 0; i < level; i++) {            
         if(map[level] == map[i] || Math.abs(level - i) == Math.abs(map[level] - map[i]))
             return false;
        }        
        return true;       
    }  
}



/*
public class Main {
	static int[][] map;
	static int n;    
    static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();        
        map = new int[n][n];
        
        queen(0,0);
        System.out.println(cnt);
    }
    
    public static void queen(int pic,int search) {
         
        if(pic == n) {            
            cnt++;
            return ; 
        }      
        
        if(search >= n*n)
            return ;       
        
        if(pic < n) {
            if(map[search/n][search%n] == 0) {
                int[][] mapcp = new int[n][n];
                copy(mapcp);
                map[search/n][search%n] = 1;
                paint(search/n,search%n);
                queen(pic+1,search+1);
                decopy(mapcp);
            } 
        }
        queen(pic,search+1);
        
    }
    
    public static void paint(int x, int y)   {
        int i = 0;
        while(i < n) {
            if(x >= 0 && x < n && y+i >= 0 && y+i < n && map[x][y+i] == 0 )
                map[x][y+i] = 2;
            if(x >= 0 && x < n && y-i >= 0 && y-i < n && map[x][y-i] == 0)
                map[x][y-i] = 2;
            if(x+i >= 0 && x+i < n && y >= 0 && y < n && map[x+i][y] == 0)
                map[x+i][y] = 2;
            if(x-i >= 0 && x-i < n && y >= 0 && y < n && map[x-i][y] == 0)
                map[x-i][y] = 2;
            if(x+i >= 0 && x+i < n && y+i >= 0 && y+i < n && map[x+i][y+i] == 0)
                map[x+i][y+i] = 2;
            if(x+i >= 0 && x+i < n && y-i >= 0 && y-i < n && map[x+i][y-i] == 0)
                map[x+i][y-i] = 2;
            if(x-i >= 0 && x-i < n && y+i >= 0 && y+i < n && map[x-i][y+i] == 0)
                map[x-i][y+i] = 2;
            if(x-i >= 0 && x-i < n && y-i >= 0 && y-i < n && map[x-i][y-i] == 0)
                map[x-i][y-i] = 2;
            i++;
        }
    }
    
    public static void copy(int[][] mapcp) {
        for(int i = 0; i < n ; i++) {
            for(int j = 0; j < n; j++)
                mapcp[i][j] = map[i][j];
        }
    }
    
    public static void decopy(int[][] mapcp) {
        for(int i = 0; i < n ; i++) {
            for(int j = 0; j < n; j++)
                map[i][j] = mapcp[i][j];
        }
    }        
    
}

*/
