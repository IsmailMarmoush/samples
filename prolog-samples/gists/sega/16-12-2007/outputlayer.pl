% the output layer ... facts and function
:-use_module(inputlayer).
:-use_module(hiddenlayer).
prototype(Y3):-	inputlayer([	[1,1,n1,_],[0,0,n2,_],[0,0,n3,_],
				[0,0,n4,_],[1,1,n5,_],[1,1,n6,_],
				[-1,-1,n7,_],[-1,-1,n8,_],[-1,-1,n9,_]	],Y),
		fillhidden(Y,[hn1,hn2,hn3,hn4,hn5,hn6,hn7,hn8],Y2),outputlayer(Y2,Y3).
%		tell('outputs.txt'),write(Y),write('\n'),write(Y2),write('\n'),write(Y3),told.

outputlayer([],0).
outputlayer([[_,_,_,_,_,_,_,H]|T],N) :- outputlayer(T,N1),calc(H,O), N is N1+O.
calc(6,O):-O is 100.
calc(-6,O):-O is -100.
calc(I,O):-K is 29/5 ,J is -29/5,I<K,I>J,W is 2/(1+exp(-I)),O is I*W.