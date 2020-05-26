import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb;
    static int count;
    // 3개의 기둥이 있을때 (A,B,C)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        move(n, 1, 2, 3);
        System.out.println(count);
        System.out.print(sb);
    }


    static void move(int size,int start,int transit, int destination) {
        if(size == 1) {
            count++;
            sb.append(start+" "+destination+"\n");
        } else {
            //일단 경유지로 전부다 옮김
            move(size-1,start,destination, transit);
            //맨 밑 녀석을 목적지로 옮김
            move(1, start, transit, destination);
            //나머지 녀석들 목적지로 옮김
            move(size-1,transit,start,destination);
        }
    }
}
