#include <iostream>

using namespace std;

int tohop(int k, int n)
{
  if (k == 0 || k == n)
  {
    return 1;
  }
  return tohop(k - 1, n - 1) + tohop(k, n - 1);
}
int main()
{
  int k = 6;
  int n = 10;
  int th = tohop(k, n);
  printf("To hop %d cua %d : %d \n", k, n, th);
}
