import java.util.Scanner;

public class Main {
	public static int[] hole;
	public static int[]answer;
	public static int flag = 0;
	
	public static void main(String[] args) {
		
		hole = new int[9]; 
		answer = new int[7];
		Scanner sc = new Scanner(System.in);
		int num = 100;
		
		for(int i = 0; i < 9; i++) {
			hole[i] = sc.nextInt();
		}
		
		int tmp = 0;
		for(int i = 0; i < 9; i++) {	
			for(int j = i; j < 9; j++) {
				if(hole[i] > hole[j]) {
					tmp = hole[i];
					hole[i] = hole[j];
					hole[j] = tmp;
				}
			}			
		}
		
		sum(0,0);
		
		for(int i = 0; i <7; i++) {
			System.out.println(answer[i]+" ");
		}
	}
	
	public static void sum(int now,int front) {
		int sum = 0;
		for(int i = 0 ; i < now; i++) {
			sum += answer[i];
		}		
		
		if(flag == 1) 
			return ;
		
		if(now == 6) {			
			answer[now] = hole[front];
			sum += answer[now];
			if(sum == 100)
				flag = 1;
			else
				answer[now] = 0;
			return;
		}
		
		if(sum > 100 || front > 7) {
			return ;
		}
		
		if(now < 6) {
			answer[now] = hole[front];
			sum(now+1,front+1);
		}		
		sum(now,front+1);				
	}
}
