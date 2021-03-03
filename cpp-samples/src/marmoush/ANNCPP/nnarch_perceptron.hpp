/* 
 * File:   nnarch_perceptron.hpp
 * Author: marmoushai
 *
 * Created on October 23, 2010, 8:45 PM
 */

#ifndef NNARCH_PERCEPTRON_HPP
#define	NNARCH_PERCEPTRON_HPP

#include "nnarch.hpp"

typedef unsigned int UI;
typedef const unsigned int CUI;
using namespace std;
class NNarch_perceptron : public NNarch {
public:
    inline NNarch_perceptron(CUI n_input, CUI n_neurons) : NNarch(2)
    {
        this->resize_lyr(0, n_input);
        this->resize_lyr(1,n_neurons);
        this->connect();
    }
    inline virtual ~NNarch_perceptron() { }

};

#endif	/* NNARCH_PERCEPTRON_HPP */