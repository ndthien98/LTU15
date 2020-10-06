#include "iostream"
using namespace std;

int findBinary(int *array, int left, int right, int value)
{
  if (left > right)
    return -1;
  int key = (left + right) / 2;
  if (array[key] == value)
  {
    return key;
  }
  if (array[key] > value)
  {
    return findBinary(array, left, key - 1, value);
  }
  if (array[key] < value)
  {
    return findBinary(array, key + 1, right, value);
  }
  return -1;
}

int main(int argv, char *args[])
{
  int n = 10;
  int k = 3;
  int array[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
  int f = findBinary(array, 0, n, k);
  printf("Tim thay phan tu %d tai vi tri %d\n",k,f);
}