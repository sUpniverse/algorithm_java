import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		 int n = Integer.parseInt(sc.next());
		 
		 int size = (int) Math.pow(2, n-1);
		 
		 System.out.println(size);
	}
	
}
