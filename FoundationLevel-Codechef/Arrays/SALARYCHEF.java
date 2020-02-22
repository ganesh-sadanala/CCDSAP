/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {

  static int equalize(int[] arr, int n) {
    Arrays.sort(arr);
    int min = arr[0];
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += arr[i] - min;
    }
    return sum;
  }

  public static void main(String[] args) throws java.lang.Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(bf.readLine());
    while (t-- > 0) {
      int n = Integer.parseInt(bf.readLine());
      int arr[] = new int[n];
      String s[] = bf.readLine().trim().split("\\s+");
      for (int i = 0; i < n; i++)
        arr[i] = Integer.parseInt(s[i]);

      System.out.println(equalize(arr, n));

    }
  }
}
