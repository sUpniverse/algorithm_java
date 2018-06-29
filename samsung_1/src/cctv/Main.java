package cctv;

import java.util.Scanner;

public class Main {
    static int[][] map;
    static int[][] copymap;
    static int[][] cctv;
    static int m;
    static int n;
    static int count;
    static int sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m =0;
        n =0;
        
        m = sc.nextInt();
        n = sc.nextInt();
        map = new int[m][n];        
        cctv = new int[8][2];
        
        int value = 0;
        count = 0;
        sum = Integer.MAX_VALUE;
        
        for(int i = 0; i <m ; i++) {
            for(int j = 0; j <n ; j++) {                
                value = sc.nextInt();
                map[i][j] = value;
                if(value > 0 && value < 6) {
                    cctv[count][0] = i;
                    cctv[count][1] = j;
                    count++;
                }
            }
        }        
        watch(0);
        System.out.println(sum);
    }
    
    public static void watch(int pic) {
        if(pic >= count) {
           counting(pic);
            return ;  
        }           
        int[][] copymap = new int[m][n];
         for(int i = 0; i <m ; i++) {
            for(int j = 0; j <n ; j++)            
                copymap[i][j] = map[i][j];
            }
        int val = map[cctv[pic][0]][cctv[pic][1]];
        if(val == 1) {
            paint(cctv[pic][0],cctv[pic][1],1,9);
            watch(pic+1); 
            clear(copymap);
            paint(cctv[pic][0],cctv[pic][1],2,9);
            watch(pic+1);  
            clear(copymap);
            paint(cctv[pic][0],cctv[pic][1],3,9);
            watch(pic+1);  
            clear(copymap);
            paint(cctv[pic][0],cctv[pic][1],4,9);
            watch(pic+1);  
            clear(copymap);
        }
        if(val == 2) {
            paint(cctv[pic][0],cctv[pic][1],1,9);
            paint(cctv[pic][0],cctv[pic][1],2,9);
            watch(pic+1);          
            clear(copymap);
            paint(cctv[pic][0],cctv[pic][1],3,9);
            paint(cctv[pic][0],cctv[pic][1],4,9);
            watch(pic+1);  
            clear(copymap);
        }
        if(val == 3) {
            paint(cctv[pic][0],cctv[pic][1],1,9);
            paint(cctv[pic][0],cctv[pic][1],3,9);
            watch(pic+1);    
            clear(copymap);
            paint(cctv[pic][0],cctv[pic][1],1,9);
            paint(cctv[pic][0],cctv[pic][1],4,9);
            watch(pic+1);  
            clear(copymap);
            paint(cctv[pic][0],cctv[pic][1],2,9);
            paint(cctv[pic][0],cctv[pic][1],3,9);
            watch(pic+1);  
            clear(copymap);
            paint(cctv[pic][0],cctv[pic][1],2,9);
            paint(cctv[pic][0],cctv[pic][1],4,9);
            watch(pic+1);  
            clear(copymap);
        }
        if(val == 4) {
            paint(cctv[pic][0],cctv[pic][1],1,9);
            paint(cctv[pic][0],cctv[pic][1],4,9);
            paint(cctv[pic][0],cctv[pic][1],2,9);
            watch(pic+1);       
            clear(copymap);
            paint(cctv[pic][0],cctv[pic][1],4,9);
            paint(cctv[pic][0],cctv[pic][1],2,9);
            paint(cctv[pic][0],cctv[pic][1],3,9);
            watch(pic+1);  
            clear(copymap);
            paint(cctv[pic][0],cctv[pic][1],2,9);
            paint(cctv[pic][0],cctv[pic][1],3,9);
            paint(cctv[pic][0],cctv[pic][1],1,9);
            watch(pic+1);  
            clear(copymap);
            paint(cctv[pic][0],cctv[pic][1],3,9);
            paint(cctv[pic][0],cctv[pic][1],1,9);
            paint(cctv[pic][0],cctv[pic][1],4,9);
            watch(pic+1);  
            clear(copymap);
        }
        if(val == 5) {
            paint(cctv[pic][0],cctv[pic][1],1,9);
            paint(cctv[pic][0],cctv[pic][1],2,9);
            paint(cctv[pic][0],cctv[pic][1],3,9);
            paint(cctv[pic][0],cctv[pic][1],4,9);
            watch(pic+1);   
           clear(copymap);
        }        
    }
    
    static void paint(int x, int y, int dir, int col) {
        //왼쪽
        if(dir == 1) {
             while(true) {
                if(x < 0 || x >= m || y < 0 || y >= n || map[x][y] == 6) 
                    break;                 
                if(map[x][y] > 0 && map[x][y] < 10) {
                     x--;
                     continue;
                }                 
                 map[x][y] = col;
                 x--;                
             }
            return;
        }
            
        //오른쪽
        if(dir == 2) {
            while(true) {
                if(x < 0 || x >= m || y < 0 || y >= n || map[x][y] == 6) 
                    break;                 
                if(map[x][y] > 0 && map[x][y] < 10) {
                    x++;
                    continue;
                }                     
                map[x][y] = col;
                x++;                
             }
            return;
        }            
        //위
        if(dir == 3) {
            while(true) {
                if(x < 0 || x >= m || y < 0 || y >= n || map[x][y] == 6) 
                    break;                 
                if(map[x][y] > 0 && map[x][y] < 10) {
                    y--;
                    continue;
                }
                     
                map[x][y] = col;
                y--;                
             }
            return;
        }
            
        //아래
        if(dir == 4) {
            while(true) {
                if(x < 0 || x >= m || y < 0 || y >= n || map[x][y] == 6) 
                    break;                 
                if(map[x][y] > 0 && map[x][y] < 6) {
                    y++;
                    continue;
                }                     
                map[x][y] = col;
                y++;                
             }
            return;
        }                
    }
    
    static void counting(int pic) {
        int val = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(map[i][j] == 0) {
                        val++;
                    }
                }
            }
            sum = Math.min(sum,val);
    }
        
    static void clear(int[][] copy)  {
         for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    map[i][j] = copy[i][j];
                }
         }
    }            
    
}

        
