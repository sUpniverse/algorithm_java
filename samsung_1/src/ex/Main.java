package ex;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Stack<Integer> st = new Stack<>();
		st.add(sc.nextInt());
		java.util.Iterator<Integer> iter;
		
		iter = st.iterator();
		
		
		while(iter.hasNext()) {
			int a = iter.next();		
			System.out.println(a);
		}		
	}
	
}
