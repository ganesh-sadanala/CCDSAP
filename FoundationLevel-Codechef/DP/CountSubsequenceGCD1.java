/* package codechef; // don't place package name! */

//https://www.codechef.com/problems/AMSGAME2
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static long dp[][]=new long[61][10010];
    static int gcd(int a,int b)
    {
        if(b==0)
          return a;
          
        return gcd(b,a%b);  
    }     
    
    static long amsGameUtil(int []arr,long [][]dp,int n,int g,int i)
    {
        if(i==n)
        {
            if(g==1)
              return 1;
              
            return 0;
        }
          
          
        if(dp[i][g]!=-1)
           return dp[i][g];
        
        return dp[i][g]=amsGameUtil(arr,dp,n,gcd(g,arr[i]),i+1)+
                      amsGameUtil(arr,dp,n,g,i+1);
                      
    }
    
    static long amsGame(int []arr,int n)
    {
       
        for(int i=0;i<n;i++)
          Arrays.fill(dp[i],-1);
        long cnt=0;
        for(int i=0;i<n;i++)
        {
            cnt+=amsGameUtil(arr,dp,n,arr[i],i+1);
        }
        return cnt;
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(bf.readLine());
       StringBuffer str=new StringBuffer("");
       while(t-->0)
      {
       int n=Integer.parseInt(bf.readLine());
       int arr[]=new int[n];
       String s[]=bf.readLine().trim().split("\\s+");
       for(int i=0;i<n;i++) 
         arr[i]=Integer.parseInt(s[i]);
       
       str.append(amsGame(arr,n)+"\n");     
      }
      System.out.println(str);    
	}
}
