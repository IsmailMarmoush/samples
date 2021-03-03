/* 
 * File:   nnetwork_perceptron.hpp
 * Author: marmoushai
 *
 * Created on October 23, 2010, 8:44 PM
 */

#ifndef NNETWORK_PERCEPTRON_HPP
#define	NNETWORK_PERCEPTRON_HPP
#include <algorithm>
#include "nnetwork.hpp"
#include "nnarch_perceptron.hpp"
template<class T>
class NNetwork_perceptron : public NNetwork <T> {
protected:
    vector<T> target, err;
    T lrn_rate;

public:
    inline NNetwork_perceptron(const NNarch_perceptron &arch) : NNetwork<T>(arch)
    {
        target.resize(arch.sizeOFlyr(1), 0);
        err.resize(arch.sizeOFlyr(1), 0);
        lrn_rate = 1;
    }
    inline virtual ~NNetwork_perceptron() { }
    inline void error()
    {
        transform(target.begin(), target.end(), this->netlyrs.at(1).output.begin(), err.begin(), minus<T > ()); // e= target - output
        transform(err.begin(), err.end(), err.begin(), std::bind1st(multiplies<T > (), lrn_rate)); // α * e
        return err;
    }
    inline vector<T> get_error()const
    {
        return err;
    }
    inline void set_target(CUI lyr_idx, const vector<T> &target)
    {
        try
        {
            if (this->target.size() != target.size()) throw this->target.size();
            this->target = target;
        } catch (const unsigned long size)
        {
            cout << "Exception: Vector param size should be " << size << endl;
        }
    }
    inline void adaptw()
    {
        CUI rows = this->netlyrs.at(0).weight.size1();
        CUI cols = this->netlyrs.at(0).weight.size2();
        T delta_w;
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                delta_w = err.at(i)* * this->netlyrs.at(1).input.at(j);
                this->netlyrs.at(1).weight.set_elem(i, j, this->netlyrs.at(1).weight.elem(i, j) + delta_w);
            }
        }
    }
    inline void adaptb()
    {
        transform(this->netlyrs.at(1).bias.begin(), this->netlyrs.at(1).bias.end(),
                err.begin(), this->netlyrs.at(1).bias.begin(), plus<T > ());
    }
};
#endif	/* NNETWORK_PERCEPTRON_HPP */