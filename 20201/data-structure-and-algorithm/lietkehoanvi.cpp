#include <iostream>
using namespace std;

void lietke(int n)
{
  int x[n];
  for (int i = 0; i < n; i++)
  {
    x[i] = i + 1;
  }
  int count = 0;
  while (true)
  {
    count++;
    for (int i = 0; i < n; i++)
    {
      printf("%d ", x[i]);
    }
    cout << " count: " << count << endl;
    int key = n - 1;
    // find the key
    while (x[key] < x[key - 1] && key != 0)
    {
      key--;
    }
    key--;

    // check if key < 0 => break;
    if (key < 0)
      break;
    // find the minimum number bigger than x[key] and swap with x[key]
    int max = key + 1;
    for (int i = key + 1; i < n; i++)
    {
      if (x[i] > x[key])
        max = i;
      else
        break;
    }
    x[max] = x[key] + x[max];
    x[key] = x[max] - x[key];
    x[max] = x[max] - x[key];

    // revert
    int start = key + 1;
    int end = n - 1;
    while (start < end)
    {
      x[start] = x[start] + x[end];
      x[end] = x[start] - x[end];
      x[start] = x[start] - x[end];
      start++;
      end--;
    }
  }
}
int main()
{
  lietke(5);
}