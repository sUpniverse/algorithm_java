import java.util.Arrays;

public class Friends4Block {

    static char map[][];
    static boolean cache[][];
    static int[] ax = {0,1,0,1};
    static int[] ay = {0,0,1,1};

    public static void main(String[] args) {
        int solution = solution(6, 2, new String[]{"AA", "AA", "CC", "AA", "AA", "DD"});
        System.out.println(solution);
    }

    static int solution(int m, int n, String[] board) {
        int answer = 0;

        map = new char[m][n];
        cache = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        while (true) {
            int count = 0;
            for(int i = 0; i < m-1; i++) {
                for(int j = 0; j < n-1; j++) {
                    if(map[i][j] != '0' && map[i][j] == map[i][j+1] && map[i][j] == map[i+1][j] && map[i][j] == map[i+1][j+1]) {
                        for(int k = 0; k < 4; k++) {
                            if(!cache[i+ax[k]][j+ay[k]])
                                count++;
                        }
                        cache[i][j] = cache[i][j+1] = cache[i+1][j] = cache[i+1][j+1] = true;
                    }
                }
            }

            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(cache[i][j]) {
                        map[i][j] = '0';
                    }
                }
            }

            for(int i = m-1; i > 0 ; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (map[i][j] == '0') {
                        int k = 1;
                        while (i - k > 0 && map[i - k][j] == '0') k++;
                        if (map[i - k][j] != '0') {
                            map[i][j] = map[i - k][j];
                            map[i - k][j] = '0';
                        }
                    }
                }
            }

            for(int i = 0; i < m; i++) {
                Arrays.fill(cache[i], false);
            }

            if(count == 0) break;
            answer += count;

        }



        return answer;
    }


}
