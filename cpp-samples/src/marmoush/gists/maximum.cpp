#include <iostream.h>
#include <math.h>


int max (int x,int y)
{
	if (x<y) return y;
	else return x;
	
}


void main ()

{
	int m,n;
	do
	{
		cin >>m>>n;
		cout<<"\t"<<max(m,n)<<endl;
	}
	while (n!=0);
}



































