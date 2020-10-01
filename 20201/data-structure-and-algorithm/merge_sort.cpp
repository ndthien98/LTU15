#include <iostream>
#include <fstream>

using namespace std;

int main()
{
  FILE *f;
  int n;
  f = fopen("input.txt", "r");
  fscanf(f,"%d",&n);
  int a[n];
  for (int i = 0; i < n; i++)
  {
    fscanf(f,"%d",&a[i]);    
  }

  fclose(f);
}