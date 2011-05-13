import java.io.*;
import java.util.*;

public class Level3 
{
	public static void main(String args[])throws IOException
	{
		Vector<Integer> v = new Vector<Integer>();
		File file = new File("numbers.txt");
		Scanner sc = new Scanner(file);
		sc.useDelimiter(", ");
		
		while(sc.hasNext())
		{
			int n = sc.nextInt();
			v.add(n);
		}
		
		int count = 0;
		
		for(long i = 0; i < (1 << v.size()); i ++)
		{
			Vector<Integer> w = new Vector<Integer>();
			for(int j = 0; j < v.size(); j ++)
			{
				if(((i >> j) & 1) == 1)
					w.add(v.elementAt(j));
			}
			
			if(w.size() > 1)
			{
				int sum = 0;
				for(int k = 0; k < (w.size() - 1); k ++)
					sum = sum + w.elementAt(k);
			
				if(w.elementAt(w.size() - 1) == sum)
					count ++;
			}
		}	
		
		System.out.println(count);
	}
}
