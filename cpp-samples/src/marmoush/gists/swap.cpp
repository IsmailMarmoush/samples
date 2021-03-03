#include <iostream.h>


void swap (float& x,float& y)
{
	float temp =x;
	x=y;
	y=temp;
}


void main()
{float a,b;
	do{
	
	cout<<"enter any two numbers:";
	cin>>a>>b;
	cout<<"a="<<a<<"\t b="<<b<<endl;
	swap (a,b);
	cout<<"a="<<a<<"\t b="<<b<<endl;}
	while (a!=1);


}