import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Point> points = new ArrayList<>();


        StringBuilder st = new StringBuilder();
        for(int i = 0 ; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int i1 = Integer.parseInt(s[0]);
            int i2 = Integer.parseInt(s[1]);
            Point point = new Point(i1, i2);
            points.add(point);
        }

        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.x > o2.x) {
                    return 1;
                } else if (o1.x < o2.x) {
                    return -1;
                } else {
                    if(o1.y > o2.y) {
                        return 1;
                    } else if(o1.y < o2.y) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });

        for(Point point : points) {
            st.append(point.x).append(" ").append(point.y).append("\n");
        }

        System.out.println(st);

    }

    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

}
