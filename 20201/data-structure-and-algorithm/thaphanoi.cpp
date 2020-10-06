#include <iostream>

using namespace std;
int a;
int b;
int c;
void count(char from, char to)
{
  switch (from)
  {
  case 'A':
    a--;
    break;
  case 'B':
    b--;
    break;
  case 'C':
    c--;
    break;
  default:
    break;
  }
  switch (to)
  {
  case 'A':
    a++;
    break;
  case 'B':
    b++;
    break;
  case 'C':
    c++;
    break;
  default:
    break;
  }
  printf("%d %d %d \n", a, b, c);
}
void thaphanoi(char source, char destination, char temp, int sodia)
{
  if (sodia == 1)
  {
    printf("Chuyen 1 dia tu cot %c sang cot %c: ", source, destination);
    count(source, destination);
  }
  else
  {
    thaphanoi(source, temp, destination, sodia - 1);
    printf("Chuyen 1 dia tu cot %c sang cot %c: ", source, destination);
    count(source, destination);
    thaphanoi(temp, destination, source, sodia - 1);
  }
}

int main()
{
  a = 3;
  printf("Trang thao ban dau: %d %d %d \n", a, b, c);
  thaphanoi('A', 'B', 'C', a);
}