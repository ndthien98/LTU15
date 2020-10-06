#include <iostream>

using namespace std;

void ckn(int n, int k)
{
  int c[n+1][k+1];
  for (int i = 0; i <= n; i++)
  {
    for (int j = 0; j <= k; j++)
    {
      c[i][j] = 0;
    }
  }
  for (int i = 0; i <= n; i++)
  {
    for (int j = 0; j <= k; j++)
    {
      if (j == 0 || i == j)
        c[i][j] = 1;
      else
      {
        c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
      }
    }
  }
  for (int i = 0; i <= n; i++)
  {
    for (int j = 0; j <= k; j++)
    {
      printf("%d\t",c[i][j]);
    }
    printf("\n");
  }
  printf("To hop %d cua %d: %d \n",k,n,c[n][k]);
}
int main()
{
  ckn(10, 6);
}