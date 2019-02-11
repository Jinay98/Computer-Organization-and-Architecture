import java.util.*;
class FIFO
{
public static void main(String args[])
{
    Scanner sc=new Scanner(System.in);
    char c[]=new char[10];
    System.out.println("enter the char");
    c=sc.next().toCharArray();
    for(int i=0;i<10;i++)
    System.out.println(c[i]);
    int first=0;
    int last=0;
    int count=0;
    int x=0;double fault=0;
    char f[]=new char[4];
    for(int i=0;i<10;i++)
    {
        int index=search(c[i],f);
        
        if(index==-1)
        {
        if(count<=3)
        {
            f[count++]=c[i];
            fault++;
        }
        else
        {
            System.out.println("As " +c[i]+ " is not present thus Replacing and fault is incremented the updated frames are");
            f[x]=c[i];
            x=(x+1)%4;
            fault++;
        }
        for(int j=0;j<f.length;j++)
            System.out.println("F"+(j+1)+" IS ="+f[j]);    
        }
        
        else
        {
            System.out.println("No replacing needed hence the frames are");
            for(int j=0;j<4;j++)
            System.out.println("F"+(j+1) +" is="+f[j]);
        }
    }
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
                
    
    
}