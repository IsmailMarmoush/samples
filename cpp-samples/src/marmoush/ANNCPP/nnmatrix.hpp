#ifndef NNMATRIX_HPP
#define	NNMATRIX_HPP
typedef unsigned int UI;
typedef const unsigned int CUI;
using namespace std;
template <class T>
class NNmatrix {
protected:
    vector<vector<T> > matrix;
public:
    inline NNmatrix() { }
    inline NNmatrix(CUI rows, CUI cols, CUI w_val)
    {
        resize(rows, cols, w_val);
    }
    inline virtual ~NNmatrix() { }
    void operator+=(const NNmatrix<T> &other_mtrx)
    {
        UI rows = other_mtrx.size1();
        UI cols = other_mtrx.size2();
        // flag do try and catch exception out
        if (this->size1() == rows && this->size2() == cols)
        {
            for (UI i = 0; i < rows; i++)
                for (UI j = 0; j < cols; j++)
                    this->set_elem(i, j, this->matrix.at(i).at(j) + other_mtrx.elem(i, j));
        }
    }
    void operator*=(const T num)
    {
        UI rows = this->size1();
        UI cols = this->size2();
        for (UI i = 0; i < rows; i++)
            for (UI j = 0; j < cols; j++)
                this->set_elem(i, j, this->elem(i, j) * num);
    }
    friend ostream & operator<<(ostream& out, const NNmatrix &mtrx)
    {
        UI rows = mtrx.size1();
        UI cols = mtrx.size2();
        if (rows > 0 && cols > 0)
        {
            out<<"Matrix:"<<endl;
            for (UI i = 0; i < rows; i++)
            {
                for (UI j = 0; j < cols; j++)
                    out << mtrx.elem(i, j) << " ";
                out << endl;
            }
        }

        return out;
    }
    inline void set_elem(CUI row, CUI col, T val)
    {
        matrix.at(row).at(col) = val;
    }
    inline void set_row(CUI row_idx, const vector<T> &row_v)
    {
        if (matrix.at(row_idx).size() == row_v.size())
        {
            matrix.at(row_idx) = row_v;
        }
    }
    inline const T elem(CUI row, CUI col)const
    {
        return matrix.at(row).at(col);
    }
    inline void resize(CUI nrows, CUI ncols)
    {
        vector<T> v_rows(ncols, 0);
        matrix.resize(nrows, v_rows);
    }
    inline void resize(CUI nrows, CUI ncols, T val)
    {
        vector<T> v_rows(ncols, val);
        matrix.resize(nrows, v_rows);
    }
    inline void fill(const T val)
    {
        UI rows = this->size1();
        UI cols = this->size2();
        for (UI i = 0; i < rows; ++i)
            for (UI j = 0; j < cols; ++j)
                matrix.at(i).at(j) = val;
    }
    inline CUI size1()const
    {
        return matrix.size();
    }
    inline CUI size2()const
    {
        if (matrix.size() == 0)
            return 0;
        else
            return matrix.begin()->size();
    }
};
#endif	/* NNMATRIX_HPP */