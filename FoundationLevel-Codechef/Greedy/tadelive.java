/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {

  static class comparator implements Comparator<Delivery> {
    public int compare(Delivery a, Delivery b) {
      return b.ba - a.ba;
    }
  }

  static class Delivery {
    int a, b, ba;

    Delivery(int p, int q, int pq) {
      a = p;
      b = q;
      ba = pq;
    }
  }

  static void tadelive(ArrayList<Delivery> list, int x, int y) {
    int n = list.size();
    long total = 0;
    for (int i = 0; i < n; i++) {
      Delivery ele = list.get(i);
      if (ele.ba >= 0 && x > 0) {
        total += ele.a;
        x--;
      } else if (y > 0 && ele.ba < 0) {
        total += ele.b;
        y--;
      } else {
        if (x >= y) {
          total += ele.a;
          x--;
        } else {
          total += ele.b;
          y--;
        }
      }
    }
    System.out.println(total);
  }

  public static void main(String[] args) throws java.lang.Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String s[] = bf.readLine().trim().split("\\s+");
    int n = Integer.parseInt(s[0]);
    int x = Integer.parseInt(s[1]);
    int y = Integer.parseInt(s[2]);
    int andy[] = new int[n];
    int bob[] = new int[n];
    s = bf.readLine().trim().split("\\s+");
    for (int i = 0; i < n; i++)
      andy[i] = Integer.parseInt(s[i]);
    s = bf.readLine().trim().split("\\s+");
    for (int i = 0; i < n; i++)
      bob[i] = Integer.parseInt(s[i]);

    ArrayList<Delivery> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(new Delivery(andy[i], bob[i], andy[i] - bob[i]));
    }
    Collections.sort(list, new comparator());
    tadelive(list, x, y);
  }
}
