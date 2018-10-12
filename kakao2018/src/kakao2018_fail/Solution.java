package kakao2018_fail;

public class Solution {
	
	public static void main(String[] args) {
		int n = 7;
		int[] stages = {2,1,2,6,2,4,3,3};
		
		
		int result[] = solution(n,stages);
		
		System.out.print("[");
		for(int i = 0 ; i < n; i ++) {			
			System.out.print(result[i]+",");
		}
		System.out.print("]");
	}
	
	public static int[] solution(int N, int[] stages) {
        int[] cnt = new int[N+1];
        double cnt_num =  stages.length;
        double [] fail_chance = new double[N+1];
        int index = 0;
        double max = 0;
        int num = -1;
        
        for(int i = 0; i < cnt_num; i++) {  
        	cnt[stages[i]-1]++;
        	
        }
        
        for(int i = 0; i < N; i++) {
        	if(cnt_num == 0) {
        		fail_chance[i] = 0;
        	} else {
        		fail_chance[i] = cnt[i] / cnt_num;
        	}        	
        	cnt_num -= cnt[i];       	
        }
                
        int[] answer = new int[N];       
        
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
        		if(max < fail_chance[j]) {
        			max = fail_chance[j];
        			index = j;        			
        		}
        	}        	
        	if(num != index) {
        		answer[i] = index+1;
        		num = index;
        	}
        	else
        		answer[i] = 0;
        	max = -1;
        	fail_chance[index] = -1;      	
        }        
        
        return answer;
    }
}
