/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static class Music
    {
        long ban,len;
        Music(long b,long l)
        {
            ban=b;
            len=l;
        }
    } 
    
    static long lemusic(ArrayList<Music> array)
    {
       long prev=-1;
       long sum=0,remLen=0;
       ArrayList<Long> list=new ArrayList<>();
       for(int i=0;i<array.size();i++)
       {
           Music m=array.get(i);
           if(m.ban!=prev)
           {
               list.add(m.len);
               prev=m.ban;
           }
           else
           {
               remLen+=m.len;
           }
       }
       int k=list.size();
       Collections.sort(list);
       for(int i=0;i<k;i++)
       {
           sum+=((i+1)*list.get(i));
       }
       sum+=(remLen*k);
       return sum;
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
	   BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(bf.readLine());
       StringBuffer str=new StringBuffer("");
      
       while(t-->0)
      {
           ArrayList<Music> array=new ArrayList<>();
       int n=Integer.parseInt(bf.readLine());
       while(n-->0){
       String s[]=bf.readLine().trim().split("\\s+");      
       long b=Long.parseLong(s[0]);
       long l=Long.parseLong(s[1]);
        array.add(new Music(b,l));               
       }
       
       Collections.sort(array,(a,b)->{
           if(a.ban<b.ban)
             return (int)-1;
           else if(a.ban>b.ban)
             return (int)1;
           else
             return (int)(a.len-b.len);
       });
       str.append(lemusic(array)+"\n");     
      }
      System.out.println(str);
	}
}

/*

Key Test case: 
  2
  3
  1 1
  1 2
  2 3
  3
  1 3
  2 1
  1 2*/