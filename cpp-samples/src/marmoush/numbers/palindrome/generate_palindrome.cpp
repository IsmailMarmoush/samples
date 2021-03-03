
/*
 * File:   newmain.cpp
 * Author: marmoushai
 *
 * Created on October 25, 2010, 11:33 AM
 * palindrome numbers
 */

#include <iostream>
#include <math.h>
using namespace std;

void fun(int start1, int start2, int end);
void fun2(int num);

int main22222222222222222222222222222222222()
{

//    fun(1, 2, 5);

    int max=0,min=11,number=0,m=0,x,n;
    cout<<"Please enter bla bla number"<<endl;
    cin>>n;
    number=n;
    while (n > 0)
    {
        x = n % 10;
        m = m * 10;
        m = m + x;
        n = n / 10;
        cout<<x<<endl;
        if(x>max)
        {
            max=x;
        }
        if(x<=min)
        {
            min=x;
        }

    }
    cout<<"max is "<<max<<endl;
    cout<<"min is "<<min<<endl;
    return 0;
}

void fun(int start1, int start2, int end)
{
    cout << start2 << endl;
    if (start2 < end)
        fun(start1, ++start2, end);
    else if (start2 == end)
        if (start2 > start1)
            fun(start1, --start2, --end);
}
