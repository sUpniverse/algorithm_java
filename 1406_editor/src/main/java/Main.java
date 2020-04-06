import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String cc = br.readLine();
        int size = Integer.parseInt(br.readLine());
        ArrayList<Character> cl = new ArrayList<>();

        for(int i = 0; i < cc.length(); i++) {
            cl.add(cc.charAt(i));
        }

        int cursor = cc.length();


        for(int i = 0; i < size; i++) {
            String cm = br.readLine();
            if(cm.startsWith("L")) {
                if(cursor > 0) {
                    cursor--;
                }
            } else if(cm.startsWith("D")) {
                if(cursor < cl.size()) {
                    cursor++;
                }
            } else if(cm.startsWith("B")) {
                if(cursor > 0) {
                    cl.remove(cursor-1);
                    cursor--;
                }
            } else if(cm.startsWith("P")) {
                String[] s = cm.split(" ");
                cl.add(cursor,s[1].charAt(0));
                cursor++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : cl) {
            sb.append(c);
        }

        System.out.println(sb);
    }
}
