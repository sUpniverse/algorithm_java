package ladder;

import java.util.Scanner;

public class Main {
	static int[][] map;
	static int[][] copymap;	
	static int m;
	static int n;
	static int h;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		h = sc.nextInt();
                
        map = new int[h+2][n+1];   
        copymap = new int[h+2][n+1];
        int a = 0;
        int b = 0;        
        for(int i = 0; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            map[a][b] = 1;                
            map[a][b+1] = 1;            
        } 
        
        if(findMyway()) {
            System.out.println(0);
        } else {
            System.out.println(build());     
        }       
    }
    
    public static int build() {
        int cnt = 1;
        int a = 0,b = 0,c = 0,d = 0,e = 0,f = 0;
        for(int i = -1; i <= ((n-1)*h)-2 ; i++) {
            if(i >0) {
                a = ((i -(i - ((i/n) * n))) / (n-1)) + 1;
                b = i - ((i/n) * n) ;    
            }               
            if(b >= n || b == 0 && cnt > 2)
                    continue;
            for(int j = i+1 ; j <= ((n-1)*h)-1 ; j++) {
                c = ((j -(j - ((j/n) * n))) / (n-1)) + 1;
                d = j - ((j/n) * n) ;
                
                if(d >= n || d == 0 && cnt > 1)
                    continue;
                for(int k = j+1 ; k <= ((n-1)*h); k++) {              
                   
                    e = ((k -(k - ((k/n) * n ))) / (n-1)) + 1;
                    f = k - ((k/n) * n);                 
                                          
                    if(f >= n || f == 0 )
                        continue;
                    
                    if(e >= h && f >= (n-1))
                        cnt++;   
                    
                    copy();
                    
                    System.out.println("");
                    System.out.println("i :" + i + " j :" + j + " k :" + k);
                    
                    if(cnt > 2 && b < n) {
                        map[a][b] = 1;
                        map[a][b+1] = 1; 
                        System.out.print("a :" +a + " b :" + b + " ");
                    }                 
                    
                    if(cnt > 1 && d < n) {
                        map[c][d] = 1;      
                        map[c][d+1] = 1;
                        System.out.print("c :" +c + " d :" + d +" ");
                    }
                    
                    if(f < n) {
                        map[e][f] = 1;      
                        map[e][f+1] = 1;    
                    }                 
                    
                    System.out.println("e :" +e + " f :" +f);
                    printmap();
                    
                    if(findMyway())
                        return cnt;
                    
                    dcopy();                    
                }
            }
        }
        return -1;
    }
    
    public static boolean findMyway() {
        boolean result = true;            
        for(int i = 1 ; i <= n ; i++) {
            // System.out.println(i+"번째 시작");
            int q = 1;
            int w = i;
            while(q < h) {
                if(map[q][w] ==1) {
                    if(map[q][w-1] == 1) {
                        // System.out.println("좌표"+q+ ","+w+"좌회전");
                        w--;                        
                    } else if(map[q][w+1] == 1) {
                        // System.out.println("좌표"+q+ ","+w+"우회전");
                        w++;                        
                    }
                        
                }
                q++;
                // System.out.println("현재 좌표"+w+ ","+q);
            }
            // System.out.println("결과는 :" + w);
            if(w != i) {
                result = false;
                break;               
            }                
        }          
       return result; 
    }
    
    public static void copy() {        
        for(int a = 1; a <= h ; a++) {
            for(int b = 1; b <= n ; b++) {
                copymap[a][b] = map[a][b];
            }
        }
    }  
    
     public static void dcopy() {        
        for(int a = 1; a <= h ; a++) {
            for(int b = 1; b <= n; b++) {
                map[a][b] = copymap[a][b];
            }
        }
    } 
    
    public static void printmap() {        
        for(int a = 1; a <= h ; a++) {
            for(int b = 1; b <= n; b++) {
                System.out.print(map[a][b]); 
            }
            System.out.println("");
        }
    } 

}
