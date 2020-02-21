import java.util.*;
import java.io.*;

public class PrimePolynom {
  public int reveal(int A, int B, int C) {
    for (long i = 0; i <= 1000000000; i++) {
      long p = A * i * i + B * i + C;
      if (p < 0)
        return 0;
      for (long j = 2; j * j <= p; j++) {
        if (p % j == 0) {
          return (int) i;
        }
      }
    }
    return 0;
  }

}
