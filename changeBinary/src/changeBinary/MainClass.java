package changeBinary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String a =  in.readLine();
		
		char[] b = a.toCharArray();
		
		StringBuilder h = new StringBuilder();
		
//		switch (b[0]) {
//		case '0':
//			h.append("0");
//			break;
//		case '1':
//			h.append("1");
//			break;
//		case '2':
//			h.append("10");
//			break;
//		case '3':
//			h.append("11");
//			break;
//		case '4':
//			h.append("100");
//			break;
//		case '5':
//			h.append("101");
//			break;
//		case '6':
//			h.append("110");
//			break;
//		case '7':
//			h.append("111");
//			break;
//		}
		
		if(b[0] == '0') {
			h.append("0");
		} else if (b[0] == '1') {
				h.append("1");
		} else if( b[0] == '2') {
				h.append("10"); 
		} else if(b[0] == '3') {
			h.append("11");
		} else if(b[0] == '4') {
			h.append("100"); 
		} else if(b[0] == '5') {
			h.append("101");
		} else if(b[0] == '6') {
			h.append("110");
		} else {
			h.append("111");
		}		
		
		
		for(int i = 1; i < b.length ; i++) {
			if(b[i] == '0') {
					h.append("000");
			} else if (b[i] == '1') {
					h.append("001");
			} else if( b[i] == '2') {
					h.append("010"); 
			} else if(b[i] == '3') {
				h.append("011");
			} else if(b[i] == '4') {
				h.append("100"); 
			} else if(b[i] == '5') {
				h.append("101");
			} else if(b[i] == '6') {
				h.append("110");
			} else {
				h.append("111");
			}		
				
		}
		
		System.out.println(h.toString());
	
	}

}
