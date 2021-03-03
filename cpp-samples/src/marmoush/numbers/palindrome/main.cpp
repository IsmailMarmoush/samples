#include <iostream>
#include <cstring>
using namespace std;

void check_palindrome();
void fun(int, int, char[]);
int main()
{
    check_palindrome();
    return 0;
}
void check_palindrome()
{
    char str[100];
    cout << "Enter word :";
    cin >> str;
    int x = strlen(str) - 1;
    fun(0, x, str);
}
void fun(int start, int size, char str[])
{
    bool check = 1;
    if (str[start] == str[size - start])
    {
        if (start <= size)
        {
            fun(++start, size, str);
        }
    }
    else
    {
        cout << "Not a palidrome" << endl;
        check = 0;
    }
    if (check&&start==size)cout << "Indeed Palidrome" << endl;
}
