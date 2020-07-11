#include <iostream>
#include <cstring>
#include <stdio.h>
using namespace std;
int delta[4][2] = {1,0,1,2,1,3,1,0}; // (a+b)*abb
int i, L;
char str[100];
int q = 0;
int D = 3;
int main()
{
    cout << "Nhap xau: ";
    cin >> str;
    cout << "INPUT: " << str << " => ";
    i = 0;
    L = strlen(str);
    while (i < L)
    {
        char c = str[i];
        if (c == 'a' || c == 'b')
        {
            q = delta[q][c];
            i++;
        }
        else
        {
            cout << "WRONG INPUT";
            break;
        }
    }
    if (i == L)
    {
        if (q == D)
            cout << ": TRUE";
        else
           cout << "FALSE";
    }

}