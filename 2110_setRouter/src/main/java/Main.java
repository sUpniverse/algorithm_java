import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] houses = new int[n];


        for(int i = 0; i < n; i++) {
            houses[i]= Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int min = 1;
        int max = houses[n-1]-houses[0];

        while(min <= max) {
            int mid = (max+min)/2;
            int prev = houses[0];
            int count = 1;

            for(int house : houses) {
                if(house - prev >= mid) {
                    count++;
                    prev = house;
                }
            }

            if(count >= c) {
                min = mid+1;
            } else {
                max = mid-1;
            }
        }

        System.out.println(max);
    }
}
