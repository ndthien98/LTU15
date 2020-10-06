#include <iostream>
using namespace std;

const int NUM = 8;

int banco[NUM][NUM];
int c = 0;
bool checkvalid_ij(int x, int y)
{
  for (int i = 0; i < NUM; i++)
  {
    if (banco[x][i] == 1)
      return false;
    if (banco[i][y] == 1)
      return false;
  }
  for (int i = 0; i < NUM; i++)
  {
    for (int j = 0; j < NUM; j++)
    {
      if (i + j == x + y && banco[i][j] == 1)
        return false;
      if (i - j == x - y && banco[i][j] == 1)
        return false;
    }
  }

  return true;
}
void hienthibanco()
{
  cout << "===========" << ++c << endl;
  for (int i = 0; i < NUM; i++)
  {
    for (int j = 0; j < NUM; j++)
    {
      cout << (banco[i][j] == 0 ? " - " : " q ");
    }
    cout << endl;
  }
}
void xephau(int h)
{
  if (h == NUM)
  {
    hienthibanco();
  }
  else
  {
    for (int c = 0; c < NUM; c++)
    {
      if (checkvalid_ij(h, c))
      {
        banco[h][c] = 1;
        xephau(h + 1);
        banco[h][c] = 0;
      }
    }
  }
}

int main()
{
  for (int i = 0; i < NUM; i++)
  {
    for (int j = 0; j < NUM; j++)
    {
      banco[i][j] = 0;
    }
  }
  xephau(0);
}