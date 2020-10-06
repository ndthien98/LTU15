#include <iostream>

using namespace std;

void fibo(int n)
{
  int f[n];
  f[0] = 1;
  f[1] = 1;
  for (int i = 2; i < n; i++)
  {
    f[i] = f[i - 1] + f[i - 2];
  }
  for (int k = 0; k < n; k++)
  {
    printf("%d ",f[k]);
  }
  
}
int main()
{
  fibo(10);
}