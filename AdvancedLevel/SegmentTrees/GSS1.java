// Refer: Range queries on a given range - GeeksForGeeks
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {

  static class Node {
    long prefsum, sufsum, maxsum, sum;
  }

  static Node st[] = new Node[131072];

  static void createSt(long arr[], int ss, int se, int si) {
    if (ss == se) {
      st[si].prefsum = st[si].sufsum = st[si].sum = st[si].maxsum = arr[ss];
    } else {
      int mid = ss + (se - ss) / 2;
      createSt(arr, ss, mid, 2 * si + 1);
      createSt(arr, mid + 1, se, 2 * si + 2);

      st[si].sum = st[2 * si + 1].sum + st[2 * si + 2].sum;
      st[si].prefsum = Math.max(st[2 * si + 1].prefsum, st[2 * si + 1].sum + st[2 * si + 2].prefsum);
      st[si].sufsum = Math.max(st[2 * si + 2].sufsum, st[2 * si + 2].sum + st[2 * si + 1].sufsum);
      st[si].maxsum = Math.max(Math.max(st[2 * si + 1].maxsum, st[2 * si + 2].maxsum),
          Math.max(Math.max(st[si].prefsum, st[si].sufsum), st[2 * si + 1].sufsum + st[2 * si + 2].prefsum));
    }
  }

  static Node getMaxSum(long arr[], int ss, int se, int qs, int qe, int si) {
    Node res = new Node();
    res.sum = res.prefsum = res.sufsum = res.maxsum = Long.MIN_VALUE;
    if (qe < ss || qs > se)
      return res;
    if (qs <= ss && qe >= se)
      return st[si];
    int mid = ss + (se - ss) / 2;
    if (qs > mid)
      return getMaxSum(arr, mid + 1, se, qs, qe, 2 * si + 2);
    if (qe <= mid)
      return getMaxSum(arr, ss, mid, qs, qe, 2 * si + 1);
    Node left = getMaxSum(arr, ss, mid, qs, qe, 2 * si + 1);
    Node right = getMaxSum(arr, mid + 1, se, qs, qe, 2 * si + 2);
    res.sum = left.sum + right.sum;
    res.prefsum = Math.max(left.prefsum, left.sum + right.prefsum);
    res.sufsum = Math.max(right.sufsum, right.sum + left.sufsum);
    res.maxsum = Math.max(Math.max(left.maxsum, right.maxsum),
        Math.max(Math.max(res.prefsum, res.sufsum), left.sufsum + right.prefsum));

    return res;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    StringBuffer str = new StringBuffer("");
    int n = Integer.parseInt(bf.readLine().trim());
    String s[] = bf.readLine().trim().split("\\s+");
    long arr[] = new long[n];
    for (int i = 0; i < 131072; i++)
      st[i] = new Node();
    for (int i = 0; i < n; i++)
      arr[i] = Long.parseLong(s[i]);
    int m = Integer.parseInt(bf.readLine().trim());
    createSt(arr, 0, n - 1, 0);
    while (m-- > 0) {
      s = bf.readLine().trim().split("\\s+");
      Node res = getMaxSum(arr, 0, n - 1, Integer.parseInt(s[0]) - 1, Integer.parseInt(s[1]) - 1, 0);
      str.append(res.maxsum + "\n");
    }
    System.out.print(str);
  }
}
