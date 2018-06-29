import java.util.Scanner;

public class Main {    
    static int[] arr ;
    static int[] queue ;
    static int n;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int test_case = 0;        
        n = 0;
        int m = 0;
        int value = 0;
        
        test_case = sc.nextInt();
        while(test_case != 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            
            arr = new int[n];
            queue = new int[n];    
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();          
           
            print(0,0);
            
            System.out.println(queue[m]);    
            
             for(int i = 0; i < n; i++)
                 System.out.print(queue[i]);
            
            test_case--;
        }         
        
    }       
    public static void print(int now, int index) {      
        if(index >= n)
            index = index % n ;
        
        if(now >= n)
            return ;
        
        int a = arr[index];
        int b = 0;
        int tmp = index;
        for(int i = index; i < n; i++ ) {
            if(a < arr[i]) {                
                index = i;
                a = arr[i];                
            }       
            if(b >= 1 && i%(n-1) >= tmp)
                break;
            
            if(i == n-1){
                i = 0;
                b++;
            }          
            
        } 
        queue[index] = now+1;
        arr[index] = -1;
        
        print(now+1,index+1);
    }
    
  
}
