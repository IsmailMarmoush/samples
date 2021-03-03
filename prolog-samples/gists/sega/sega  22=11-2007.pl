
%%%%% aline %%%%%
aline([1,2,3]).
aline([4,5,6]).
aline([7,8,9]).
aline([1,4,7]).
aline([1,5,9]).
aline([3,6,9]).
aline([3,5,7]).
aline([2,5,8]).

% test aline %
testaline([],_).
testaline([N|Rest],Z):-aline(Z),member(N,Z),testaline(Rest,Z).

%%%%%%%%%%% piece %%%%%%%%

%	Piece=[Name,Position,State].

%%%%%%% board state %%%%%%%  

%	Board=[Piece|RestPieces].
%  test board   % testboard([[r1,1,true],[r2,2,true],[r3,3,fail]]).
testboard([Piece1|Restpieces]):-
		Piece1=[_,Position1,State1],State1,
		Restpieces=[Piece2|R2],
		Piece2=[_,Position2,State2],State2,
		R2=[Piece3|_],
		Piece3=[_,Position3,State3],State3,
		testaline([Position1,Position2,Position3],_).

%%%%%%% node state %%%%%%%%%%

%	Node=[Num,Level,Game,Board].

%%%%%%%%%% Path %%%%%%%%%%%%%

%	Path=[InitialNode|Restnodes].
%%%%%%%%%% Tree %%%%%%%%%%%%%

%	Tree=[Path|Restpaths].

%%%%%%%%%% Goal %%%%%%%%%%%%%

%	goal(Board,move).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%  Main program  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%% test for goal %%%%%%%%%
