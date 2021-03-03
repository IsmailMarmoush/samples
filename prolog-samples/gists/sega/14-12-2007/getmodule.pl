:-module(getmodule,[getsquares/2,getstates/3,getpositions/3,getmax/3,getinitial/3]).
getinitial(0,Wnode,Wnode).
getinitial(L,[I,_,_],Move):-level(L,Nodes),member([I2,I,Node],Nodes),L1 is L-1,getinitial(L1,[I2,I,Node],Move).
getsquares(Board,ESquares):-	getpositions(red,Board,P1),
				getpositions(black,Board,P2),
				append(P1,P2,P3),subtract([1,2,3,4,5,6,7,8,9],P3,ESquares).
getstates(_,[],[]).
getstates(Against,[[Against,_,_]|Restpieces],States):-!,
			getstates(Against,Restpieces,States).
getstates(Against,[[_,_,State]|Restpieces],[State|Reststates]):-
			getstates(Against,Restpieces,Reststates).
getpositions(_,[],[]).
getpositions(Against,[[Against,_,_]|Restpieces],Positions):-!,
			getpositions(Against,Restpieces,Positions).
getpositions(Against,[[_,Position,_]|Restpieces],[Position|Restpositions]):-
			getpositions(Against,Restpieces,Restpositions).		
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
getmax([], A, A).
getmax([Node|Rest], A, M) :-calculate(Node,N),N > A,  getmax(Rest,N, M).
getmax([Node|Rest], A, M) :-calculate(Node,N),N =< A, getmax(Rest, A, M).
	calculate(Node,N3):-	turnof(Against),
				getstates(Against,Node,Li),
				calculate2(Li,N3).
	calculate2([],0).
	calculate2([true|T],N):-calculate2(T,N1),N is N1+1.
	calculate2([fail|T],N):-calculate2(T,N1),N is N1-1.
