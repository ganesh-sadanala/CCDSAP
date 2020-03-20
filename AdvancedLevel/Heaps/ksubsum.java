/* package codechef; // don't place package name! */

import java.util.*;
import java.io.*;

//Refer this:https://www.geeksforgeeks.org/k-th-largest-sum-contiguous-subarray/
/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
  static String ksubsum(int[] arr, int n, int k1, int k2, int k3) {
    ArrayList<Integer> list = new ArrayList<>();
    int pre[] = new int[n];
    pre[0] = arr[0];
    for (int i = 1; i < n; i++)
      pre[i] = arr[i] + pre[i - 1];

    int k = k3;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      int x = pre[i];
      if (pq.size() < k)
        pq.add(x);
      else {
        if (pq.peek() < x) {
          pq.add(x);
          pq.remove();
        }
      }
      for (int j = 0; j < i; j++) {
        x = pre[i] - pre[j];
        if (pq.size() < k)
          pq.add(x);
        else {
          if (pq.peek() < x) {
            pq.add(x);
            pq.remove();
          }
        }
      }
    }
    while (pq.size() != 0) {
      list.add(pq.remove());
    }
    Collections.sort(list, Collections.reverseOrder());
    return list.get(k1 - 1) + " " + list.get(k2 - 1) + " " + list.get(k3 - 1);
  }

  public static void main(String[] args) throws java.lang.Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(bf.readLine());
    StringBuffer str = new StringBuffer("");
    while (t-- > 0) {
      String s[] = bf.readLine().trim().split("\\s+");
      int n = Integer.parseInt(s[0]);
      int k1 = Integer.parseInt(s[1]);
      int k2 = Integer.parseInt(s[2]);
      int k3 = Integer.parseInt(s[3]);
      int arr[] = new int[n];
      s = bf.readLine().trim().split("\\s+");
      for (int i = 0; i < n; i++)
        arr[i] = Integer.parseInt(s[i]);

      str.append(ksubsum(arr, n, k1, k2, k3) + "\n");
    }
    System.out.println(str);
  }
}
