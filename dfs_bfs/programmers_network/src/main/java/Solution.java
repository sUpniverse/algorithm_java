public class Solution {

    public static void main(String[] args) {

//        int[][]computers = {{1,1,0},
//                            {1,1,0},
//                            {0,0,1}
//                            };
        int[][]computers = {{1,1,0},
                            {1,1,1},
                             {0,1,1}
                            };
        int n = 3;

        System.out.println(solution(n,computers));
    }


    static boolean[] check;
    static int solution(int n, int[][] computers) {
        int answer = 0;

        check = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!check[i]) {
                answer++;
                dfs(i,n,check,computers);
            }
        }

        return answer;
    }

    static void dfs(int x, int n,boolean[] check,int[][] computers) {
        check[x] = true;
        for(int i = 0; i < n; i++) {
            if(computers[x][i] == 1 && !check[i]) {
                dfs(i, n, check, computers);
            }
        }
    }
}
