import java.util.*;
import java.io.*;

public class Refactoring {
  public int refactorUtil(int n, int m) {
    int t = 0;
    for (int i = m; i * i <= n; i++) {
      if (n % i == 0) {
        t += refactorUtil(n / i, i);
      }
    }
    return t + 1;
  }

  public int refactor(int n) {
    return refactorUtil(n, 2) - 1;
  }
}
