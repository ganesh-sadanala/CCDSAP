import java.util.*;
import java.io.*;

public final class Solution {
  static boolean left(char c, HashMap<Character, Integer> map) {
    for (char ch = 'a'; ch < c; ch++) {
      if (map.get(ch) != 0)
        return false;
    }
    return true;
  }

  static void minString(String s, HashMap<Character, Integer> map) {
    StringBuffer str = new StringBuffer("");
    Stack<Character> stack = new Stack<>();
    int n = s.length();
    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      map.put(c, map.get(c) - 1);

      if (left(c, map)) {
        str.append("" + c);
        while (!stack.isEmpty()) {
          char temp = stack.peek();
          if (left(temp, map)) {
            str.append("" + temp);
            stack.pop();
          } else
            break;
        }
      } else {
        stack.push(c);
      }
    }
    while (!stack.isEmpty())
      str.append("" + stack.pop());

    System.out.println(str);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String s = bf.readLine();
    HashMap<Character, Integer> map = new HashMap<>();
    for (char c = 'a'; c <= 'z'; c++)
      map.put(c, 0);

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!map.containsKey(c))
        map.put(c, 1);
      else
        map.put(c, map.get(c) + 1);
    }
    minString(s, map);
  }
}
