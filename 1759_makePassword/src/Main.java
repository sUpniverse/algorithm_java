import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static char[] wordList;
    static char[] wordArange;
    static char[] list = {'a','e','i','o','u'};
	static int n;
    static int m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
        m = sc.nextInt();
        wordList = new char[m];   
        wordArange = new char[n];     
        
        for(int i = 0; i < m ; i++) {
            wordList[i] = sc.next().charAt(0);
        } 
        
        Arrays.sort(wordList);          
        arange(0,0);
    }
    
    public static void arange(int pic, int search) {
        if(pic == n) {
            int consNum = 0;
            int volNum = 0;
            for(int i = 0; i < n; i++) {                
                for(int j =0; j < list.length; j++) {
                    if(wordArange[i] == list[j])
                        volNum++;                                             
                }  
            }    
            consNum = n - volNum;
            if(consNum < 2 || volNum < 1)
                return ;
            printchar();
            return;
        }
        
        if(pic > n || search >= m){
            return ;
        }
        
        if(pic < m) {
            wordArange[pic] = wordList[search];
            arange(pic+1,search+1);    
        }
        arange(pic,search+1);
    }
    
    public static void printchar() {
        for(int i= 0 ; i < n ; i++) {
            System.out.print(wordArange[i]);
        }
        System.out.println("");
    }
}