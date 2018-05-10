import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		  int num = sc.nextInt();
//	      int sum = 2;
//	       
//	      if(num <= 0) {
//	          System.out.println(0);
//	      } else if(num < 3) {
//	          System.out.println(1);
//	      } else {
//	          for(int i = 1; i <= num-2 ; i++) {
//	              for(int j = 0; j < 1; j++) {
//	                  sum += i;
//	              }
//	          }
//	      }
//	       
//	      System.out.println(sum);
		
		
		int num = sc.nextInt();
		long sum = 0;
		
		long[][] value = new long[num+1][2];
		
		value[1][0] = 0;
		value[1][1] = 1;
		
		sum = value[1][0] + value[1][1];
		
		for(int i = 2; i <= num; i++) {
			value[i][0] = value[i-1][1] + value[i-1][0];
			value[i][1] = value[i-1][0];
			
			sum = value[i][0] + value[i][1];
		}
		
		System.out.println(sum);
		
	}
}
