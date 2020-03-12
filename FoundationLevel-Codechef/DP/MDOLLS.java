/*
solutions:
https://codeforces.com/blog/entry/52817

https://journeywithdp.blogspot.com/2018/06/spoj-mdolls-nested-dolls.html
*/


import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	static class Mdolls
	{
		int w,h;
		Mdolls(int we,int he)
		{
			w=we;
			h=he;
		}
	}

	static int MDOLL(Mdolls md[],int n)
	{
		ArrayList<Mdolls> list=new ArrayList<>();
	    list.add(md[0]);

	    int l=0,r=0;
	    for(int i=1;i<n;i++)
	    {
	    	l=0;
	    	r=list.size()-1;
	    	while(l<=r)
	    	{
	    		int mid=(l+r)>>>1;
	    		Mdolls obj=list.get(mid);
	    		if(md[i].h>=obj.h)
	    		    l=mid+1;
	    		else
	    		    r=mid-1;
	    	}
	    	if(l==list.size())
	    	  list.add(md[i]);
	    	else
	    	 {
	    	 	Mdolls v=list.get(l);
	    	 	v.w=md[i].w;
	    	 	v.h=md[i].h;
	    	 }
	    }

	    return list.size();
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(bf.readLine());
       StringBuffer str=new StringBuffer("");
       while(t-->0)
      {
       int n=Integer.parseInt(bf.readLine());
       String s[]=bf.readLine().trim().split("\\s+");
       Mdolls md[]=new Mdolls[n];
       int j=0;
       for(int i=0;i<n;i++){
       	 int inx1=j;
       	 int inx2=j+1;
       	 j+=2;
         md[i]=new Mdolls(Integer.parseInt(s[inx1]),Integer.parseInt(s[inx2]));}

       Arrays.sort(md,(a,b)->{
       	if(a.w==b.w)
       	  return a.h-b.h;

        return b.w-a.w;
       });
       str.append(MDOLL(md,n)+"\n");
      }
      System.out.println(str);
	}
}
