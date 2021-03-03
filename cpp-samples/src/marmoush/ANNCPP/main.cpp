/* 1,2 --> 1
 * -1,2 --> 0
 *  0,-1 --> 0
 * solution found after 10 iterations
 * weight 4,1
 */

#include <iostream>
#include <vector>
#include "nnfunctions.hpp"
#include "nnarch_perceptron.hpp"
#include "nnetwork_perceptron.hpp"
using namespace std;

int main()
{
    NNarch_perceptron archp(3, 2);
    NNetwork_perceptron<int> netp(archp);
    vector<int> input(3, 10);
    netp.set_output(0, input);
    netp.flash();
    
    cout<<"output "<<netp.get_input(0)<<netp.get_weight(0)<<netp.get_output(0)<<endl;
    cout<<netp.get_input(1)<<netp.get_weight(1)<<netp.get_output(1)<<endl;
    return 0;
}