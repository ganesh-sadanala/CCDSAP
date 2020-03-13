/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static long sntemple(long []arr,int n)
    {
       long res=-1;
       long sum=Arrays.stream(arr).sum();
       long l[]=new long[n];//max from left till that index
       l[0]=(long)Math.min(1,arr[0]);
       for(int i=1;i<n;i++)
         l[i]=(long)Math.min(arr[i],l[i-1]+1);
       long r[]=new long[n];
       r[n-1]=(long)Math.min(1,arr[n-1]);
       for(int i=n-2;i>=0;i--)
         r[i]=(long)Math.min(arr[i],r[i+1]+1);
       for(int i=0;i<n;i++)
       {
           long h=(long)Math.min(r[i],l[i]);
           res=(long)Math.max(h,res);
       }
       return sum-(res*res);
    }

	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(bf.readLine());
       StringBuffer str=new StringBuffer("");
       while(t-->0)
      {
       int n=Integer.parseInt(bf.readLine());
       long arr[]=new long[n];
       String s[]=bf.readLine().trim().split("\\s+");
       for(int i=0;i<n;i++)
         arr[i]=Long.parseLong(s[i]);

       str.append(sntemple(arr,n)+"\n");
      }
      System.out.println(str);
	}
}
