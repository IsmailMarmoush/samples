:-module(generator,[gen/2]).
:-use_module(facts).
:-use_module(getmodule).

%gen([[0,1,[[red,7,true],[red,2,fail],[red,3,fail],[black,4,true],[black,5,fail],[black,6,true]]],
%[0,2,[[red,7,true],[red,2,fail],[red,3,fail],[black,4,true],[black,5,fail],[black,6,true]]]],All),
%tell('hello.txt'),flat(All,[M]),write(M),told.

gen([],[]).
gen([[_,_,Node]|Rest],[Nodes|Restlevelnodes]):-nodegenerator(Node,Nodes),gen(Rest,Restlevelnodes).
nodegenerator(Board,Nodes):-	
				turnof(Against),
				getpositions(Against,Board,Positions),
				getsquares(Board,ESquares),
				combinator(Positions,ESquares,Movelist),
				join(Board,Movelist,Nodes).

%join the MOves with nodes
join(_,[],[]).
join(Oldboard,[Move|Restmoves],Nodes):- addmove(Move,Oldboard,Newboard),
					Nodes=[Newboard|Restnodes],
					join(Oldboard,Restmoves,Restnodes).
addmove(_,[],[]).
addmove([X,Y],[[Name,P,_]|Restpieces],Newboard):-
				X=:=P,State=true,
				Newboard=[[Name,Y,State]|Rest],
				addmove([X,Y],Restpieces,Rest).
addmove([X,Y],[[Name,P,State]|Restpieces],Newboard):-
				X=\=P,
				Newboard=[[Name,P,State]|Rest],
				addmove([X,Y],Restpieces,Rest).
%get moves concatenate  X  moved to Y
combinator([X1,X2,X3],[Y1,Y2,Y3],Movelist):-
		Movelist=[[X1,Y1],[X1,Y2],[X1,Y3],[X2,Y1],[X2,Y2],[X2,Y3],[X3,Y1],[X3,Y2],[X3,Y3]].

