% the output layer ... facts and function
:-module(outputlayer,[outputlayer/2]).
:-use_module(inputlayer).
:-use_module(hiddenlayer).


outputlayer([],0).
outputlayer([[_,_,_,_,_,_,_,H]|T],N) :- outputlayer(T,N1),calc(H,O), N is N1+O.
calc(6,O):-O is 100.
calc(-6,O):-O is -100.
calc(I,O):-K is 29/5 ,J is -29/5,I<K,I>J,W is 2/(1+exp(-I)),O is I*W.
