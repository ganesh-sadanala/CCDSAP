import java.util.*;
import java.lang.*;
import java.io.*;

//https://www.geeksforgeeks.org/find-next-greater-number-set-digits/
class GFG {
  static void print(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++)
      System.out.print(arr[i] + " ");

    System.out.println();
  }

  static void nextPermutation(int[] arr, int n) {
    int i = n - 1;
    for (i = n - 1; i >= 1; i--) {
      if (arr[i] > arr[i - 1])
        break;
    }
    if (i == 0) {
      Arrays.sort(arr);
      print(arr);
      return;
    } else {
      int x = arr[i - 1];
      int min = i;
      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[min] && arr[j] > x)
          min = j;
      }
      arr[i - 1] ^= arr[min];
      arr[min] = arr[i - 1] ^ arr[min];
      arr[i - 1] ^= arr[min];
      Arrays.sort(arr, i, n);
    }
    print(arr);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(bf.readLine());
    while (t-- > 0) {
      int n = Integer.parseInt(bf.readLine());
      int arr[] = new int[n];
      String s[] = bf.readLine().trim().split("\\s+");
      for (int i = 0; i < n; i++)
        arr[i] = Integer.parseInt(s[i]);

      nextPermutation(arr, n);
    }

  }
}
