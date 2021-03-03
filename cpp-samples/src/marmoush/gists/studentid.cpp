#include <iostream.h>
#include <iomanip.h>
#include <fstream.h>
//using namespace std;

int main()
{
	ifstream infile;
	ofstream outfile;

	int test1,test2,test3,test4,test5;
	double average;
	char studentid;

	infile.open("e:test.txt");
	/*outfile.open("E:\testavg.txt");
	
	outfile<<fixed<<showpoint;
	outfile.setf(ios::fixed,ios::floatfield);
	outfile.setf(ios::showpoint);
	outfile<<setprecision(2);*/
	
	cout<<"processing data"<<endl;
	infile>>studentid;
	//outfile<<"student id :"<<studentid<<endl;
	cout<<"student id:  "<<studentid<<endl;


	infile>>test1>>test2>>test3>>test4>>test5;
	
	
	//outfile<<"test scores:  "<<setw(4)<<test1<<setw(4)<<test2<<setw(4)<<test3<<setw(4)<<test5<<endl;

	cout<<"test scores:  "<<setw(4)<<test1<<setw(4)<<test2<<setw(4)<<test3<<setw(4)<<test5<<endl;
	average =static_cast<double>(test1+test2+test3+test4+test5)/5.0;
	//outfile<<"average test score:"<<setw(6)<<average <<endl;
	cout<<"average test score:"<<setw(6)<<average <<endl;

	//infile.close();
	//outfile.close();
	return 0;
}