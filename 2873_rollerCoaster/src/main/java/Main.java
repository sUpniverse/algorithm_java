import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;
        Dot minDot = new Dot(0,0);
        for(int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < c; j++) {
                int a = Integer.parseInt(st.nextToken());
                if((i+j)%2 == 1) {
                    if(a < min) {
                        min = a;
                        minDot.x = i;
                        minDot.y = j;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        if(r%2 == 1) {
            // 전지역 순회가능 (R부터 시작)
            for(int i = 0; i < r; i++) {
                if(i%2 == 0) {
                    append(sb, 'R', c-1);
                } else {
                    append(sb, 'L', c-1);
                }
                if(i == r-1) {
                    break;
                }
                sb.append("D");
            }
        } else if(c%2 == 1) {
            // 전지역 순회가능 (D부터 시작)
            for(int i = 0; i < c; i++) {
                if(i%2 == 0) {
                    append(sb, 'D', r-1);
                } else {
                    append(sb, 'U', r-1);
                }
                if(i == c-1) {
                    break;
                }
                sb.append("R");
            }

        } else {
            // 전지역 순회 불가능
            StringBuilder sb2 = new StringBuilder();
            Dot start = new Dot(0, 0);
            Dot end = new Dot(r-1, c-1);
            while(end.x-start.x > 1) {
                if(start.x/2 < minDot.x/2) {
                    append(sb, 'R', c-1);
                    append(sb, 'D', 1);
                    append(sb, 'L', c-1);
                    append(sb, 'D', 1);
                    start.x += 2;
                }
                if(end.x/2 > minDot.x/2) {
                    append(sb2, 'R', c-1);
                    append(sb2, 'D', 1);
                    append(sb2, 'L', c-1);
                    append(sb2, 'D', 1);
                    end.x -= 2;
                }
            }

            while(end.y-start.y > 1) {
                if(start.y/2 < minDot.y/2) {
                    append(sb, 'D', 1);
                    append(sb, 'R', 1);
                    append(sb, 'U', 1);
                    append(sb, 'R', 1);
                    start.y += 2;
                }
                if(end.y/2 > minDot.y/2) {
                    append(sb2, 'D', 1);
                    append(sb2, 'R', 1);
                    append(sb2, 'U', 1);
                    append(sb2, 'R', 1);
                    end.y -= 2;
                }
            }
            if(minDot.y == start.y) {
                append(sb, 'R', 1);
                append(sb, 'D', 1);
            } else {
                append(sb, 'D', 1);
                append(sb, 'R', 1);
            }

            sb2.reverse();
            sb.append(sb2);
        }

        System.out.println(sb);

    }

    static void append(StringBuilder sb, char c, int cnt) {
        for(int i = 0; i < cnt; i++) {
            sb.append(c);
        }
    }

    static class Dot {
        int x;
        int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
