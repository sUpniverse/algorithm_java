import java.util.Scanner;

public class Main {    
    static int[] arr ;
    static int[] lotto;
    static int temp = 0;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = -1;        
                
        do {
            n = sc.nextInt();
            temp = n;
            arr = new int[n];
            lotto = new int[6];
            int a = 0;    
            while(n!=0) {
                arr[a++] = sc.nextInt();    
                n--;
            }     
            pair(0,0);
            System.out.println("");
        } while(temp != 0);        
        
    }       
    public static void pair(int now, int search) {
        if(now >= 6) {           
            printarr(lotto);
            return;
        }       
        
        if(search > (temp-1)) {            
            return;
        }            
        
        if(now < 6) {
            lotto[now] = arr[search];            
            pair(now+1,search+1);              
        }
        pair(now,search+1);       
    }    
    
    public static void printarr(int[] lotto) {
        for(int i = 0; i < lotto.length ; i++) {
            System.out.print(lotto[i] +" ");
        }
        System.out.println();
    }
}
