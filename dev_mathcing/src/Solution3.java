public class Solution3 {

    static boolean[] visited;
    static boolean[] candle;

    public static void main(String[] args) {
        int n = 10;
        int[][] ints = {{1, 5}, {2, 7}, {4, 8}, {3, 6}};
        int solution = solution(n, ints);
        System.out.println(solution);
    }

    public static int solution(int n, int[][] groups) {
        candle = new boolean[n];
        visited = new boolean[groups.length];

        int dfs = dfs(0, groups, 0);

        return dfs;
    }

    public static int dfs(int count, int[][] groups, int index) {
        if(getRemainCount() == 0 || count > candle.length) {
            return count;
        }

        int remainCount = getRemainCount();
        int best = count + remainCount;
        for(int i = index; i < groups.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                boolean[] copy = copyCandle(candle);
                setCandle(groups[i][0],groups[i][1]);
                int newCount = dfs(count+1, groups, i+1);
                visited[i] = false;
                candle = copyCandle(copy);
                best = Math.min(newCount, best);
            }
        }

        return best;
    }

    public static int getRemainCount() {
        int count = 0;
        for(int i = 1; i < candle.length; i++) {
            if(!candle[i]) count++;
        }
        return count;
    }

    public static void setCandle(int start, int end) {
        for(int i = start; i < end; i++) {
            if(!candle[i])
                candle[i] = true;
        }
    }

    public static boolean[] copyCandle(boolean[] a) {
        boolean[] copy = new boolean[a.length];
        for(int i = 0; i < a.length; i++) {
            copy[i] = a[i];
        }
        return copy;
    }
}
