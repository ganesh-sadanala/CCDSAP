/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

//similar to running medians
/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
  static class maxcompare implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
      return b - a;
    }
  }

  public static void main(String[] args) throws java.lang.Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(bf.readLine());
    StringBuffer str = new StringBuffer("");
    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>(new maxcompare());
    int cnt = 0;
    while (t-- > 0) {
      String s[] = bf.readLine().trim().split("\\s+");
      if (s.length > 1) {
        cnt++;
        int p = Integer.parseInt(s[1]);
        max.add(p);
        if (cnt % 3 == 0)
          min.add(max.poll());

        else if (max.size() > 0 && min.size() > 0 && max.peek() > min.peek()) {
          int temp = max.poll();
          max.add(min.poll());
          min.add(temp);
        }
      } else {
        if (min.size() > 0)
          str.append(min.peek() + "\n");
        else
          str.append("No reviews yet\n");
      }
    }
    System.out.println(str);
  }
}
