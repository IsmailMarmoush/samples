#include <iostream.h>
#include <math.h>


void read (int [],int&);
void print(int [],int);
void main()
{
	const int maxsize=100;
	int a[maxsize]={0},size;
	read(a,size);
	cout<<"the array has "<<size<<"element";
	print(a,size);
}

void read(int a[],int& n)
	{
		cout<<"enter integer.terminate with zero(0):\n";
		n=0;
		int maxsize=100;
			do
			{
				cout<<"\t a["<<n<<"]:";
				cin>>a[n];
			}
			while (a[n++]!=0&& n<maxsize);
			--n;//don't count the 
void print(int a[],int n)
	{
		for (int i=0;i<n;i++)
			cout<<a[i]<<"  ";
	}
