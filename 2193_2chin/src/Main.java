import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {



	public static void main(String[] args) throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(inputStreamReader);

		int n = Integer.parseInt(reader.readLine());
		long[] cache = new long[n+1];

		cache[0] = 0;
		cache[1] = 1;
		for(int i = 2; i <= n; i++) {
			cache[i] = cache[i-1] + cache[i-2];
		}

		System.out.println(cache[n]);


	}


	//이전 풀이
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//
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
//
//
//		int num = sc.nextInt();
//		long sum = 0;
//
//		long[][] value = new long[num+1][2];
//
//		value[1][0] = 0;
//		value[1][1] = 1;
//
//		sum = value[1][0] + value[1][1];
//
//		for(int i = 2; i <= num; i++) {
//			value[i][0] = value[i-1][1] + value[i-1][0];
//			value[i][1] = value[i-1][0];
//
//			sum = value[i][0] + value[i][1];
//		}
//
//		System.out.println(sum);
//
//	}
}
