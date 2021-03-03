#ifndef NNETWORK_HPP
#define	NNETWORK_HPP
#include "nnarch.hpp"
#include "nnlyr.hpp"
#include <vector>
typedef unsigned int UI;
typedef const unsigned int CUI;
using namespace std;
template <class T>
class NNetwork {
public:
    inline NNetwork() { }
    inline virtual ~NNetwork() { }
    inline NNetwork(const NNarch &arch)
    {
        init(arch);
    }
    inline void flash()
    {
        CUI size=netlyrs.size();
        for (int i = 0; i < size; i++)
        {
            netlyrs.at(i).fire_wfn();
            netlyrs.at(i).fire_tfn();
        }
    }
    inline void after_flash()
    {
        CUI size=netlyrs.size();
        for (int i = 0; i < size; i++)
            if(netlyrs.at(i).input.size()>0)netlyrs.at(i).output=netlyrs.at(i).temp_out;
    }
    inline vector<T> get_input(CUI lyr_idx)const
    {
        vector<T> result;
        CUI size = netlyrs.at(lyr_idx).input.size();
        for (int i = 0; i < size; i++)
            result.push_back(*netlyrs.at(lyr_idx).input.at(i));
        return result;
    }
    inline NNmatrix<T> get_weight(CUI lyr_idx)const
    {
        return netlyrs.at(lyr_idx).weight;
    }
    inline vector<T> get_output(CUI lyr_idx) const
    {
        return netlyrs.at(lyr_idx).output;
    }
    inline void set_output(CUI lyr_idx,const vector<T> &output)
    {
        try
        {
            if (netlyrs.at(lyr_idx).output.size() != output.size()) throw netlyrs.at(lyr_idx).output.size();
            netlyrs.at(lyr_idx).output = output;
        } catch (const unsigned long size)
        {
            cout <<"Exception: Vector param size should be "<<size<< endl;
        }
    }
protected:
    NNarch arch;
    vector<NNlyr<T> > netlyrs;
private:
    inline void init(const NNarch &arch)
    {
        this->arch = arch;
        UI netsize = arch.sizeOFnetwork();
        netlyrs.resize(netsize);
        for (UI i = 0; i < netsize; i++)
            netlyrs.at(i).resize(arch.sizeOFlyr(i));
        for (UI i = 0; i < netsize; i++)
        {
            charge_lyr(i);
            netlyrs.at(i).resizeweight();
        }
    }
    inline void charge_lyr(CUI lyr_idx)
    {
        netlyrs.at(lyr_idx).input.clear();
        UI numOFcon = arch.numOFconnections(lyr_idx);
        for (UI i = 0; i < numOFcon; i++)
            assign_addr(arch.get_connection(lyr_idx, i), lyr_idx);
    }
    inline void assign_addr(CUI inlyr, CUI lyr)
    {
        UI output_size = netlyrs.at(inlyr).output.size();
        for (UI j = 0; j < output_size; j++)
            netlyrs.at(lyr).input.push_back(&netlyrs.at(inlyr).output.at(j));
    }
};
#endif	/* NNETWORK_HPP */