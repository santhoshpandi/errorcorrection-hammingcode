import java.util.*;
import java.io.*;
import java.lang.*;
class hams{
	public static void main(String[] args)
	{
		Scanner c=new Scanner(System.in);
		System.out.println("enter the data");
		String s=c.next();
		String binary="";
		int slen=s.length(),i,r,j=0,k=slen-1,z,l,pow; 
		for(r=1;Math.pow(2,r)<(slen+r+1);r++)
		{}
			char[] s1=new char[slen+r+1];
			int[] r1=new int[r+1];
		
			for(i=1;i<(slen+r+1);i++)
			{
				if(i==(Math.pow(2,j)))
				{
					s1[i]='3';
					j++;
				}
				else
				{
					s1[i]=s.charAt(k);	
					k--;
				}
			}
			j=4;
			for(i=1;i<(slen+r+1);i++)
			{
				binary=Integer.toBinaryString(i);
					binary=reverse(binary);
					for(z=1;z<=binary.length();z++)
					{
						if(binary.charAt(z-1)=='1')
						{	
							if(s1[i]=='1')
							{	
								r1[z]=r1[z]+1;
							}
							
						}
							
					}
					
			}
			
			for(i=1;i<=r;i++)
			{
				l=i-1;
					if(r1[i]%2==0)
				{
					 pow=power(2,(i-1));
					s1[pow]='0';
				}
				else
				{
					pow=power(2,(i-1));
					s1[pow]='1';
				}
				
			}
		s=str1(s1);
			s=reverse(s);
			s=s.substring(0,s.length()-1);
			try{    
             FileOutputStream fout=new FileOutputStream("ham.txt");
		     byte b[]=s.getBytes();			 
             fout.write(b);    
             fout.close();    
             System.out.println("success...");    
            }catch(Exception e){System.out.println(e);}    
          
			System.out.println("transmitted data: "+s);
				
		
	}
	
	public static String reverse(String str){
		StringBuilder sb=new StringBuilder(str);
		sb.reverse();
		return sb.toString();
	}
	
	public static int power(int base,int exp)
	{
		int temp=1;
		while(exp!=0)
		{
			temp*=base;
			--exp;
		}
		return temp;
	}
	   public static String str1(char[] stringArray) {
      
      StringBuffer sb = new StringBuffer();
      for(int i = 0; i < stringArray.length; i++) {
         sb.append(stringArray[i]);
      }
      String str = sb.toString();
      return str;
   }
	
}