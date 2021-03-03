#include<iostream>
using namespace std;
void main (void)
{
	int max,n,r,r2,*array;
	cin>>n>>r;
	r2=r-1;
	array =new int[r2];
	max=n-(r-1);
	/////////////////////
	array[0]=0;

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
			for (int i=1;i<=r;i++)
			{
				array[i]=i;
				cout<<array[i]<<" ";
				
			}
			cout<<endl;
			
			//goto	

incrementlast:
			if (array[r]<n)
				{	// incrementing the last element

					for(;array[r]<n;)
					{
						array[r]=array[r]+1;
						//////////////////////////// out array
						for (int ii=1;ii<=r;ii++)
						{
							cout<<array[ii]<<" ";
						
						}

						cout<<endl;
					}
				}

			for(int iii=0;iii<=r-1;iii++)
			{
				int j=n-iii;
				if(array[r-iii]<j)
				{
					array[r-iii]+=1;
					int others=(r-iii)+1;
					for(int i=others;others<=r;others++)
					{
						array[others]=array[others-1]+1;
					}
					for (int iiii=1;iiii<=r;iiii++)
					{cout<<array[iiii]<<" ";}
					cout<<endl;
					goto incrementlast;
				}
				
			
			}
		}
	}
}
