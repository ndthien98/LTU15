#include <iostream>

using namespace std;

int fibo(int n)
{
  if (n == 1 || n == 2)
    return 1;
  else
    return fibo(n - 1) + fibo(n - 2);
}
int main()
{
  for (int i = 1; i < 10; i++)
  {
    int fi = fibo(i);
    printf("%d ", fi);
  }
  
}