
public class MainClass {
	public static void main(String[] args) {
		
		double N = 3;
		
		N--;
		System.out.println((int)pill(N,(int)N));
		
	}
	
	public static double pill (double n, int r) {
		
		if(n == 0) {
			return 1;
		} else if(n % 1 == 0.5 && r == 0) {
			return pill(n-0.5,(int)r--);
		} else if(n % 1 == 0 &&)
		} else {			
			return pill(n-0.5,0) + pill(n-0.5,(int)r--);
		}
		
	}
	
	
}
