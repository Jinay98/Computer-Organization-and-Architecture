import java.util.Scanner;
class Worstfit
{
	static int partitions[]=new int[5];
	static int blocks[]=new int[5];
	static boolean flag[]=new boolean[5];
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int choice =0;
		System.out.println("Enter the partitions");
		for(int i=0;i<partitions.length;i++)
		{
			partitions[i]=sc.nextInt();
		}
		System.out.println("Enter the blocks");
		for(int i=0;i<blocks.length;i++)
		{
			flag[i]=false;
			blocks[i]=sc.nextInt();
		}
		while(choice!=4)
		{
			System.out.println("Enter 1. For WorstFit");
			System.out.println("Enter 2. For FirstFit");
			System.out.println("Enter 3. For BestFit");
			System.out.println("Enter 4.Exit");
			System.out.println("Enter choice");
			choice=sc.nextInt();
		
			switch(choice)
			{
				case 1:
				WF(partitions,blocks);
				break;
				case 2:
					FF(partitions,blocks);
					break;
				case 3:
					BF(partitions,blocks);
					break;
				case 4: 
				break;
			}
		}
		sc.close();
	}
	static void WF(int partitions[],int blocks[])
	{
		int temp[]=new int[partitions.length];
		for(int i=0;i<partitions.length;i++)
			temp[i]=partitions[i];
		sort(temp);
		for(int i=0;i<blocks.length;i++)
		{
			if(blocks[i]<=temp[0])
			{	
				System.out.println(blocks[i]+ " has  been allocated to " +temp[0]);
				temp[0]=temp[0]-blocks[i];
 				
				System.out.println("New value of partition is "+temp[0]);
				sort(temp);
                        }
			else
				System.out.println(blocks[i]+ " has not been allocated");
		}
	}
	static void FF(int partitions[],int blocks[])
	{
		int temp[]=new int[partitions.length];
		for(int i=0;i<partitions.length;i++)
			temp[i]=partitions[i];
		int count=0;
		for(int i=0;i<blocks.length;i++)
		{
			count=0;
			for(int j=0;j<temp.length;j++)
			{
				if(blocks[i]<=temp[j])
				{
					System.out.println(blocks[i]+ " has  been allocated to " +temp[j]);
					temp[j]=temp[j]-blocks[i];
					System.out.println("New value of partition is "+temp[j]);
					break;
				}
				else
				{
					count++;
				}
			}
			if(count==temp.length)
			{
				System.out.println(blocks[i]+ " has not been allocated");
			}
		}
		
}
static void BF(int partitions[],int blocks[])
{
	int temp[]=new int[partitions.length];
	int x[]=new int[partitions.length];
	for(int i=0;i<partitions.length;i++)
			temp[i]=partitions[i];
	int index=0;
	for(int i=0;i<blocks.length;i++)
	{
		for(int k=0;k<x.length;k++)
			x[k]=999;
		index=0;
		for(int j=0;j<temp.length;j++)
			{
				if(temp[j]>=blocks[i])
				{
					x[index++]=temp[j];
				}
			}
			if(index==0)
				System.out.println(blocks[i]+ " has not been allocated");
			else
			{
				int minind=min(x);
				System.out.println(blocks[i]+ " has  been allocated to " +x[minind]);
				int ind=search(x[minind],temp);
				temp[ind]=temp[ind]-blocks[i];
				System.out.println("New value of partition is "+temp[ind]);
			}
	}
}
	static void sort(int a[])
	{
		int temp,i,j;
		for (i = 0 ; i < ( a.length-1); i++)
		{
    			for (j= 0 ; j < a.length - i - 1; j++)
			{
      				if(a[j] < a[j+1])
				{
        				temp=a[j];
        				a[j]   = a[j+1];
        				a[j+1] = temp;
      				}
    			}
  		}
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
	static int search(int x,int a[])
	{
		int index=-1;
		for(int i=0;i<a.length;i++)
		{
			if(x==a[i])
			{
				index=i;
				break;
			}
		}
		return index;
	}
}	
		
