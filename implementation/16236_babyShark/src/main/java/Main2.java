import java.util.Iterator;
import java.util.PriorityQueue;

public class Main2 {

  public static void main(String[] args) {
    PriorityQueue queue = new PriorityQueue();

    queue.add(new Pair2(2, 1));
    queue.add(new Pair2(2, 3));
    queue.add(new Pair2(5, 3));
    queue.add(new Pair2(5, 1));


    Iterator iterator = queue.iterator();
    while (iterator.hasNext()){
      Pair2 remove = (Pair2) queue.remove();
      System.out.println(remove);
    }
  }

  static class Pair2 implements Comparable<Pair2>{
    int x;
    int y;

    public Pair2(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Pair2 o) {
      if(this.x == o.x) {
        return this.y - o.y;
      }
      return this.x - o.x;
    }

    @Override
    public String toString() {
      return "Pair{" +
              "x=" + x +
              ", y=" + y +
              '}';
    }
  }
}
