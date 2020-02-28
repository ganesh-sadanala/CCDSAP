
/*
 * Explanation:
 * https://www.quora.com/What-is-the-approach-to-solve-SPOJ-com-Problem-BALIFE
 */
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
  static long balife(long[] arr, int n) {
    long s = Arrays.stream(arr).sum();
    if (s % n != 0)
      return -1;

    long avg = s / n;
    for (int i = 0; i < n; i++)
      arr[i] -= avg;

    for (int i = 1; i < n; i++)
      arr[i] += arr[i - 1];

    long res = Long.MIN_VALUE;
    for (int i = 0; i < n; i++)
      res = (long) Math.max(res, Math.abs(arr[i]));

    return res;
  }

  public static void main(String[] args) throws java.lang.Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String str;
    StringBuffer sb = new StringBuffer("");
    while ((str = bf.readLine()) != null) {
      int n = Integer.parseInt(str);
      if (n == -1)
        break;

      long arr[] = new long[n];
      String s[] = bf.readLine().trim().split("\\s+");
      for (int i = 0; i < n; i++)
        arr[i] = Long.parseLong(s[i]);

      sb.append(balife(arr, n) + "\n");
      bf.readLine();
    }
    System.out.print(sb);
  }
}
