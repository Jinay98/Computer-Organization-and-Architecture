import java.util.*;
class LRU
{
	public static void main(String args[])
	{
	    Scanner sc=new Scanner(System.in);
	    char c[]=new char[10];
	    char f[]=new char[4];
	    char temp[]=new char[4];
	    int count=0;int count1=0;
	    
	    int hit=0;
	    System.out.println("Enter the char");
	    c=sc.next().toCharArray();
	    for(int i=0;i<10;i++)
	    System.out.println(c[i]);
	    for(int i=0;i<10;i++)
	    {
	        int index=search(c[i],f);
	        if(index==-1)
	        {
		        if(count<=3)
		        {
		        	temp[count1++]=c[i];
		            f[count++]=c[i];
		          
		            for(int j=0;j<f.length;j++)
		                System.out.println("F"+(j+1)+" IS ="+f[j]);    
		        }
		        else
		        {
		        	System.out.println("As "+c[i]+" is not present we replace it with Least recently used element");
		        	char rep=temp[0];
		        	int repindex= search(rep,f);
		        	f[repindex]=c[i];
		        	temp[0]=c[i];
		        	LRU.leftshift(temp,0);
		       
		        	for(int j=0;j<f.length;j++)
		                System.out.println("F"+(j+1)+" IS ="+f[j]);    
		        }
	        }
	        else
	        {
	        		int tempind=search(c[i],temp);
	        		
	        		hit++;
		        	System.out.println("Increment the no.of hits as "+c[i]+" is present in the files");
		        	LRU.leftshift(temp,tempind);
		        	
		        	System.out.println("Since "+c[i]+" is present in file we dont change anything");
		        	for(int j=0;j<f.length;j++)
		                System.out.println("F"+(j+1)+" IS ="+f[j]);    
	        }
	    }
	    
	    double fault=10-hit;
	    System.out.println("The fault rate is ="+(fault/10));    
	}
	    public static int search(char ch,char f[])
	    {
	        int index=-1;
	        for(int i=0;i<f.length;i++)
	        {
	            if(ch==f[i])
	            {
	                index=i;
	                break;
	            }
	        }
	        return index;
	    }
	    public static void leftshift(char c[],int index)
	    {
	    	char x=c[index];
	    	
	    	for(int i=index+1;i<c.length;i++)
	    	{
	    		c[i-1]=c[i];
	    	}
	    	c[c.length-1]=x;
	    }
}
