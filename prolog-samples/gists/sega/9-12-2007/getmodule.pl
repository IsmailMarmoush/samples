:-module(getmodule,[getsquares/2,getstates/3,getpositions/3,getmax/3]).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%getinitial([_,Initial,_],Initialitself):-
				



%get empty squares
getsquares(Board,ESquares):-	getpositions(red,Board,P1),
				getpositions(black,Board,P2),
				append(P1,P2,P3),subtract([1,2,3,4,5,6,7,8,9],P3,ESquares).
getstates(_,[],[]).
getstates(Against,[[Against,_,_]|Restpieces],States):-!,
			getstates(Against,Restpieces,States).
getstates(Against,[[_,_,State]|Restpieces],[State|Reststates]):-
			getstates(Against,Restpieces,Reststates).
%getpositions
%(red,[[red,1,true],[black,2,true],[red,3,true],[black,4,true],[red,5,true],[black,6,true]],Pos).
getpositions(_,[],[]).
getpositions(Against,[[Against,_,_]|Restpieces],Positions):-!,
			getpositions(Against,Restpieces,Positions).
getpositions(Against,[[_,Position,_]|Restpieces],[Position|Restpositions]):-
			getpositions(Against,Restpieces,Restpositions).		
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%max(black,[[[red,7,fail],[red,2,fail],[red,3,fail],[black,4,true],[black,5,fail],[black,6,true]],
%[[red,7,true],[red,2,fail],[red,3,fail],[black,4,true],[black,5,fail],[black,6,true]],
%[[red,7,fail],[red,2,true],[red,3,fail],[black,4,true],[black,5,fail],[black,6,true]],
%[[red,7,fail],[red,2,fail],[red,3,true],[black,4,true],[black,5,fail],[black,6,true]],
%[[red,7,true],[red,2,true],[red,3,true],[black,4,true],[black,5,fail],[black,6,true]]],-4,Max).
getmax([], A, A).
getmax([Node|Rest], A, M) :-calculate(Node,N),N > A,  getmax(Rest,N, M).
getmax([Node|Rest], A, M) :-calculate(Node,N),N =< A, getmax(Rest, A, M).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	calculate(Node,N3):-	turnof(Against),
				getstates(Against,Node,Li),
				calculate2(Li,N3).
%calculate2([fail,fail,fail],N).
	calculate2([],0).
	calculate2([H|T],N):-H=true,calculate2(T,N1),N is N1+1.
	calculate2([H|T],N):-H=fail,calculate2(T,N1),N is N1-1.
