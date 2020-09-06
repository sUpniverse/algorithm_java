public class nNumberGame {

    public static void main(String[] args) {
        String solution = solution(16, 16, 2, 1);

        System.out.println(solution);

    }

    public static String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int i = 0;
        while (true) {
            char[] array = getN(i, n);
            for(int j = 0; j < array.length; j++) {
                count++;
                if(count % m == (p%m))
                    sb.append(array[j]);
            }
            if(sb.toString().length() > t) break;
            i++;
        }

        return sb.substring(0, t);
    }

    static char[] getN(int a, int n){
        StringBuilder sb = new StringBuilder();
        if(a == 0) return sb.append(0).toString().toCharArray();
        while (a > 0) {
            int b = a % n;
            if(n >= 10 && b >= 10) {
                char c = (char) (b+55);
                sb.append(c);
            } else
                sb.append(b);
            a /= n;
        }

        return sb.reverse().toString().toCharArray();
    }
}
