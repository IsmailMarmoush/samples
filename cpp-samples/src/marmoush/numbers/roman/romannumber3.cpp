#include <iostream.h>
//#include <stdlib.h>
//using namespace std;

 char   fun(int roman)
{
	switch (roman)
	{ 
	case 0:cout<<""<<endl;break;
	case 1: cout<<"I";break;
	case 2: cout<<"II"<<endl;break;
	case 3:cout<<"III"<<endl;break;
	case 4:cout<<"IV"<<endl;break;
	case 5:cout<<"V"<<endl;break;
	case 6:cout<<"VI"<<endl;break;
	case 7:cout<<"VII"<<endl;break;
	case 8:cout<<"VIII"<<endl;break;
	case 9:cout<<"IX"<<endl;break;
	case 10:cout<<"X"<<endl;break;
	case 20:cout<<"XX"<<endl;break;
	case 30:cout<<"XXX"<<endl;break;
	case 40:cout<<"XL"<<endl;break;
	case 50:cout<<"L"<<endl;break;
	case 60:cout<<"LX"<<endl;break;
	case 70:cout<<"LXX"<<endl;break;
	case 80:cout<<"LXXX"<<endl;break;
	case 90:cout<<"XC"<<endl;break;
	case 100:cout<<"C"<<endl;break;
	case 200:cout<<"CC"<<endl;break;
	case 300:cout<<"CCC"<<endl;break;
	case 400:cout<<"CD"<<endl;break;
	case 500:cout<<"D"<<endl;break;
	case 600:cout<<"DC"<<endl;break;
	case 700:cout<<"DCC"<<endl;break;
	case 800:cout<<"DCCC"<<endl;break;
	case 900:cout<<"CM"<<endl;break;


	
	
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
	cout<<fun(roman);
	}
	x1=y%100;
	
	
	z=x1;
	
	{
		x1=x1/10;
		x1=x1*10;
		roman=x1;
	cout<<fun(roman);
	}
	x2=z%10;


	roman=x2;
	cout<<fun(roman);


}


