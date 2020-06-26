#include <iostream>

using namespace std;
int k = 0;
string ll;
char ch;
int sx[1000];
int n = 0;

void nextCh()
{
    //printf("nextCh: %c\n",ch);
    ch = ll.at(k++);
}
void S();
void A();
void B();
void C();
void D();
void S()
{
    printf("1. S->BA\n");
    sx[n++] = 1;
    B();
    A();
}
void A()
{

    if (ch == '+')
    {
        printf("2. A->+BA\n");
        sx[n++] = 2;
        nextCh();
        B();
        A();
    }
    else
    {
        printf("3. A->e\n");
        sx[n++] = 3;
    }
}

void B()
{
    printf("4. B->DC\n");
    sx[n++] = 4;
    D();
    C();
}

void C()
{
    if (ch == '*')
    {
        printf("5. C-> *DC\n");
        sx[n++] = 5;
        nextCh();
        D();
        C();
    }
    else
    {
        printf("6. C-> e\n");
        sx[n++] = 6;
    }
}
void D()
{
    if (ch == '(')
    {
        printf("7. D->(S)\n");
        sx[n++] = 7;
        nextCh();
        S();
        if (ch == ')')
        {
            nextCh();
        }
    }
    else if (ch == 'a')
    {
        printf("8. D->a\n");
        sx[n++] = 8;
        nextCh();
    }
}

int main()
{
    cout << "INPUT: ";
    cin >> ll;
    ll = ll + "#";
    cout << "LL: " << ll << endl;
    nextCh();
    S();
    if (ch == '#')
    {
        printf("OK: ");
        for (int i = 0; i < n; i++)
        {
            printf("%d", sx[i]);
        }
    }
    else
    {
        printf("Error");
    }
}
