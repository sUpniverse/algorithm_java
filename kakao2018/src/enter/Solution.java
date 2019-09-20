package enter;

import java.util.Queue;

public class Solution {
	public static void main(String[] args) {
		String[] answer = {};
		String[][] user = {};
		
		int cnt = 0;
		while(cnt == answer.length) {
			cnt++;
			
			String[] inform =  slice(answer[cnt]);
			String[] order = {"Enter","Leave","Change"};
			
			if(inform[0] == "Enter") {
				
			} else if(inform[0] == "Leave") {
				
			} else if(inform[1] == "Change") {
				
			}
			
		}
		
	}
	//로직.. (1) 문자 분리, (2) 아이디 저장 (3) 출력    
	public static String[] slice(String msg) {
		return msg.split(" ");		
	}
		
	public static void reservedMSG(int num, String msg) {
		
		System.out.println("");
	}
}
