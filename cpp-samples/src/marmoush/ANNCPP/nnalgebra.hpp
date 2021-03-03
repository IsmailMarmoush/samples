/* 
 * File:   nnalgebra.hpp
 * Author: marmoushai
 *
 * Created on October 23, 2010, 1:44 PM
 */

#ifndef NNALGEBRA_HPP
#define	NNALGEBRA_HPP
#include <vector>
using namespace std;

/**
 *
 * @param vec1
 * @param vec2
 * @return result=vec1+vec2
 */
template <class T>
vector<T> operator+(const vector<T> &vec1, const vector<T> &vec2)
{
    if (vec1.size() == vec2.size())
    {
        UI size = vec1.size();
        vector<T> result(size);
        for (int i = 0; i < size; i++)
            result.at(i) = vec1.at(i) + vec2.at(i);
        return result;
    }

}

#endif	/* NNALGEBRA_HPP */

