#ifndef NNARCH_HPP
#define	NNARCH_HPP
#include <vector>
#include <algorithm>
typedef unsigned int UI;
typedef const unsigned int CUI;
using namespace std;
class NNarch {
private:
    vector<UI> lyrs_sizes; // determines layer output sizes (num ofneurons)
    vector<vector<UI> >con_mtrx; // determines num of inputs for each layer
public:
    inline NNarch() { }
    virtual inline ~NNarch() { }
    inline NNarch(CUI nlyrs)
    {
        resize_network(nlyrs);
    }
    inline void connect()
    {
        for (UI i = 1; i < con_mtrx.size(); i++)
            connect(i - 1, i);
    }
    inline void connect(CUI from_idx, CUI to_idx)
    {
        con_mtrx.at(to_idx).push_back(from_idx);
    }
    inline void disconnect()
    {
        con_mtrx.clear();
    }
    inline void disconnect(CUI from_idx, CUI to_idx)
    {
        vector<UI>::iterator itr;
        itr = find(con_mtrx.at(to_idx).begin(), con_mtrx.at(to_idx).end(), from_idx);
        if (itr < con_mtrx.at(to_idx).end())
            con_mtrx.at(to_idx).erase(itr);
    }
    inline CUI get_connection(CUI lyr_idx, CUI con_idx)const
    {
        return this->con_mtrx.at(lyr_idx).at(con_idx);
    }
    inline CUI numOFconnections(CUI lyr_idx)const
    {
        return this->con_mtrx.at(lyr_idx).size();
    }
    inline void resize_lyr(CUI idx, CUI size)
    {
        lyrs_sizes.at(idx) = size;
    }
    inline void resize_network(CUI nlyrs)
    {
        lyrs_sizes.resize(nlyrs);
        con_mtrx.clear();
        con_mtrx.resize(nlyrs);
    }
    inline CUI sizeOFlyr(CUI lyr_idx)const
    {
        return lyrs_sizes.at(lyr_idx);
    }
    inline CUI sizeOFnetwork()const
    {
        return lyrs_sizes.size();
    }
};

#endif	/* NNARCH_HPP */

