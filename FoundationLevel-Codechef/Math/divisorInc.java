import java.util.*;
import java.io.*;

class DivisorInc {

  static int MAX = 10000000;

  public int countOperations(int N, int M) {
    int res[] = new int[M + 1];
    res[N] = 0;
    for (int i = N + 1; i <= M; i++)
      res[i] = MAX;

    for (int i = N; i < M; i++) {
      for (int j = 2; j * j <= i; j++) {
        if (i % j == 0) {
          int k = i + j;
          if (k <= M)
            res[k] = (int) Math.min(res[k], 1 + res[i]);
          k = i + i / j;
          if (k <= M)
            res[k] = (int) Math.min(res[k], 1 + res[i]);
        }
      }
    }
    return res[M] >= MAX ? -1 : res[M];
  }
}
