/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

//https://discuss.codechef.com/t/hashrad-codechef/38692/2
/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static String hashrad(String s)
    {
        boolean flag=false;
        int n=s.length();
        char c[]=new char[n];
        Arrays.fill(c,'a');
        long sum1=0;
        for(int i=0;i<n;i++){
           sum1+=(s.charAt(i)-97);
        }

        if(sum1==0||sum1==(25*n)||n==1){
           return (sum1+" "+-1);
        }
        else if(sum1<=25)
        {
            c[n-1]=(char)(sum1+97);
            String str="";
              for(int i=0;i<n;i++)
              {
                  str=str+c[i];
              }
              if(str.equals(s))
                {
                    int p=c[n-1]-1;
                    c[n-1]=(char)p;
                    p=c[n-2]+1;
                    c[n-2]=(char)p;
                }
                str="";
                for(int i=0;i<n;i++)
              {
                  str=str+c[i];
              }
              return (sum1+" "+str);
        }
        else
        {
        long sum2=0;
        for(int i=n-1;i>=0;i--)
        {
            long p=sum2+25;
            if(sum1-p<0)
            {
                flag=true;
               c[i]=s.charAt(i);
               break;
            }
            else
            {
                c[i]='z';
                sum2+=25;
            }
        }
              String str="";
              for(int i=0;i<n;i++)
              {
                  str=str+c[i];
              }
              return (sum2+" "+str);}
    }

	public static void main (String[] args) throws java.lang.Exception
	{
	   BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(bf.readLine());
       StringBuffer str=new StringBuffer("");
       while(t-->0)
      {
       String s=bf.readLine();
       str.append(hashrad(s)+"\n");
      }
      System.out.println(str);
	}
}
