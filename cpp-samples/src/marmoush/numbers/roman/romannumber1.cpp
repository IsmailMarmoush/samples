#include <iostream.h>
//#include <stdlib.h>
//using namespace std;

 char   fun(int roman)
{
	switch (roman)
	{ case 1: cout<<"hi";break;
	case 20: cout<<"hello"<<endl;break;
	case 3:cout<<"no"<<endl;break;
	
	
	 return 0;
 }}

void main()
{
	int x,y,z,x1,x2,roman;
	
	cin>>x;
	y=x;
	
	{
		x=x/100;
		x=x*100;
		roman=x;
	cout<<fun(roman)<<endl;
	}
	x1=y%100;
	
	
	z=x1;
	
	{
		x1=x1/10;
		x1=x1*10;
		roman=x1;
	cout<<fun(roman)<<endl;
	}
	x2=z%10;


	roman=x2;
	cout<<fun(roman)<<endl;


}


