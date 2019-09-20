import java.util.Scanner;

public class Main {
		
	static int[][] data;	
	static int[] gearPoint;	
	static int sum;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		data = new int[4][8];
		int num = 0;		
		int cnt = 0;
		
		for(int i = 0; i < 4; i++) {
			cnt = sc.nextInt();
			for(int j = 7; j >= 0; j--) {
				data[i][j] = cnt % 10;
				cnt = cnt / 10;
			}			
		}		
		
		num = sc.nextInt();		
		
		gearPoint = new int[4];
		
		for(int i = 0; i < num; i++) {
			int gear = sc.nextInt();
			int firstRotateDirection = sc.nextInt();			
			application(gear-1,-1,firstRotateDirection);
			application(gear-1,+1,firstRotateDirection);
		}
		
		for(int i = 0 ; i < 4 ; i++) {
			if(data[i][gearPoint[i]] == 1) {				
				if(i == 0)
					sum += 1;
				else
					sum += (i*2);			
			}
			
		}	
		
		for (int i = 0; i < 4; i++) {
			System.out.println(data[i][gearPoint[i]] + ", ");
		}
		
		System.out.println(sum);		
	}
	
	public static void application(int point,int Movedirection, int rotateDirection) {
		if((point == 0 && Movedirection == -1) || (point == 3 && Movedirection == 1))
			return ;		
		
		// Movedirection 이 1이면 오른쪽 이다.
		if(Movedirection == 1) {
			// 오른쪽이랑 비교하니까 9시와 3시가 비교 gearPoint가 가지고 있는 12시 좌표 -3  = 9시 , +3 = 3시 
			if(data[point][(gearPoint[point] + (8 - 3)) % 8] == data[point + 1][(gearPoint[point + 1] + 3) % 8]) {
				if(rotateDirection == 1) {
					// 9시와 3시의 값이 같고, 오른쪽으로 회전하니까 오른쪽으로 돌린다. = 톱니바퀴 위치 + 1
					gearPoint[point +  1] = (gearPoint[point + 1] + 1) % 8;
					application(point+1,1,1);
				}
				else {
					// 9시와 3시의 값이 같고, 왼쪽으로 회전하니까 왼쪽으로 돌린다. = 톱니바퀴 위치 -1
					gearPoint[point + 1] = (gearPoint[point + 1] + (8 - 1)) % 8 ;
					application(point+1,1,-1);
				}
			} 
			else {
				if(rotateDirection == 1) {
					// 9시와 3시의 값이 다르고, 오른쪽으로 회전하니까 왼쪽으로 돌린다. = 톱니바퀴 위치 - 1
					gearPoint[point + 1] = (gearPoint[point + 1] + (8 - 1)) % 8 ;
					application(point+1,1,-1);
				}
				else {
					// 9시와 3시의 값이 다르고, 왼쪽으로 회전하니까 오른쪽으로 돌린다. = 톱니바퀴 위치 + 1
					gearPoint[point + 1] = (gearPoint[point + 1] + 1) % 8;
					application(point+1,1,1);
				}
			}		
		// Movedirection 이 -1이면 왼 이다.	
		} 
		else {
			// 왼쪽이랑 비교하니까 3시와 9시가 비교 gearPoint가 가지고 있는 12시 좌표 +3  = 3시 , -3 = 9시 
			if(data[point][(gearPoint[point] + 3) % 8] == data[point - 1][(gearPoint[point - 1] + (8 - 3)) % 8]) {
				if(rotateDirection == 1) {	
					gearPoint[point - 1] = (gearPoint[point - 1] + 1) % 8;
					application(point-1,-1,1);
				}
				else {					
					gearPoint[point - 1] = (gearPoint[point - 1] + (8 - 1)) % 8 ;
					application(point - 1,-1,-1);
				}
			} 
			else {
				if(rotateDirection == 1) {					
					gearPoint[point - 1] = (gearPoint[point - 1] + (8 - 1)) % 8 ;
					application(point - 1,-1,-1);
				}
				else {					
					gearPoint[point - 1] = (gearPoint[point - 1] + 1) % 8;
					application(point - 1,-1,1);
				}
			}			
		}
			
	}
	
}
