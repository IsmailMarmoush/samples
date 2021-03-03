/* 1,2 --> 1
 * -1,2 --> 0
 *  0,-1 --> 0
 * solution found after 10 iterations
 * weight 4,1
 */

#include <iostream>
#include <vector>
#include "nnfunctions.hpp"
#include "nperceptron.hpp"
#include <numeric>
using namespace std;
template <class Type>
void comp()
{

}

int main()
{
    vector<int> output, in1, in2, in3, in4, tr1, tr2, tr3, tr4, err;
    in1.push_back(2);
    in1.push_back(2);
    tr1.push_back(0);

    in2.push_back(1);
    in2.push_back(-2);
    tr2.push_back(1);

    in3.push_back(-2);
    in3.push_back(2);
    tr3.push_back(0);

    in4.push_back(-1);
    in4.push_back(1);
    tr4.push_back(1);


    Nperceptron<int> netp(2, 1);
    netp.set_fns(DOTPROD,COMPET, 0);
    for (int i = 0; i < 10; i++)
    {
        netp.fire(in1);
        output = netp.get_output();
        cout << "Input1 output is:" << endl << output;
        netp.error(in1, tr1, 1);
        netp.adaptw();
        netp.adaptb();
        netp.fire();
        output = netp.get_output();
        cout << "output after adaptation:" << endl << output;
        err = netp.get_error();
        cout << "error now is:" << endl << err;
        cout << endl;

        netp.fire(in2);
        output = netp.get_output();
        cout << "Input2 output is:" << endl << output;
        netp.error(in2, tr2, 1);
        netp.adaptw();
        netp.adaptb();
        netp.fire();
        output = netp.get_output();
        cout << "output after adaptation:" << endl << output;
        err = netp.get_error();
        cout << "error now is:" << endl << err;
        cout << endl;

        netp.fire(in3);
        output = netp.get_output();
        cout << "Input3 output is:" << endl << output;
        netp.error(in3, tr3, 1);
        netp.adaptw();
        netp.adaptb();
        netp.fire();
        output = netp.get_output();
        cout << "output after adaptation:" << endl << output;
        err = netp.get_error();
        cout << "error now is:" << endl << err;
        cout << endl;

        netp.fire(in4);
        output = netp.get_output();
        cout << "Input4 output is:" << endl << output;
        netp.error(in4, tr4, 1);
        netp.adaptw();
        netp.adaptb();
        netp.fire();
        output = netp.get_output();
        cout << "output after adaptation:" << endl << output;
        err = netp.get_error();
        cout << "error now is:" << endl << err;
        cout << endl;
        cout << "END OF LOOP " << i << endl << "-------------------------------------------" << endl;

    }

    NNmatrix<int> m = netp.get_weight();
    cout << "weight is now" << m;
    vector<int> bias = netp.get_bias();
    cout << "bias is " << bias;


    return 0;
}