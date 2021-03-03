:-use_module(generator).
:-use_module(testing).
:-use_module(maximum).
%goal    play(Against,Board,Move).

%asserting levels
level(0,Nodes).
level(1,Nodes).
level(2,Nodes).
level(3,Nodes).
level(4,Nodes).
level(5,Nodes).
		% nodes in levels are generated with numbers Node=[1,[N],8] 
		% so it's the 8th node and it's initial is 1st node
%generate his level , check if true delete initial , goto 1st step with new list. if failed replace with best..
%then generate next level
play(Against,Board,Move):-checkeachnode(Against,[Board],Win),not(Win=[]),write('winning position'),!.
play(Against,Board,Move):-write('hi').
% there is a [board] before leveling
leveling(Against,Board,Initial,Levelrank,Level):-generateagainst(Against,Board,Nodes),
						numnodes(Initial,Nodes,Newnodes,_),
						retract(level(LevelRank,_)),
						asserta(level(LevelRank,Newnodes)).
%numering the nodes
numnodes(_,[],[],0).
numnodes(Initial,[Node|Rest],Newnodes,N):-	Newnodes=[[Initial,N,Node]|Restnew],
						numnodes(Initial,Rest,Restnew,N1),N is N1+1.


