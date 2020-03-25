import java.util.*;
import java.io.*;

//Refer https://www.geeksforgeeks.org/maximum-occurrence-given-range/
class Main {

  static int st[] = new int[140000];

  static int createSt(int[] arr, int ss, int se, int si) {

    if (ss == se) {
      st[si] = arr[ss];
      return st[si];
    }

    int mid = ss + (se - ss) / 2;
    st[si] = Math.max(createSt(arr, ss, mid, 2 * si + 1), createSt(arr, mid + 1, se, 2 * si + 2));
    return st[si];
  }

  static int rmq(int[] arr, int ss, int se, int qs, int qe, int si) {
    if (qs <= ss && qe >= se)
      return st[si];

    if (qs > se || qe < ss)
      return 0;
    int mid = ss + (se - ss) / 2;
    return Math.max(rmq(arr, ss, mid, qs, qe, 2 * si + 1), rmq(arr, mid + 1, se, qs, qe, 2 * si + 2));
  }

  static int frequent(int arr[], int freq[], int qs, int qe, int n) {
    int res;
    if (arr[qs] == arr[qe])
      res = qe - qs + 1;
    else {
      int leftmost_same = 0, rightmost_same = 0;
      // max of all 3
      while (qs > 0 && qs <= qe && arr[qs] == arr[qs - 1]) {
        qs++;
        leftmost_same++;
      }
      while (qe >= qs && qe < n - 1 && arr[qe] == arr[qe + 1]) {
        qe--;
        rightmost_same++;
      }
      res = Math.max(Math.max(leftmost_same, rightmost_same), rmq(freq, 0, n - 1, qs, qe, 0));
    }
    return res;
  }

  public static void main(String[] args) throws java.lang.Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String s[] = bf.readLine().trim().split("\\s+");
    int n = Integer.parseInt(s[0]);
    int q = Integer.parseInt(s[1]);
    int arr[] = new int[n];
    s = bf.readLine().trim().split("\\s+");
    for (int i = 0; i < n; i++)
      arr[i] = Integer.parseInt(s[i]);
    StringBuffer str = new StringBuffer("");
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (!map.containsKey(arr[i]))
        map.put(arr[i], 1);
      else
        map.put(arr[i], map.get(arr[i]) + 1);
    }
    int freq[] = new int[n];
    for (int i = 0; i < n; i++)
      freq[i] = map.get(arr[i]);

    createSt(freq, 0, n - 1, 0);
    while (q-- > 0) {
      s = bf.readLine().trim().split("\\s+");
      if (s.length == 1)
        break;
      str.append(frequent(arr, freq, Integer.parseInt(s[0]) - 1, Integer.parseInt(s[1]) - 1, n) + "\n");
    }
    System.out.print(str);
  }
}
