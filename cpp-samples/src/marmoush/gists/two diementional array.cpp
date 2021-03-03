#include <iostream.h>
#include <math.h>
void read(int a[3][5]);
void print(int a[3][5]);
void main()
{
	int a[3][5];
	read(a);
	print(a);
}

	void read (int a[3][5])
	{
		cout<<"enter 15 element ,5 per row:\n";
		for (int i=0;i<3;i++)
		{
			cout<<"row"<<i<<":";
			for (int j=0;j<5;j++)
				cin>>a[i][j];
		}
	}
		
	
	
	void print (int a[3][5])
	{for (int i=0;i<3;i++)
		{for (int j=0;j<5;j++)
			cout<<"  "<<a[i][j];
	cout<<endl;
		}
	}