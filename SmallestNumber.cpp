#include <bits/stdc++.h>
using namespace std;

long long
countDivisors (long long n)
{
  long long root_n = sqrt (n);

  if (root_n * root_n == n)
    {
      return 1;			// odd
    }
  else
    {
      return 0;			// even
    }
}

long long
solve (long long X)
{
  int p_x = countDivisors (X);

  while (true)
    {
      long long Y = X + 1;
      long long p_result = countDivisors (Y);
      if (p_x != p_result)
	{
	  return Y;
	}
	X++;
    }
}

// Driver program to test above function 
int
main ()
{
  //   generatePrimeFactors(); 
  long long X = 5;
  long long out_;
  out_ = solve (X);
  cout << out_;
  return 0;
}
