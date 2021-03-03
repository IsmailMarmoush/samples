#include <iostream.h>
//#include <stdlib.h>
//using namespace std;

 char   fun(int roman)
{
	switch (roman)
	{ 
	case 0:cout<<"";break;
	case 1: cout<<"I";break;
	case 2: cout<<"II";break;
	case 3:cout<<"III";break;
	case 4:cout<<"IV";break;
	case 5:cout<<"V";break;
	case 6:cout<<"VI";break;
	case 7:cout<<"VII";break;
	case 8:cout<<"VIII";break;
	case 9:cout<<"IX";break;
	case 10:cout<<"X";break;
	case 20:cout<<"XX";break;
	case 30:cout<<"XXX";break;
	case 40:cout<<"XL";break;
	case 50:cout<<"L";break;
	case 60:cout<<"LX";break;
	case 70:cout<<"LXX";break;
	case 80:cout<<"LXXX";break;
	case 90:cout<<"XC";break;
	case 100:cout<<"C";break;
	case 200:cout<<"CC";break;
	case 300:cout<<"CCC";break;
	case 400:cout<<"CD";break;
	case 500:cout<<"D";break;
	case 600:cout<<"DC";break;
	case 700:cout<<"DCC";break;
	case 800:cout<<"DCCC";break;
	case 900:cout<<"CM";break;
	case 1000:cout<<"M";break;


	
	
	 return 0;
 }}

void main()
{
	int x,x1,x2,x3,y,y1,y2,roman;
	
	cin>>x;            //x=1234

	y=x;
	{
		x=x/1000;   //x=1
		x=x*1000;	//x=1000
		roman=x;	
	cout<<fun(roman);
	}
	x1=y%1000;			//x1=234
	



	y1=x1;
	
	{
		x1=x1/100;			//x1=2
		x1=x1*100;           //x1=200
		roman=x1;
	cout<<fun(roman);
	}
	x2=y1%100;					//x1=34
	
	
	y2=x2;							//y2=34
	
	{
		x2=x2/10;					//x2=2		
		x2=x2*10;					//x2=20
		roman=x2;
	cout<<fun(roman);
	}
	x3=y2%10;


	roman=x3;
	cout<<fun(roman);


}