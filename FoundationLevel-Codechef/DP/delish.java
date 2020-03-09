/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

// editorial : https://discuss.codechef.com/t/delish-editorial/2319
/* Name of the class has to be "Main" only if the class is public. */
/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static long left[][]=new long[10004][2];
    static long right[][]=new long[10004][2];
    static long delish(long []arr,int n)
    {
        //kadanes's algo
        left[0][0]=arr[0];
        left[0][1]=arr[0];
        right[n-1][0]=arr[n-1];
        right[n-1][1]=arr[n-1];
        for(int i=1;i<n;i++)
        {
            left[i][0]=(long)Math.max(left[i-1][0]+arr[i],arr[i]);
            left[i][1]=(long)Math.min(left[i-1][1]+arr[i],arr[i]);
        }
        for(int i=n-2;i>=0;i--)
        {
            right[i][0]=(long)Math.max(right[i+1][0]+arr[i],arr[i]);
            right[i][1]=(long)Math.min(right[i+1][1]+arr[i],arr[i]);
        }
        long res=0;
        for(int i=0;i<n-1;i++)
        {
            res=(long)Math.max(Math.abs(left[i][0]-right[i+1][1]),res);
            res=(long)Math.max(Math.abs(left[i][1]-right[i+1][0]),res);
             res=(long)Math.max(Math.abs(left[i][0]-right[i+1][0]),res);
            res=(long)Math.max(Math.abs(left[i][1]-right[i+1][1]),res);
        }
        return res;
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
       for(int i=0;i<10004;i++){
       Arrays.fill(left[i],0);
       Arrays.fill(right[i],0);}
       str.append(delish(arr,n)+"\n");     
      }
      System.out.println(str);   
	}
}
