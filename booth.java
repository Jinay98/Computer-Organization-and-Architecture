
public class booth {
int [] dtb(int n)
{
	int a[]=new int[8];
	
	int index=0;
	int i=0;
	//int k=0;//int count=0;
	//if(n<Math.pow(2, count)) 
	//{
		//System.out.println("Normal case");	
	int temp[]=new int[8];
	while(n!=0)
	{
		int digit=n%2;
		//System.out.println(digit);
		a[i++]=digit;
		n/=2;
		//count++;
	}
	for(int j=i;j<=7;j++)
		a[j]=0;
	for(int j=a.length-1;j>=0;j--)
	{
		temp[index++]=a[j];
		//System.out.print(temp[j]);
	}
		//
	return temp;
}
	/*else
	{
		System.out.println("AbNormal case");	
		int temp[]=new int[count+1];
		while(n!=0)
		{
			int digit=n%2;
			//System.out.println(digit);
			a[k++]=digit;
			n/=2;
			//count++;
		}
		for(int j=k;j<=count-1;j++)
			a[j]=0;
		for(int j=a.length-1;j>=0;j--)
		{
			temp[index++]=a[j];
			//System.out.print(temp[j]);
		}
		return temp;
	}*/
	//return temp;

int btd(int a[])
{
	int x=7;
	int ans=0;
	for(int i=0;i<=7;i++)
	{
		ans+=Math.pow(2,x)*a[i];
		x--;
		//System.out.println(ans);
	}
	return ans;
}
int btdfinal(int a[])
{
	int x=15;
	int ans=0;
	for(int i=0;i<=15;i++)
	{
		ans+=Math.pow(2,x)*a[i];
		x--;
		//System.out.println(ans);
	}
	return ans;
}
int [] twocomp(int n)
{
	int ans[]=new int[8];
	int x=n*-1;int count=0;
	int temp[]=dtb(x);
	
for(int i=temp.length-1;i>=0;i--) {
			
			if(temp[i]==0) {
				ans[i]=0;
				}
			if(temp[i]==1&&count==0)
			{
				ans[i]=1;
				count++;
			}
			else {
			if(temp[i]==1&&count!=0)
				ans[i]=0;
			if(temp[i]==0&&count!=0)
				ans[i]=1;
			}
		}

		return ans;
	
}
int [] twocompfromarray(int temp[])
{
	int ans[]=new int[8];
	int count=0;
	for(int i=temp.length-1;i>=0;i--) {
		
		if(temp[i]==0) {
			ans[i]=0;
			}
		if(temp[i]==1&&count==0)
		{
			ans[i]=1;
			count++;
		}
		else {
		if(temp[i]==1&&count!=0)
			ans[i]=0;
		if(temp[i]==0&&count!=0)
			ans[i]=1;
		}
	}

	return ans;
	
}
int[] rshift(int n[])
{
	int temp=n[0];
	int a[]=new int[n.length];
	for(int i=1;i<a.length-1;i++)
	{
		a[i+1]=n[i];
	}
	a[1]=temp;
	a[0]=temp;
	return a;
				
}
void calc(int M,int Q)
{
	int a[]=new int[8];
	
	for(int i=0;i<a.length;i++)
		a[i]=0;
	int q[]=dtb(Q);
	int count=q.length;
	int q1=0;int ans;
	System.out.println("Value of q0 initial is= "+q1);
	while(count!=0)
	{
		if(q[7]==q1) {
			System.out.println("In the same condition");
			q1=q[7];
			System.out.println("Value of q0= "+q1);
			q=rshift(q);
			q[0]=a[7];
			System.out.println("Value of q= ");
			for(int i=0;i<q.length;i++)
				System.out.print(q[i]);
			System.out.println("");
			System.out.println("Value of a= ");
			a=rshift(a);
			for(int i=0;i<a.length;i++)
				System.out.print(a[i]);
			System.out.println("");
			count--;
		}
		else if(q1==0&&q[7]==1)
		{
			System.out.println("In the 10 condition");
			ans=btd(a);
			ans=ans-M;
			if(ans>=0)
			{
				a=dtb(ans);
			}
			else
			{
				a=twocomp(ans);
			}
			q1=q[7];
			System.out.println("Value of q0= "+q1);
			q=rshift(q);
			q[0]=a[7];
			System.out.println("Value of q= ");
			for(int i=0;i<q.length;i++)
				System.out.print(q[i]);
			System.out.println("");
			System.out.println("Value of a= ");
			a=rshift(a);
			for(int i=0;i<a.length;i++)
				System.out.print(a[i]);
			System.out.println("");
			count--;
			
		}
		else
		{
			System.out.println("In the 01 condition");
			ans=btd(a);
			ans=ans+M;
			if(ans>=0)
			{
				
					a=dtb(ans);
				
			}
			else
			{
				a=twocomp(ans);
			}
			q1=q[7];
			System.out.println("Value of q0= "+q1);
			q=rshift(q);
			q[0]=a[7];
			System.out.println("Value of q= ");
			for(int i=0;i<q.length;i++)
				System.out.print(q[i]);
			System.out.println("");
			System.out.println("Value of a= ");
			a=rshift(a);
			for(int i=0;i<a.length;i++)
				System.out.print(a[i]);
			System.out.println("");
			count--;
		}
	}
	System.out.println("");System.out.println("");System.out.println("");
	int finans[]=new int[2*8];
	int ind=0;
	for(int i=0;i<a.length;i++)
		{
		finans[ind++]=a[i];
		System.out.print(a[i]);
		
		}
	for(int i=0;i<a.length;i++) 
	{
		finans[ind++]=q[i];
		System.out.print(q[i]);
	}
	System.out.println("Final ans is");
	for(int i=0;i<finans.length;i++)
		System.out.print(finans[i]);
	if(finans[0]==0)
	{
		System.out.println("Decimal ans is= "+btdfinal(finans));
	}
	else
	{
		int x[]=twocompfromarray(finans);
		System.out.println("Decimal ans is= -"+btdfinal(x));
	}
}
		
public static void main(String args[])
{
	
	booth obj=new booth();
	obj.calc(77,3);
	/*int temp[]=obj.dtb(7,4);
	for(int i=0;i<temp.length;i++)
		System.out.print(temp[i]);
	System.out.println("Hi");
	int m=obj.btd(temp,4);
	int temp1[]=obj.twocomp(-7,4);
	for(int i=0;i<temp1.length;i++)
		System.out.print(temp1[i]);
	int x[]=obj.rshift(temp);
	System.out.println("Shifting");
	for(int i=0;i<x.length;i++)
		System.out.print(x[i]);
	System.out.println("");System.out.println("");System.out.println("");*/
	
	
				
}
}
