#include <iostream.h>
#include <math.h>


void main()
{
	float n1,n2,k1,k2;
	float prime;
	int z;
	
	cin>>prime;
	if (prime==1||prime==2||prime==3||prime==5||prime==7)
		cout<<"number is prime.....";
	else
	{



	k1=(prime-1)/6;
	//cout<<k1<<endl;
	k2=(prime+1)/6;
	//cout<<k2<<endl;
	
	
	if (k1==floor(k1)||k2==floor(k2))
	{
		//cout<<"the number is semiprime"<<endl;

		int k;
			z=6*  k -1;
		


		for (k=1;z<(2/prime);k++)

		{

			n1=prime/(6*k-1);
			n2=prime/(6*k+1);
			//cout<<k<<endl;


		
			if (n1==floor(n1)||n2==floor(n2))
				{
				
					cout<<k;
				
					cout<<"the number is nottttt prime"<<endl;
				
				}
			else 
				cout<<"the number is prime"<<endl;
					goto ending;
				



		}
		cout<<"number is  prime"<<endl;
	
	
	
	}
	
	else 
	
		
		cout<<"number is not prime"<<endl;

	
	}

ending:cout<<""<<endl;



	


}
