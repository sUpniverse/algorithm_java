import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    static long[][] cache;

    public long solution(int n) {

        cache = new long[1001][1001];
        ArrayList<Long> array = new ArrayList<Long>();


        for(int i = 1; i <= 1000; i++) {
            cache[i][i] = i;
            for(int j = i+1; j <= 15; j++) {
                long value = cache[i][j-1] * j;
                cache[i][j] = value;
                array.add(value);
            }
        }

        Collections.sort(array);


        ArrayList<Long> arrayList = new ArrayList<Long>();


        for(int i = 0; i < array.size(); i++) {
            if(!arrayList.contains(array.get(i))) {
                arrayList.add(array.get(i));
            }
        }


        return arrayList.get(n-1);
    }

}