/*Name:jinay Parekh
 * Batch:C Roll No:46*/
//Division
import java.util.*;
class Controllerdiv
{
    public static void main(String args[])
    {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter the Dividend");
    	int q_input=sc.nextInt();
    	System.out.println("Enter the Divisor");
    	int m_input=sc.nextInt();
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

        System.out.println("m: "+m+" m_c: "+m_c+" q: "+q);

        int count=1;

        while(count<=8)
        {
            StringBuilder res=shiftLeft(a,q);

            a=new StringBuilder(res.substring(0,8));
            q=new StringBuilder(res.substring(8,16));

            a=addBinary(a,m_c);


            if(a.charAt(0)=='1')
            {
                q.setCharAt(7,'0');
                a=addBinary(a,m);
            }else{
                q.setCharAt(7,'1');
            }

            System.out.println("Count: "+count+" A: "+a+" Q: "+q);

            count++;
        }
        System.out.println("A: "+a+" Q: "+q);
        System.out.print("the quotient is =");
        btd(q);
        System.out.println("");
        System.out.print("the remainder is =");
        btd(a);

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

    public static StringBuilder shiftLeft(StringBuilder a,StringBuilder q)
    {
        StringBuilder res=new StringBuilder();
        res.append(a.substring(1));
        res.append(q);
        res.append('0');
        return res;
    }
    public static void btd(StringBuilder a)
	{
		StringBuilder res=a;
		int ans=0;int count=0;
		int x=Integer.parseInt(String.valueOf(res));
			while(x!=0&&count<8)
			{
				int d=x%10;
				ans+=d*Math.pow(2,count);
				count++;
				x=x/10;
			}
		System.out.print(ans);
	}
}
/*Output:-
1.)
Enter the Dividend
35
Enter the Divisor
16
m: 00010000 m_c: 11110000 q: 00100011
Count: 1 A: 00000000 Q: 01000110
Count: 2 A: 00000000 Q: 10001100
Count: 3 A: 00000001 Q: 00011000
Count: 4 A: 00000010 Q: 00110000
Count: 5 A: 00000100 Q: 01100000
Count: 6 A: 00001000 Q: 11000000
Count: 7 A: 00000001 Q: 10000001
Count: 8 A: 00000011 Q: 00000010
A: 00000011 Q: 00000010
the quotient is =2
the remainder is =3
2.)

*/