package picnic;

import java.util.Scanner;

public class Main {
    static boolean[][] areFriends;
    static int[] dap;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = 0;
        dap = new int[n];
        
        while(n!=0) {
            int f = sc.nextInt();
            int r = sc.nextInt();        
            areFriends = new boolean[f][f] ;         
            boolean[] taken = new boolean[f]; 
            
            int a = 0;
            int b = 0;
            while(r!=0) {                
                a = sc.nextInt();
                b = sc.nextInt();
                areFriends[a][b] = true;
                areFriends[b][a] = true;                
                r--;
            }
            
            dap[w++] = countPairings(taken);
            n--;
        }
        
        for(int i = 0; i < w ; i++) {
            System.out.println(dap[i]);
        }
    }
    
    public static int countPairings(boolean[] taken) {
        int now = -1;
        for(int i = 0; i < taken.length ; i++) {
            if(!taken[i]) {
                now = i;
                break;
            }
        }
        
        if(now == -1)
            return 1;
        
        int ret = 0;
        for(int j = now + 1 ; j < taken.length ; j++) {
            if(!taken[j] && areFriends[now][j]) {
                taken[now] = true;
                taken[j] = true;
                ret += countPairings(taken);
                taken[now] = false;
                taken[j] = false;
            }            
        }
        return ret;
    }         
}
