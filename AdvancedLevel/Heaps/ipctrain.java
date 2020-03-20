/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

//Editorial Ref: https://discuss.codechef.com/problems/IPCTRAIN
/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static class Trainer
    {
        int day;
        int num;
        int pen;
        Trainer(int d,int n,int p)
        {
            day=d;
            num=n;
            pen=p;
        }
    }
    static class comparator implements Comparator<Trainer>
    {
        public int compare(Trainer a,Trainer b)
        {
              return a.day-b.day;
        }
    }

    static class comparator1 implements Comparator<Trainer>
    {
        public int compare(Trainer a,Trainer b)
        {
            return b.pen-a.pen;
        }
    }

    static long ipcTrain(ArrayList<Trainer> list,int n,int d,PriorityQueue<Trainer> pq)
    {
        int j=0;
       for(int i=0;i<n-1;i++)
       {
           j=list.get(i).day;
           pq.add(list.get(i));
           while(j<list.get(i+1).day&&!pq.isEmpty())
           {
               Trainer t=pq.remove();
               t.num--;
               if(t.num>0)
                 pq.add(t);

                 j++;
           }
       }
       pq.add(list.get(n-1));
       for(j=list.get(n-1).day;j<=d&&!(pq.isEmpty());j++)
       {
           Trainer t=pq.remove();
               t.num--;
               if(t.num>0)
                 pq.add(t);
       }
       long res=0;
       while(pq.size()!=0)
       {
           Trainer t=pq.remove();
           res+=((long)t.pen*t.num);
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
       String s[]=bf.readLine().trim().split("\\s+");
       int n=Integer.parseInt(s[0]);
       int d=Integer.parseInt(s[1]);
       PriorityQueue<Trainer> pq=new PriorityQueue<>(new comparator1());
       ArrayList<Trainer> list=new ArrayList<>();
       int temp=n;
       while(n-->0)
       {
           s=bf.readLine().trim().split("\\s+");
           list.add(new Trainer(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2])));
       }
       Collections.sort(list,new comparator());
       str.append(ipcTrain(list,temp,d,pq)+"\n");
      }
      System.out.println(str);
	}
}
