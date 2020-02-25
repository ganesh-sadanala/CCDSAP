/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static long tadelive(long []andy,long []bob,long [][]dp,int x,int y,int n,int i,int j) 
    {
        if(i==n)
          return 0;
        
        if(dp[i][j]!=-1)
          return dp[i][j];
        
        long res=-1;
        if(j+1<=x)
        {
            res=(long)Math.max(res,andy[i]+tadelive(andy,bob,dp,x,y,n,i+1,j+1));
        }
        if((i-j)+1<=y)
        {
           res=(long)Math.max(res,bob[i]+tadelive(andy,bob,dp,x,y,n,i+1,j));   
        }
        return dp[i][j]=res;
        
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
	   BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
       String s[]=bf.readLine().trim().split("\\s+");
       int n=Integer.parseInt(s[0]);
       int x=Integer.parseInt(s[1]);
       int y=Integer.parseInt(s[2]);
       long andy[]=new long[n];
       long bob[]=new long[n];
       s=bf.readLine().trim().split("\\s+");
       for(int i=0;i<n;i++)
         andy[i]=Long.parseLong(s[i]);
       s=bf.readLine().trim().split("\\s+");
       for(int i=0;i<n;i++)
         bob[i]=Long.parseLong(s[i]);  
         
         long dp[][]=new long[n+2][x+2];
         for(int i=0;i<(n+2);i++)
            Arrays.fill(dp[i],-1);
            
        System.out.println(tadelive(andy,bob,dp,x,y,n,0,0));
	}
}
