#ifndef NNLYR_HPP
#define	NNLYR_HPP
#include <vector>
#include <algorithm>
#include <math.h>
#include "nnmatrix.hpp"
typedef unsigned int UI;
typedef const unsigned int CUI;
using namespace std;
// 
enum e_weightfns {
    DOTPROD, MANDIST, NEGDIST, NORMPROD, SCALPROD
};
enum e_transfns {
    HARDLIM, HARDLIMS, COMPET, LOGSIG, NETINV, POSLIN,
    PURELIN, RADBAS, SATLIN, SATLINS, SOFTMAX, TANSIG, TRIBAS
};
//
template<class T>
class NNlyr {
public:
    vector<T*> input;
    vector<T> bias,temp_out,output;
    e_weightfns wfn;
    NNmatrix<T> weight;
    e_transfns tfn;
    T theta;
    //
    inline NNlyr()
    {
        init(DOTPROD,HARDLIM,0);
    }
    inline void init(const e_weightfns wfn,const e_transfns tfn,const T theta)
    {
        this->theta = theta;
        this->wfn = wfn;
        this->tfn = tfn;
    }
    virtual inline ~NNlyr() { }
    inline void fire_wfn()
    {
        switch (wfn)
        {
            case DOTPROD:dotprod();
                break;
            case MANDIST:
                break;
            case NEGDIST:
                break;
            case NORMPROD:
                break;
            case SCALPROD:
                break;
            default:dotprod();
                break;
        }
    }
    inline void fire_tfn()
    {
        switch (tfn)
        {
            case HARDLIM:hardlim();
                break;
            case HARDLIMS:hardlims();
                break;
            case COMPET:compet();
                break;
            case LOGSIG:logsig();
                break;
            case NETINV:
                break;
            case POSLIN:poslin();
                break;
            case PURELIN:purelin();
                break;
            case RADBAS:
                break;
            case SATLIN:satlin();
                break;
            case SATLINS:satlins();
                break;
            case SOFTMAX:
                break;
            case TANSIG:tansig();
                break;
            case TRIBAS:
                break;
            default:hardlim();
                break;
        }
    }
    //convwf: Convolution weight function
    //dist: Euclidean distance weight function
    /**
     *
     * @description Dot product weight function
     * 
     */
    inline void dotprod()
    {
        CUI rows = weight.size1();
        CUI cols = weight.size2();
        for (UI i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
                temp_out.at(i) += (weight.elem(i, j) * *input.at(j));
            temp_out.at(i) += bias.at(i);
        }
    }

    //mandist: Manhattan distance weight function
    //negdist: Negative distance weight function
    //normprod: Normalized dot product weight function
    //scalprod: Scalar product weight function
    /**
     * @description hardlim: Hard-limit transfer function
     */
    inline void hardlim()
    {
        CUI size = temp_out.size();
        for (UI i = 0; i < size; i++)
            temp_out.at(i) >= theta ? temp_out.at(i) = 1 : temp_out.at(i) = 0;
    }
    /**
     * @description hardlims: Symmetric hard-limit transfer function
     */
    inline void hardlims()
    {
        CUI size = temp_out.size();
        for (UI i = 0; i < size; i++)
            temp_out.at(i) >= theta ? temp_out.at(i) = 1 : temp_out.at(i) = -1;
    }
    //    compet: Competitive transfer function
    inline void compet()
    {
        typename std::vector<T>::iterator itr;
        itr = max_element(temp_out.begin(), temp_out.end());
        fill(temp_out.begin(), temp_out.end(), 0);
        *itr = 1;
    }
    //    logsig: Log-sigmoid transfer function
    inline void logsig()
    {
        CUI size = temp_out.size();
        for (UI i = 0; i < size; i++)
        {
            temp_out.at(i) = 1 / (1 + exp(-1 * temp_out.at(i)));
        }
    }
    //    netinv: Inverse transfer function
    //    poslin: Positive linear transfer function
    inline void poslin()
    {
        CUI size = temp_out.size();
        for (UI i = 0; i < size; i++)
            if (temp_out.at(i) < theta)
                temp_out.at(i) = 0;
    }
    /**
     *@desc purelin: Linear transfer function (silence is gold)
     */
    inline void purelin() { }
    //    radbas: Radial basis transfer function
    //    satlin: Saturating linear transfer function
    inline void satlin()
    {
        CUI size = temp_out.size();
        for (UI i = 0; i < size; i++)
            if (temp_out.at(i) < 0)
                temp_out.at(i) = 0;
            else if (temp_out.at(i) > 1)
                temp_out.at(i) = 1;
    }
    //    satlins: Symmetric saturating linear transfer function
    inline void satlins()
    {
        CUI size = temp_out.size();
        for (UI i = 0; i < size; i++)
            if (temp_out.at(i) < 0)
                temp_out.at(i) = -1;
            else if (temp_out.at(i) > 1)
                temp_out.at(i) = 1;
    }
    //    softmax: Softmax transfer function
    //    tansig: Hyperbolic tangent sigmoid transfer function
    inline void tansig()
    {
        CUI size = temp_out.size();
        T out1, out2;
        for (int i = 0; i < size; i++)
        {
            out1 = exp(temp_out.at(i));
            out2 = exp(-1 * temp_out.at(i));
            temp_out.at(i) = (out1 - out2) / (out1 + out2);
        }
    }
    //    tribas: Triangular basis transfer function
    inline void resize(CUI n_neurons)
    {
        bias.resize(n_neurons);
        temp_out.resize(n_neurons);
        output.resize(n_neurons);
    }
    inline void resizeweight()
    {
        weight.resize(temp_out.size(), input.size(), 0);
    }
    inline void resizeweight(CUI rows, CUI cols, T val)
    {
        weight.resize(rows, cols, val);
    }

};
#endif	/* NNLYR_HPP */