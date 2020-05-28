import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Point> arrayList;
    static int maxSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        arrayList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arrayList.add(new Point(x,y));
        }

        arrayList.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.x > o2.x) {
                    return 1;
                } else if(o1.x == o2.x) {
                    if(o1.y > o2.y) {
                        return 1;
                    }
                }
                return -1;
            }
        });
        maxSize = n;
        System.out.println(divide(0,maxSize-1));
    }

    private static int divide(int start, int end) {
        if((end-start)+1 <= 3) {
            return find(start, end);
        }

        int mid = (start+end)/2;
        int left = divide(start, mid);
        int right = divide(mid+1, end);

        int ans = Math.min(left, right);

        ArrayList<Point> bet = new ArrayList<>();

        // 경계 영역에서 d만큼 거리에 있는 점들의 길이를 조사 (x좌표기준)
        for(int i = start; i < end; i++) {
            int d = arrayList.get(i).x - arrayList.get(mid).x;
            if(d*d < ans) {
                bet.add(arrayList.get(i));
            }
        }

        // y좌표를 기준으로 정렬
        bet.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.y > o2.y) {
                    return 1;
                } else if(o1.y == o2.y) {
                    if(o1.x > o2.x) {
                        return 1;
                    }
                }
                return -1;
            }
        });

        int betPointSize = bet.size();
        for(int i = 0; i < betPointSize-1; i++) {
            for(int j = i+1; j < betPointSize; j++) {
                // x좌표기준으로 d만큼거리의 좌표를 넣었기 때문에, y좌표를 기준으로만 비교해서 선별해서 거리를 보면 시간단축을 할 수 있다.
                int k = bet.get(j).y - bet.get(i).y;
                if(k*k < ans) {
                    int d = dis(bet.get(i).x, bet.get(i).y, bet.get(j).x, bet.get(j).y);
                    ans = Math.min(d, ans);
                } else {
                    break;
                }
            }
        }
        return ans;
    }

    private static int dis(int x1, int y1,int x2,int y2) {
        return (int) (Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
    }

    private static int find(int start, int end) {
        int count = Integer.MAX_VALUE;
        for(int i = start; i < end; i++) {
            for(int j = i+1; j < end+1; j++) {
                int dist = dis(arrayList.get(i).x,arrayList.get(i).y,arrayList.get(j).x,arrayList.get(j).y);
                count = Math.min(count,dist);
            }
        }
        return count;
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
