import java.io.*;

public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] num = new int[4];
        String s ="";
        while((s = br.readLine()) != null) {
            num[0] = 0;
            num[1] = 0;
            num[2] = 0;
            num[3] = 0;
            char[] chars = s.toCharArray();
            for(int i = 0; i < chars.length; i++) {
                if(chars[i] > 96 && chars[i] < 123) {
                    num[0]++;
                } else if(chars[i] > 64 && chars[i] < 91) {
                    num[1]++;
                } else if(chars[i] > 47 && chars[i] < 57) {
                    num[2]++;
                } else {
                    num[3]++;
                }
            }
            bw.write(num[0]+" "+num[1]+" "+num[2]+" "+num[3]+"\n");
        }
        bw.flush();
    }
}
