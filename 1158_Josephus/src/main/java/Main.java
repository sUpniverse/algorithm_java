import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int size = Integer.parseInt(s[0]);
        int num = Integer.parseInt(s[1])-1;

        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i = 0; i < size; i++) {
            arrayList.add(i+1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int index = 0;
        while(!arrayList.isEmpty()) {
            index += num;
            if(index >= arrayList.size()) {
                index %= arrayList.size();
            }
            sb.append(arrayList.remove(index)+", ");
        }

        System.out.println(sb.replace(sb.length()-2, sb.length(), ">"));

    }
}
