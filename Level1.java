import java.io.*;
import java.util.*;

public class Level1 
{
	public static void main(String args[])throws IOException
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		int len = s.length();
		
		int best_len = 0;
		int cen = 0;
		String long_pali = "";
		
		for(int i = 0; i < (2*len - 1); i ++)
		{
			
			int j = i/2;
			int c = 1;
			
			if(i % 2 == 0)
			{				
				while(((j - c) >= 0) && ((j + c) < len) && (s.charAt(j - c) == s.charAt(j + c)))
				{
					c ++;
				}
				
				if((c * 2 - 1) > best_len)
				{
					best_len = c * 2 - 1;
					cen = i/2;
				}
			}
			
			else
			{
				while((j - c + 1) >= 0 && (j + c) < len && s.charAt(j - c + 1) == s.charAt(j + c))
				{
					c ++;
				}
				if(2 * (c - 1) > best_len)
				{
					best_len = 2 * (c - 1);
					cen = i/2;
				}
			}
		}
		if(best_len % 2 == 0)
			long_pali = s.substring(cen - best_len/2 + 1, cen + best_len/2 + 1);
		else
			long_pali = s.substring(cen - best_len/2, cen + best_len/2 + 1);
		System.out.println(long_pali);
	}
}