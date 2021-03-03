#include <iostream.h>
int main ()
{
	char c ;
	while (c!='\n')
	{
		cin.get(c);
		//cout<<c<<endl;

		if (c>='a'&&c>='z')c=char(c-'a'+'A');
		cout.put(c);
		//cout<<endl<<c<<endl;
	}
	return (0);
}