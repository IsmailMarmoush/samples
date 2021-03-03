:-module(generator,[getpositions/3,generateagainst/3]).

% generator main   	Board=[Piece|Restpieces],  nodes=[Board|RestBoards]  
generateagainst(Against,Board,Nodes):-
					getpositions(Against,Board,Positions),
					getsquares(Board,ESquares),
					combinator(Positions,ESquares,Movelist),
					join(Board,Movelist,Nodes).
%getpositions
%(red,[[red,1,true],[black,2,true],[red,3,true],[black,4,true],[red,5,true],[black,6,true]],Pos).
getpositions(_,[],[]).
getpositions(Against,[[Against,_,_]|Restpieces],Positions):-!,
			getpositions(Against,Restpieces,Positions).
getpositions(Against,[[_,Position,_]|Restpieces],[Position|Restpositions]):-
			getpositions(Against,Restpieces,Restpositions).		

%get empty squares
getsquares(Board,ESquares):-	getpositions(red,Board,P1),
				getpositions(black,Board,P2),
				append(P1,P2,P3),subtract([1,2,3,4,5,6,7,8,9],P3,ESquares).	
	
%get moves concatenate  X  moved to Y
combinator([X1,X2,X3],[Y1,Y2,Y3],Movelist):-
		Movelist=[[X1,Y1],[X1,Y2],[X1,Y3],[X2,Y1],[X2,Y2],[X2,Y3],[X3,Y1],[X3,Y2],[X3,Y3]].

%join the MOves with nodes
join(_,[],_).
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



