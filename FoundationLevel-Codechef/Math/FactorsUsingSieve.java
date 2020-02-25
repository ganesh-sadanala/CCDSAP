/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
  static int MAX = 100001;
  static int arr[] = new int[MAX];

  static void preprocess() {
    Arrays.fill(arr, -1);
    for (int i = 2; i < MAX; i++) {
      if (arr[i] == -1) {
        for (int j = i; j < MAX; j += i) {
          if (arr[j] == -1)
            arr[j] = i;
        }
      }
    }
  }

  public static void main(String[] args) {

    preprocess();
    int n = 18;
    while (n != 1) {
      int p = arr[n];
      System.out.println(p);
      n /= p;
    }
  }
}
