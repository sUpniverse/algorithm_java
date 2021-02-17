
import java.util.Stack;

public class Main {

  public static void main(String[] args) {
    int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
    int[] moves = {1,5,3,5,1,2,1,4};
    System.out.println(solution(board, moves));

  }

  public static int solution (int[][] board, int[] moves) {
    Stack stack = new Stack();
    int answer = 0;

    for(int index : moves) {
      int i = index-1;
      for(int j = 0; j < board.length; j++) {
        if(board[j][i] != 0) {
          int top = board[j][i];
          int peek = 0;
          if(!stack.isEmpty()) {
            peek = (int) stack.peek();
          }
          if(peek == top) {
            stack.pop();
            answer += 2;
          } else {
            stack.push(top);
          }
          board[j][i] = 0;
          break;
        }
      }
    }

    return answer;
  }
}
