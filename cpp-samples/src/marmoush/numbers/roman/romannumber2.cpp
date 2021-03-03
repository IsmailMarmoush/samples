#include <iostream.h>
#include <math.h>

void main()
{
	int x,y,z,x1,x2;
	
	cin>>x;
	y=x;
	
	{
		x=x/100;
		x=x*100;
		cout<<x<<endl;
	}
	x1=y%100;
	
	
	z=x1;
	
	{
		x1=x1/10;
		x1=x1*10;
		cout<<x1<<endl;
	}
	x2=z%10;
	cout<<x2<<endl;


}