:-module(inference,[inference/2]).
:-use_module(inputlayer).
:-use_module(hiddenlayer).
:-use_module(outputlayer).
%from inference to input layer    [X1]   to [I1,I2,n1,O1]
board([	   [1,0,n1,_],[1,0,n2,_],[1,0,n3,_],
	   [0,0,n4,_],[0,0,n5,_],[0,0,n6,_],
	   [-1,0,n7,_],[-1,0,n8,_],[-1,0,n9,_]]).
inference(Board,M):-generator(Board,Board,Nodes),ma(Nodes,-4,M),themove(Nodes,M,Node),write(Node).

generator(_,[],[]).
generator(Board,[[1,_,N1,_]|Restneurons],[Node1,Node2,Node3|Rnodes]):-
				select([1,_,N1,_]	,Board,Restneurons1),
		select([0,0,A,_]	,Restneurons1,Restneurons2),
		select([0,0,B,_]	,Restneurons2,Restneurons3),select([0,0,B,_],Restneurons1,R2),
		select([0,0,C,_]	,Restneurons3,_),select([0,0,C,_],Restneurons1,R3),
		Node1=[ [0,0,N1,ON1],[1,1,A,ON2]|Restneurons2 ],
		Node2=[ [0,0,N1,ON1],[1,1,B,ON2]|R2 ],
		Node3=[ [0,0,N1,ON1],[1,1,C,ON2]|R3 ],
		generator(Board,Restneurons,Rnodes),!.
generator(Board,[[I,_,_,_]|Restneurons],Nodes):-not(I=1),generator(Board,Restneurons,Nodes).

 ma([], MaxSoFar, MaxSoFar).
 ma([Node|Rest], MaxSoFar, Max) :-network(Node,Out),Out > MaxSoFar, ma(Rest, Out, Max).
 ma([Node|Rest], MaxSoFar, Max) :-network(Node,Out),Out =< MaxSoFar,ma(Rest, MaxSoFar, Max).
%[[0, 0, n1, _G964], [1, 1, n5, _G979], [1, 0, n2, _G727], 
%	[1, 0, n3, _G742], [0, 0, n4, _G757], [0, 0, n6, _G787], 
%	[-1, 0, n7, _G802], [-1, 0, n8, _G817], [-1, 0, n9, _G832]]
themove([],_,_).
themove([H|_],Max,H):-network(H,O),Max=O,!.
themove([H|T],Max,H2):-network(H,O),Max=\=O,themove(T,Max,H2).



network(Inputs,Out):-		inputlayer(Inputs,Y),
				fillhidden(Y,[hn1,hn2,hn3,hn4,hn5,hn6,hn7,hn8],Y2),
				outputlayer(Y2,Out).


