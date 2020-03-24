/* package codechef; // don't place package name! */

import java.util.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
  static int cost[] = new int[100005];
  static int parent[] = new int[100005];

  static int find(int x) {
    if (parent[x] != x)
      parent[x] = find(parent[x]);

    return parent[x];
  }

  static void find2(int x) {
    int root = find(x);
    if ((cost[x] >= 0 && cost[root] < 0) || (cost[x] >= 0 && cost[x] < cost[root]))
      cost[root] = cost[x];
  }

  static void union(int x, int y, int rank[]) {
    int xset = find(x);
    int yset = find(y);
    if (xset == yset)
      return;

    if (rank[xset] > rank[yset])
      parent[yset] = xset;
    else {
      parent[xset] = yset;
      if (rank[xset] == rank[yset]) {
        rank[yset]++;
      }
    }
  }

  public static void main(String[] args) throws java.lang.Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String s[] = bf.readLine().trim().split("\\s+");
    int n = Integer.parseInt(s[0]);
    int m = Integer.parseInt(s[1]);
    int rank[] = new int[100005];
    boolean vis[] = new boolean[n + 1];
    for (int i = 1; i <= n; i++) {
      rank[i] = 0;
      vis[i] = false;
      parent[i] = i;
    }
    for (int i = 1; i <= m; i++) {
      s = bf.readLine().trim().split("\\s+");
      union(Integer.parseInt(s[0]), Integer.parseInt(s[1]), rank);
    }

    for (int i = 1; i <= n; i++) {
      cost[i] = Integer.parseInt(bf.readLine());
    }
    long sum = 0;
    for (int i = 1; i <= n; i++)
      find2(i);

    int count = 0;
    int min = Integer.MAX_VALUE;
    for (int i = 1; i <= n; i++) {
      if (!vis[parent[i]]) {
        if (cost[parent[i]] < 0) {
          System.out.println(-1);
          return;
        }
        sum += cost[parent[i]];
        vis[parent[i]] = true;
        min = (int) Math.min(cost[parent[i]], min);
        count++;
      }
    }
    System.out.println(sum + (count - 2) * min);
  }
}
