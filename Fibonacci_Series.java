import java.io.*;
import java.util.*;

class fibonacci {

	static int fibSum(int N){
		if (N <= 0)
			return 0;

		int fib[] = new int[2 * N + 1];
		fib[0] = 0;
		fib[1] = 1;

		int s = 0;

		for (int j = 2; j <= N+1; j++) {
			fib[j] = fib[j - 1] + fib[j - 2];
			
		}
		int temp=0;
		while(temp<=N){
			s+=fib[temp];
			temp+=1;
		}

		return s;
	}

	public static void main(String[] args)
	{
		Scanner obj = new Scanner(System.in);
		System.out.print("Enter a number: ");
        int N = obj.nextInt();
		System.out.println("Sum of fibonacci series till number " + N + " is: " + fibSum(N));
	}
}
