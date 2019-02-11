/*NAME-JINAY PAREKH
SE COMPS ROLL NO 46 BATCH C*/
import java.util.*;
class Driver
{
    static double pma_length,line_size,cache_line;
    public static void main(String args[])
    {
        Scanner input=new Scanner(System.in);
        int choice=1;
        System.out.println("Input the length of PMA");
        pma_length=input.nextDouble();
        System.out.println("Input block size/linesize");
        line_size=input.nextDouble();
        System.out.println("Input no of lines in cache");
        cache_line=input.nextDouble();
        while(choice!=0)
        {
            System.out.print("Enter Option \n1.Direct\n2.Associative\n3.Set-Associative");
            int option=input.nextInt();
            switch(option)
            {
                case 1: finddirect();
                        break;
                case 2: findassoc();
                        break;  
                case 3: findsetass();
                	break;
            }
            System.out.println("1 to continue 0 to exit");
            choice=input.nextInt();
        }    
    }
    static void finddirect()
    {
        double add=Math.pow(2,Driver.pma_length);
        System.out.println("No of addressable unit is" +add);
        double word=Math.log(Driver.line_size)/Math.log(2);
        double blocks=add/Driver.line_size;
        System.out.println("No of blocks in MM is:"+blocks+" blocks");
        double line=Math.log(Driver.cache_line)/Math.log(2);
        double s=Math.log(blocks)/Math.log(2);
        double size_cache=Driver.cache_line* Driver.line_size;
        System.out.println("Size of cache is:" +size_cache+ " words");
        double tag=s-line;
        System.out.println("Size of tag is" +tag);
        for(int i=0;i<2;i++)
        {
            System.out.println("Input block no you wish to see less than " +blocks);
            Scanner scn=new Scanner(System.in);
            int blockno=scn.nextInt();
            System.out.println("The required block is stored in line " +blockno% Driver.cache_line);
        }  
    }
    static void findassoc()
    {
        double add=Math.pow(2,Driver.pma_length);
        System.out.println("No of addressable unit is" +add);
        double word=Math.log(Driver.line_size)/Math.log(2);
        double blocks=add/Driver.line_size;
        System.out.println("No of blocks in MM is:"+blocks+" blocks");
        double tag=Math.log(blocks)/Math.log(2);
        System.out.println("Size of tag is" +tag);
    }
    static void findsetass()
    {
    	Scanner input1=new Scanner(System.in);
    	double add=Math.pow(2,Driver.pma_length);
        System.out.println("No of addressable unit is" +add);
        double blocks=add/Driver.line_size;
        System.out.println("No of blocks in MM is:"+blocks+" blocks");
        System.out.println("Enter no of lines in set");
        double k=input1.nextInt();
        double set=Driver.cache_line/k;
        System.out.println("Thus no of sets is:" + set);
        double d=Math.log(set)/Math.log(2);
        double s=Math.log(blocks)/Math.log(2);
        double size_cm=k*set*Driver.line_size;
        System.out.println("Size of cache is:" +size_cm+" words");
        double tagnew=s-d;
        System.out.println("Tag bit is:" +tagnew);
        
        
    }
}
/*OUTPUT

Input the length of PMA
25
Input block size/linesize
128
Input no of lines in cache
64
Enter Option 
1.Direct
2.Associative
3.Set-Associative1
No of addressable unit is3.3554432E7
No of blocks in MM is:262144.0 blocks
Size of cache is:8192.0 words
Size of tag is12.0
Input block no you wish to see less than 262144.0
26
The required block is stored in line 26.0
Input block no you wish to see less than 262144.0
790
The required block is stored in line 22.0
1 to continue 0 to exit
1
Enter Option 
1.Direct
2.Associative
3.Set-Associative2
No of addressable unit is3.3554432E7
No of blocks in MM is:262144.0 blocks
Size of tag is18.0
1 to continue 0 to exit
1
Enter Option 
1.Direct
2.Associative
3.Set-Associative3
No of addressable unit is3.3554432E7
No of blocks in MM is:262144.0 blocks
Enter no of lines in set
8
Thus no of sets is:8.0
Size of cache is:8192.0 words
Tag bit is:15.0
1 to continue 0 to exit
0
*/