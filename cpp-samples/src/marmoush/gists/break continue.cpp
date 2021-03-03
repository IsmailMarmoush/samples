#include<iostream.h>
void main()
{
	int n;
	for (;;)
	{
		cout<<"enter int :";
		cin>>n;
		if (n % 2==0)continue;
		if (n % 3==0) break;
		cout<<"bottom of loop \n";
	}
	cout <<"outside of loop \n";
}

