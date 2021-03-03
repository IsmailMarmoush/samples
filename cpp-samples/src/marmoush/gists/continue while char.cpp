#include <iostream.h>
#define true 1
#define false 0
int main()
{
	int cont;
	char ans;
	do
	{
		cout <<"continue?(y/n)";
		cin>> ans;
		if (ans =='y'||ans=='Y')cont =true;
		else 
			
			
		if (ans =='y'||ans=='N') cont =false;
		
		else cout<<"please answer the fucken question y or n\n";
		
	}
	while (ans !='y'&& ans !='Y'&& ans !='n'&& ans !='N');
	return (0);
}