import java.io.*;
import java.util.*;

class Level2 
{
	
	static int X = 0;
	static boolean sieve[] = new boolean[1000000];
	
	public static void main (String args[])throws IOException
	{
		System.out.println("Enter the minimum number");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int a = 0;
		int b = 1;
		
		prime();
		
		while((b <= n) || sieve[b] == true)
		{
			int temp = b;
			b = a + b;
			a = temp;
		}
		X = b;
		
		System.out.println(sum (X + 1));
		
	}
	
	public static void prime()
	{
		//let false denote that the ith number is a prime in the sieve
		sieve[0] = true;
		sieve[1] = true;
		for(int i = 2; i < 998; i ++)
		{
			if(sieve[i] == true)
				continue;
			else
			{
				int a = i;
				for(int j = i*i; j < 1000000; j += a)
				{
					sieve[j] = true;
				}
			}
		}
	}
	
	public static int sum(int a)
	{
		int sum = 0;
		if(a % 2 == 0)
			sum = 2;
		for(int i = 3; i <= Math.ceil(Math.sqrt ((double) a)); i += 2)
		{
			if(sieve[i] == false && a % i == 0)
			{
				sum = sum + i;
			}
		}
		return sum;
	}
}