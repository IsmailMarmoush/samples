#include<iostream.h>
#include <stdlib.h>
void main()
{
	unsigned seed;
	cout<<"enter seed:";
	cin>>seed;
	srand(seed);
	for (int i=0;i<8;i++)
	//{	cout<<i<<"  ==> \t";
	cout<<rand()<<endl;//}
	
	//cout<<"rand_max="<<RAND_MAX<<endl;
}