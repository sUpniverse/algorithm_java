public class StringCompression2 {

  public static void main(String[] args) {
    solution("aaa");
  }

  public static int solution(String s) {

    StringBuilder sb = new StringBuilder();

    int n = Integer.MAX_VALUE;

    // 문자를 잘라야 하는 숫자의 범위
    for(int i = 1; i < n; i++) {
      // 단어 하나하나 탐색
      for(int j = 0; j < s.length(); j+=) {
        int same = 0;
        String substring = s.substring(j, j + i);
        for(int k = j+i; k < s.length(); k+=i) {
          if(!substring.equals(s.substring(k, k+i))) {
            break;
          }
          same++;
        }
      }
    }
  }

}
