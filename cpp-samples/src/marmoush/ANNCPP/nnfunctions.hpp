#ifndef NNFUNCTIONS_HPP
#define	NNFUNCTIONS_HPP
#include <sstream>
typedef unsigned int UI;
typedef const unsigned int CUI;
using namespace std;
template <class T>
ostream & operator<<(ostream& out, const vector<T> &vec)
{
    CUI size = vec.size();
    if (size > 0)
    {
        out << "Row Vector:" << endl;
        for (int i = 0; i < size; i++)
            out << vec.at(i) << endl;
    }
    return out;
}
template <class T>
string NumberToString(T Number)
{
    stringstream ss;
    ss << Number;
    return ss.str();
}



#endif	/* NNFUNCTIONS_HPP */