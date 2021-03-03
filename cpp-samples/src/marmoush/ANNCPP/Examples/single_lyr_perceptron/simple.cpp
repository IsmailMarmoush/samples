/* 1,2 --> 1
 * -1,2 --> 0
 *  0,-1 --> 0
 * solution found after 10 iterations
 * weight 4,1
 */

#include <iostream>
#include <vector>
#include "../../nnfunctions.hpp"
#include "../../nnmatrix.hpp"
#include "../../nperceptron.hpp"
#include <numeric>
using namespace std;

int main()
{
    vector<int> output, in1, in2, in3, tr1, tr2, tr3, err;
    in1.push_back(1);
    in1.push_back(2);
    tr1.push_back(1);

    in2.push_back(-1);
    in2.push_back(2);
    tr2.push_back(0);

    in3.push_back(0);
    in3.push_back(-1);
    tr3.push_back(0);

    Nperceptron<int> netp(2, 1);
    for (int i = 0; i < 10; i++)
    {
        netp.fire(in1);
        output = netp.get_output();
        cout << "Input1 output is:" << endl << output;
        netp.error(in1, tr1, 1);
        netp.adaptw();
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
        netp.fire();
        output = netp.get_output();
        cout << "output after adaptation:" << endl << output;
        err = netp.get_error();
        cout << "error now is:" << endl << err;
        cout << endl;
        cout << "END OF LOOP " << i << endl << "-------------------------------------------" << endl;

    }

    NNmatrix<int> m=netp.get_weight();
    cout<<"weight is now"<< m;


    return 0;
}
