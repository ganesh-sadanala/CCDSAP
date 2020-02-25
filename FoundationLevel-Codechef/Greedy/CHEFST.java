/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {

  public static void main(String[] args) throws java.lang.Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(bf.readLine());
    while (t-- > 0) {
      String s[] = bf.readLine().trim().split("\\s+");
      long n1 = Long.parseLong(s[0]);
      long n2 = Long.parseLong(s[1]);
      long m = Long.parseLong(s[2]);
      long p = (m * (m + 1)) / 2;
      long x = (long) Math.min(p, (long) Math.min(n1, n2));
      System.out.println(n1 + n2 - 2 * x);
    }

  }
}
