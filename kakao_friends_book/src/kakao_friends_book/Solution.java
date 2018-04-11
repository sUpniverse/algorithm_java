package kakao_friends_book;

public class Solution {
	
	int M;
	int N;
	
	public int[] solution(int m, int n, int[][] picture) {
	      int numberOfArea = 0;
	      int maxSizeOfOneArea = 0;
	      int temp = 0;
	      M = m;
	      N = n;
	      
	      for(int i=0; i < m; i++) {
	          for(int j=0; j <n; j++) {
	              if(picture[i][j] != 0) {
	                  numberOfArea++;
	                  temp = search(i,j,picture,picture[i][j]);
	                  if(maxSizeOfOneArea < temp)
	                      maxSizeOfOneArea = temp;
	              }
	          }
	      }
	      
	      
	      int[] answer = new int[2];
	      answer[0] = numberOfArea;
	      answer[1] = maxSizeOfOneArea;
	      return answer;
	  }
	    
	    public int search(int a, int b, int[][] picture, int num) {
	        int count = 0;
	        if(a < 0 || a >= M || b <0 || b >= N) {
	            return 0;
	        }        
	        else if(picture[a][b] == num) {
	            picture[a][b] = 0;            
	            return 1 + search(a-1,b,picture,num) + search(a+1,b,picture,num) + search(a,b-1,picture,num)
	            + search(a,b+1,picture,num);
	        } else {            
	            return 0;
	        }
	    }       
	    
	    public static void main(String[] args) {
			Solution sol = new Solution();
			int[][] map = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};	
			int[] an = sol.solution(6, 4, map);
			System.out.println(an[0]+","+an[1]);
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 4 ; j++)
					System.out.print(map[i][j]);
				System.out.println();
			}
		}
}
