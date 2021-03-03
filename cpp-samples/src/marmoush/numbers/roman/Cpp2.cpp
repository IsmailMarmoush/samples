#include <iostream>

#include <fstream>
#include <string>

using namespace std;



int main()

{
	int n;
	string  z;
	cin>>n;
	switch (n)
	{

	case 1: z="i";break;
	case 2: z="ii";break;
	case 3: z="iii";break;
	case 4: z="iv";break;
	case 5: z="v";break;
	case 6: z="vi";break;
	case 7: z="vii";break;
	case 8: z="viii";break;
	case 9: z="ix";break;
	case 10: z="x";break;
	case 20: z="xx";break;
	case 30: z="xxx";break;
	case 40: z="xl";break;
	case 50: z="l";break;
	case 60: z="lx";break;
	case 70: z="lxx";break;
	case 80: z="lxxx";break;
	case 90: z="xc";break;
	case 100: z="c";break;
	case 200: z="cc";break;
	case 300: z="ccc";break;
	case 400: z="cd";break;
	case 500: z="d";break;
	case 600: z="dc";break;
	case 700: z="dcc";break;
	case 800: z="dccc";break;
	case 900: z="cm";break;
	}
	
	
	cout<<z;
return 0;

}
