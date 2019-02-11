/*Name:Jinay Parekh
 * Batch:C Roll No:46*/
 //Booths Algorithm
import java.util.*;
class Controller
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);

		System.out.println("Enter num1:");
		int m_input=sc.nextInt();

		System.out.println("Enter num2:");
		int q_input=sc.nextInt();
		
		String m_string;
		if(m_input<0)
		{
		    m_input=-m_input;
	    	m_string = String.format("%8s", Integer.toBinaryString(m_input)).replace(' ', '0');
	        StringBuilder m=complementBinary(new StringBuilder(m_string));
	        m_string=m.toString();
		}else
		{
		    m_string = String.format("%8s", Integer.toBinaryString(m_input)).replace(' ', '0');
		}
		
		String q_string;
		
		if(q_input<0)
		{
		    q_input=-q_input;
	    	q_string = String.format("%8s", Integer.toBinaryString(q_input)).replace(' ', '0');
	        StringBuilder m=complementBinary(new StringBuilder(q_string));
	        q_string=m.toString();	   
		}else
		{
		    q_string = String.format("%8s", Integer.toBinaryString(q_input)).replace(' ', '0');
		}
		
		StringBuilder m=new StringBuilder(m_string);
		StringBuilder m_c=complementBinary(m);
		StringBuilder q=new StringBuilder(q_string);
		StringBuilder a=new StringBuilder("00000000");
		StringBuilder q1=new StringBuilder("0");
		
		int count=1;

		while(count<=8)
		{
			String bits=String.valueOf(q.charAt(7))+String.valueOf(q1.charAt(0));
			
			if(bits.equals("01"))
			{
				a=addBinary(a,m);
			}else if(bits.equals("10"))
			{
				a=addBinary(a,m_c);
			}
			
			StringBuilder res=shiftRight(a,q,q1);
	
			a=new StringBuilder(res.substring(0,8));
			q=new StringBuilder(res.substring(8,16));
			q1=new StringBuilder(res.substring(16));
			System.out.println("Count: "+count+" A:"+a+" Q:"+q+" Q1:"+q1);
			count++;			
		}

		System.out.println("A: "+a+" Q: "+q);	
		btd(a,q);
	}

	public static StringBuilder addBinary(StringBuilder a,StringBuilder b)
	{
		int c=0,i=7;
		StringBuilder res=new StringBuilder("00000000");
		
		while(i>=0)
		{
			int b1=a.charAt(i)-'0';
			int b2=b.charAt(i)-'0';
			
			if((b1^b2)==1)
			{
				if(c==0)
				{
					res.setCharAt(i,'1');
					c=0;				
				}
				else
				{
					c=1;
				}
			}
			else
			{
				if(c==0)
				{
					if(b1==0)
					{
						c=0;
					}
					else
					{
						c=1;
					}			
				}
				else
				{
					if(b1==0)
					{
						res.setCharAt(i,'1');
						c=0;
					}
					else
					{
						res.setCharAt(i,'1');
						c=1;
					}
				}												
			}
			i--;			
		}
		return res;
	}
	public static StringBuilder addBinary16(StringBuilder a,StringBuilder b)
	{
		int c=0,i=15;
		StringBuilder res=new StringBuilder("0000000000000000");
		
		while(i>=0)
		{
			int b1=a.charAt(i)-'0';
			int b2=b.charAt(i)-'0';
			
			if((b1^b2)==1)
			{
				if(c==0)
				{
					res.setCharAt(i,'1');
					c=0;				
				}
				else
				{
					c=1;
				}
			}
			else
			{
				if(c==0)
				{
					if(b1==0)
					{
						c=0;
					}
					else
					{
						c=1;
					}			
				}
				else
				{
					if(b1==0)
					{
						res.setCharAt(i,'1');
						c=0;
					}
					else
					{
						res.setCharAt(i,'1');
						c=1;
					}
				}												
			}
			i--;			
		}
		return res;
	}

	public static StringBuilder complementBinary(StringBuilder a)
	{
		StringBuilder res=new StringBuilder(a);
		
		int i=0;
		while(i<=7)
		{
			if(res.charAt(i)=='0')
			{
				res.setCharAt(i,'1');
			}else
			{
				res.setCharAt(i,'0');
			}
			i++;
		}
		res=addBinary(res,new StringBuilder("00000001"));
		return res;
	}
	public static StringBuilder complementBinary16(StringBuilder a)
	{
		StringBuilder res=new StringBuilder(a);
		
		int i=0;
		while(i<=15)
		{
			if(res.charAt(i)=='0')
			{
				res.setCharAt(i,'1');
			}else
			{
				res.setCharAt(i,'0');
			}
			i++;
		}
		res=addBinary16(res,new StringBuilder("0000000000000001"));
		return res;
	}

	public static StringBuilder shiftRight(StringBuilder a,StringBuilder q,StringBuilder q1)
	{		
		StringBuilder res=new StringBuilder(String.valueOf(a.charAt(0)));
		res.append(a);
		res.append(q);
		return res;
	}
	public static void btd(StringBuilder a,StringBuilder b)
	{
		StringBuilder res=a.append(b);
		int ans=0;int count=0;
		if(res.charAt(0)=='0')
		{
			int x=Integer.parseInt(String.valueOf(res));
			while(x!=0&&count<16)
			{
				int d=x%10;
				ans+=d*Math.pow(2,count);
				count++;
				x=x/10;
			}
			System.out.println("The answer is = "+ans);
		}
		else
		{
			StringBuilder res1=complementBinary16(res);
			int x=Integer.parseInt(String.valueOf(res1));
			while(x!=0&&count<16)
			{
				int d=x%10;
				ans+=d*Math.pow(2,count);
				count++;
				x=x/10;
			}
			System.out.println("The answer is = -"+ans);
		}
		
	}
}

/*Output:-
1.) 66*10=?
Enter num1:
66
Enter num2:
10
Count: 1 A:00000000 Q:00000101 Q1:0
Count: 2 A:11011111 Q:00000010 Q1:1
Count: 3 A:00010000 Q:10000001 Q1:0
Count: 4 A:11100111 Q:01000000 Q1:1
Count: 5 A:00010100 Q:10100000 Q1:0
Count: 6 A:00001010 Q:01010000 Q1:0
Count: 7 A:00000101 Q:00101000 Q1:0
Count: 8 A:00000010 Q:10010100 Q1:0
A: 00000010 Q: 10010100
The answer is = 660

2.) -66*10=?
Enter num1:
-66
Enter num2:
10
Count: 1 A:00000000 Q:00000101 Q1:0
Count: 2 A:00100001 Q:00000010 Q1:1
Count: 3 A:11101111 Q:10000001 Q1:0
Count: 4 A:00011000 Q:11000000 Q1:1
Count: 5 A:11101011 Q:01100000 Q1:0
Count: 6 A:11110101 Q:10110000 Q1:0
Count: 7 A:11111010 Q:11011000 Q1:0
Count: 8 A:11111101 Q:01101100 Q1:0
A: 11111101 Q: 01101100
The answer is = -660
*/