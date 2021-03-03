:-module(generator,[gen_test/4]).
:-use_module(test).
:-use_module(facts).
:-use_module(getmodule).

gen_test([],_,[]).
gen_test([[_,Y,Z]|Rest],Level,[Move|Restmoves]):-
					nodegenerator(Z,Gnodes),check(Gnodes,Winners),
					Move=Winners
checknodes(Gnodes,Answer1,Move1),					
Answer1=yes,Answer=yes,Move=Move1,!;
					
					Answer1=no,levelappender(Level,Gnodes,Y),
					gen_test(Rest,Level,Answer,Move).
nodegenerator(Board,Nodes):-	
				turnof(Against),
				getpositions(Against,Board,Positions),
				getsquares(Board,ESquares),
				combinator(Positions,ESquares,Movelist),
				join(Board,Movelist,Nodes).
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
combinator([X1,X2,X3],[Y1,Y2,Y3],Movelist):-
		Movelist=[[X1,Y1],[X1,Y2],[X1,Y3],[X2,Y1],[X2,Y2],[X2,Y3],[X3,Y1],[X3,Y2],[X3,Y3]].

