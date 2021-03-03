#include<iostream.h>
#include<math.h>
void main()
{
	float a,b,c;
	float z;
	cout<<"Enter values of a,b and c as the quadratic formula is ax^2+bx+c=0"<<endl;
	cin>>a>>b>>c;

	z=pow(b,2)-(4*a*c);
	
	if (a==0)
	
		cout<<"the equation is not quadratic and its solution is "<<-c/b<<endl;
	else
	{

		
			
		if (z<0)
			cout<<"the roots are imaginable"<<endl;
		else
		{
			cout<<"x1="<<(-b+sqrt(z))/(2*a)<<endl;
				cout<<"x2="<<(-b-sqrt(z))/(2*a)<<endl;
				cout<<"thanks for using the program";
				}
	}
}