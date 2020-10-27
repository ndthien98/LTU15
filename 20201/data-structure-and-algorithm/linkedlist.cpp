#include <iostream>
using namespace std;

struct Polynomial
{
  int coeff;
  int pow;
  struct Polynomial *next;
} *PPoly;

int main(int argc, char const *argv[])
{
  cout << sizeof(Polynomial);
  Polynomial *p1;
  p1 = (PPoly)malloc(sizeof(Polynomial));

  return 0;
}
