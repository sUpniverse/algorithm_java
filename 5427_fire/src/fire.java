import java.util.Scanner;

public class fire {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a;
		int b;
		
		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T; test_case++ ) {
			a  = sc.nextInt();
			b = sc.nextInt();
			
			char map[][] = new char[a][b];
			
			int x = 0;
			int y = 0;
			int z = 0;
			int r = 0;
			
//			for(int i = 0; i < a ; i++) {
//				for(int j = 0; j <b; j++) {
//					map[a][b] = sc.next().charAt(0);
//					if(map[a][b] == '@') {
//						x = i;
//						y = j;
//					} else if(map[a][b] == '*') {
//						z = i;
//						r = j;
//					}
//				}					
//			}
			
			for(int i = 0; i < a ; i++) {
				map[a] = sc.nextLine().toCharArray();
			}
			while(true) {
			
				
				
			}
		}		
	}
	
	public void spread(int a, int b, int z, int r, char map[][]) {
		   for(int i = 0 ; i < a; i++ ) {
			   for(int j = 0 ; j < b; j++) {
				   	if()
			   }
		   }	
		
	}
}
