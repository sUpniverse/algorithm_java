import java.util.LinkedList;
import java.util.Queue;

public class test4 {

    static int[][] head = {{0,-1,-1,0},{-1,0,0,1},{0,1,1,0},{1,0,0,-1}};

    public static void main(String[] args) {
        solution(new int[][]{{0, 1, 0, 1}, {0, 1, 0, 0}, {0, 0, 0, 0}, {1, 0, 1, 0}});
    }

    static int solution(int[][] maze) {
        Queue<Route> queue = new LinkedList<>();
        int answer = 0;

        queue.add(new Route(0,0,2,0));
        while (!queue.isEmpty()) {
            Route route = queue.poll();
            if(route.x == maze.length-1 &&  route.y == maze[0].length-1) {
                route.count = answer;
            }
            if(route.x+head[route.head][0] >= 0 && route.x+head[route.head][0] < maze.length -1 && route.y+head[route.head][1] >= 0 && route.y+head[route.head][1] < maze[0].length -1) {
                if(maze[route.x+head[route.head][0]][route.y+head[route.head][1]] == 1) {
                    queue.add(new Route(route.x + head[route.head][2], route.y + head[route.head][3], route.head, route.count + 1));
                } else {
                    int now = route.head;
                    if(route.head-1 < 0) now += 4;
                    queue.add(new Route(route.x + head[route.head][0], route.y + head[route.head][1], now, route.count + 1));
                }
            } else {
                int now = route.head;
                if(route.head-1 < 0) now += 4;
                queue.add(new Route(route.x, route.y, now, route.count + 1));
            }
        }

        return answer;
    }

    static class Route {
        int x;
        int y;
        int head;
        int count;

        public Route(int x, int y, int head, int count) {
            this.x = x;
            this.y = y;
            this.head = head;
            this.count = count;
        }
    }


}
