import java.io.*;
import java.util.*;
import java.lang.*;
class hamd{
	
	public static void main(String[] args)
	{
		String s=""; 
	try{
		File f = new File("ham.txt");
		FileInputStream f1=new FileInputStream(f);
		byte []by=new byte[(int)f.length()];
		f1.read(by);
		s=new String(by);
		}
		catch(Exception e)
		{
			System.out.println("Exception");
		}
		int r=find(s.length());
		int i,k=s.length()-1;int[] r1=new int[r+1];
		
			System.out.println("Received Data: "+s);
			char[] s1=new char[s.length()+1];
			for(i=1;i<=s.length();i++)
			{
			
					s1[i]=s.charAt(k);	
					k--;
				
				} int z; String binary;
			
			for(i=1;i<=s.length();i++)
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
			int flag=r;
				for(i=1;i<=r;i++)
			{
				
				if(r1[i]%2==0)
				{
					 flag--;
				}
				else
				{
					System.out.println("message error! detected\n rectifing it....");
					System.out.println("Unrectified data...."+s);
					int pow=power(2,(i-1));
					if(s1[pow]=='0')
						s1[pow]='1';
					else
						s1[pow]='0';
					flag--;
					System.out.println("After Rectifying!");
				}
				
			}
			int j=0;
			s=str1(s1); String s3="";
			s=reverse(s);
			s=s.substring(0,s.length()-1);
			s3=reverse(s);
			if(flag==0)
				System.out.println("received data: "+s);
			String s2="";
			System.out.println("Unpacking Stuffed data.......");
			for(i=0;i<s3.length();i++)
			{
				if(i!=(power(2,j)-1))
				{
					s2=s2+s3.charAt(i);
					
				}
				else
					j++;
				
			}
			s2=reverse(s2);
			
			System.out.println("Original Data: "+s2);
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
   public static int find(int len)
   {
	   int value=0;
	   for(int i=0;i<len/2;i++)
	   {
		   if(Math.pow(2,i)<=len)
		   {
			   value=i+1;
			   
		   }
	   }
return value;
   }
}
			