package enter;

import java.util.Queue;

public class Solution {
	public static void main(String[] args) {
		String[] st = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		enter(st);
	}
	
	public static String[] enter(String[] record) {
		String[][] query = new String[record.length][3];
		String[][] id = new String[2][2];
		
		for(int i = 0; i < record.length; i++) {
        	query[i] = record[i].split(" ");        	
        }
		
		String[] message = new String[record.length];
		
		for(int i = 0 ; i < record.length; i++) {
			if(query[i][0].equals("Enter")) {
				message[i] = "님이 들어왔습니다";				
			} else if(query[i][0].equals("Leave")) {
				message[i] = "님이 나갔습니다";
			}
		}
		 
		String[] answer = {};
        return answer;
    }
}
