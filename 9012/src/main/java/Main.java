import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        StringBuilder st = new StringBuilder();
        for(int i = 0; i < size; i++) {
            String[] split = br.readLine().split("");
            int count = 0;
            for(int j = 0; j < split.length; j++) {
                if(count == 0 && split[j].equals(")")) {
                    builder(st, "NO",i,size);
                    break;
                }
                if(split[j].equals("(")) {
                    count++;
                } else if(split[j].equals(")") && count > 0) {
                    count--;
                } else if(count < 0) {
                    break;
                }

                if(j == split.length - 1) {
                    if(count == 0) {
                        builder(st, "YES", i, size);
                    } else {
                        builder(st, "NO", i, size);
                    }
                }
            }
        }
        System.out.println(st);
    }

    public static void builder(StringBuilder st,String string,int i, int size) {
        if(i == size -1) {
            st.append(string);
        } else {
            st.append(string).append("\n");
        }
    }
}
