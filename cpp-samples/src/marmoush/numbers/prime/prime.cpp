#include <iostream.h>
#include <conio.h>
#include <stdlib.h>
void main()
{
	cout<<"enter the number";

		long n;
	cin >>n;
	if (n<2) cout <<n<< "is not a prime number"<<endl ;
	else if (n<4) cout <<n << "is a prime."<<endl;
	else if (n%2==0)cout <<n<<"=2"<<n/2<<endl;

	else
	{
		for (int d=3;d<=n/2;d+=2)
			if (n % d == 0)
			{
			cout <<n <<"="<<d<<" "<<n/d<<endl;
	
				exit(0);
			}
			cout <<n<<"is prime"<<endl;
			
	}
}