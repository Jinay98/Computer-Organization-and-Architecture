import java.util.*;
public class optimal {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	    char c[]=new char[10];
	    char f[]=new char[4];
	    int freq[]=new int[4];
	    for(int i=0;i<4;i++)
	    	freq[i]=0;
	    int hit=0;int count=0;int count1=0;
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
		        	
		            f[count++]=c[i];
		            for(int j=0;j<f.length;j++)
		                System.out.println("F"+(j+1)+" IS ="+f[j]);    
		        }
		        else
		        {
		        	System.out.println("As "+c[i]+" is not present we replace it optimally");
		        	for(int j=0;j<f.length;j++)
		        	{
		        		for(int k=i+1;k<10;k++)
		        		{
		        		
		        			if(f[j]==c[k])
		        			{
		        				
		        				freq[j]++;
		        			}
		        		}
		        	}
		        	

		        	int minind=min(freq);

		        	System.out.println("Thus replacing "+f[minind]+ " with "+c[i]);
		        	f[minind]=c[i];
		        	for(int j=0;j<f.length;j++)
		                System.out.println("F"+(j+1)+" IS ="+f[j]);    
		        	
		        		for(int j=0;j<f.length;j++)
		        		freq[j]=0;
		        }
	        }
	        else
	        {
	        	hit++;
	        	System.out.println("Increment the no.of hits as "+c[i]+" is present in the files");
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
	static int min(int a[])
	{
		int m=a[0];int index=0;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]<m)
			{
				m=a[i];
				index=i;
			}
		}
		return index;
	}

}
