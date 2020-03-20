/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
//Refer discuss to get better idea
class Codechef
{
    static void righttri(double h,double s)
    {
      double apb=Math.sqrt(h*h+4*s);
      double amb=Math.sqrt(h*h-4*s);
      double a = (apb+amb)/2;
      double b = (apb-amb)/2;
      if(a>0&&b>0||a<0&&b<0)
      {
          System.out.printf("%.6f %.6f %.6f\n",Math.min(a,b),Math.max(a,b),h);
      }
      else
        System.out.println(-1);
    }

	public static void main (String[] args) throws java.lang.Exception
	{
	   BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(bf.readLine());
       while(t-->0)
      {
       String str[]=bf.readLine().trim().split("\\s+");
       double h=Double.parseDouble(str[0]);
       double s=Double.parseDouble(str[1]);
       righttri(h,s);
      }
	}
}
