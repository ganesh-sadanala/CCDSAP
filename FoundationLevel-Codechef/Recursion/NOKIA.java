/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
  // key idea: | 0 0 0 0 | is same as | 0 0 | 0 0 | in recursion
  static int min(int n) {
    if (n <= 0)
      return 0;

    int min = 0;
    min += min(n / 2) + min(n - n / 2 - 1) + (n + 1);

    return min;
  }

  public static void main(String[] args) throws java.lang.Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(bf.readLine());
    while (t-- > 0) {
      String s[] = bf.readLine().trim().split("\\s+");
      int n = Integer.parseInt(s[0]);
      int m = Integer.parseInt(s[1]);
      int max = n, min = 0;
      for (int i = 1; i <= n; i++)
        max += i;

      if (max <= m)
        System.out.println(m - max);
      else {
        min = min(n);
        if (m < min)
          System.out.println(-1);
        else
          System.out.println(0);
      }
    }
  }
}
