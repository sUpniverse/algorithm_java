package kakao_heaven;

public class Solution {
	
	static int[][] H;
	static int[][] V;
	
	 public	static int solution(int m, int n, int[][] cityMap) {
	      int answer = 0;      
	      H = new int [m][n];
	      V = new int [m][n];
	    
	      answer = search(m,n,cityMap);
	      return answer;
	  }
	    public static int search(int m, int n, int[][]cityMap) { 
	        for(int i = 0 ; i < m ; i++) {
	            for(int j = 0; j <n ; j++) {
	                if(cityMap[i][j] == 0) {
	                    if(i == 0 && j == 0) {
	                        H[i][j] = 1;
	                        V[i][j] = 1;
	                    } else if(i == 0) {
	                    		H[i][j] = H[i][j-1];
	                    		V[i][j] = H[i][j-1];
	                    } else if (j == 0) {
	                         H[i][j] = V[i-1][j];
		                     V[i][j] = V[i-1][j];
	                    } else {
	                        H[i][j] = H[i][j-1] + V[i-1][j];
	                        V[i][j] = H[i][j-1] + V[i-1][j];
	                    }
	                } else if(cityMap[i][j] == 1) {
	                    H[i][j] = 0;
	                    V[i][j] = 0;
	                } else if(cityMap[i][j] == 2) {
	                    if(i == 0) {
	                    		H[i][j] = H[i][j-1];
	                    		V[i][j] = 0;
	                    } else if(j == 0) {
	                    		H[i][j] = 0;
	                         V[i][j] = V[i-1][j];	                    		
	                    } else {
	                        H[i][j] = H[i][j-1];
	                        V[i][j] = V[i-1][j];    
	                    }
	                }
	            }
	        }
	        return 0;
	    }
	    public static void main(String[] args) {
	    		int[][]map = {{0,2,0,0,0,2}, {0,0,2,0,1,0}, {1,0,0,2,2,0}};
	    		solution(3, 6, map);
	    		System.out.println(V[2][5]);
	    		//int[][]map = {{0,0,0},{0,0,0}, {0,0,0}};
	    		//solution(3, 3, map);
	    		//System.out.println(H[2][2]);
	    		for(int i=0; i < 3 ; i++) {
	    			for(int j=0; j < 6 ; j++) {
	    				System.out.print(H[i][j]);
	    			}
	    			System.out.println("");
	    		}
	    		System.out.println();
	    		for(int i=0; i < 3 ; i++) {
	    			for(int j=0; j < 6 ; j++) {
	    				System.out.print(V[i][j]);
	    			}
	    			System.out.println("");
	    		}
	    		System.out.println();
	    		for(int i=0; i < 3 ; i++) {
	    			for(int j=0; j < 6 ; j++) {
	    				System.out.print(map[i][j]);
	    			}
	    			System.out.println("");
	    		}
			
		}
	    
}
