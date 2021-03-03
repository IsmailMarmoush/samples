#include<iostream>
using namespace std;

void incrementone (int last,int n,int *array);
void incrementtwo (int elementnum,int last,int *array);
void out(int last,int *array);
void main (void)
{
	int max,n,r,*array,last;
	cin>>n>>r;
	array =new int[r];
	last=r-1;
	max=n-(r-1);
	/////////////////////

	if (r>n)
	{
		cout<<"The R can't be greater than N "<<endl;

	}
	else
	{
		if (r==n)
			cout<< "1"<<endl;
		else
		{
			//////////////////////    array initial filling
			for (int i=0;i<=last;i++)
			{
				array[i]=i+1;
				cout<< "  "<<array[i]<<" ";
			}
			
			/////////////////////      array filling
			while (array[0]!=max)
			{
				if (array[last]<n)
				{
					incrementone (last,n,array);
					
				}
				else
				{
					for(int j=n,i=last-1,b=1;i=0;i--,b++)
					{
						j=j-b;
						if (array[i]<j)
						{
							incrementtwo (i,last,array);
							i=0;
						}
					}
				}
			}
		}
	}
}



void incrementone (int last,int n,int *array)
{
	int f=array[last];
		for(;f<=n;)
		{
			array[last]++;
			for (int i=0;i<=last;i++)
			{
				cout<<"  "<<array[i]<< "  ";
			}
			f=array[last];
			cout<<endl;
		}
}
void incrementtwo (int elementnum,int last,int *array)
{

	array[elementnum]++;
	for(elementnum=elementnum+1;elementnum=last;elementnum++)
	{
		array[elementnum]=array[elementnum-1]+1;
		//out
	}

}
void out(int last,int *array)
{
	
}