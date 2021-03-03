%:-module(start,[generator/0,flat2/3).
:-use_module(generator).
:-use_module(test).
:-use_module(facts).
%play([[red,7,true],[red,2,fail],[red,3,fail],[black,4,true],[black,5,fail],[black,6,true]],red,M).
%play([[red,7,true],[red,2,true],[red,3,true],[black,4,true],[black,5,fail],[black,6,true]],red,M).
%play([[red,5,true],[red,7,fail],[red,9,true],[black,1,fail],[black,3,true],[black,6,true]],red,M).
%gen([[0,1,[[red,7,true],[red,2,fail],[red,3,fail],[black,4,true],[black,5,fail],[black,6,true]]],
%[0,1,[[red,7,true],[red,2,fail],[red,3,fail],[black,4,true],[black,5,fail],[black,6,true]]]],[A]).
play(Board,Turnof,Move):-	turnasserter(Turnof),reverser,
				levelasserter([[0,1,Board]]),generator(Move).

generator(Move):-	onlevel(L),level(L,Nodes),incrementonlevel,
			gen(Nodes,Allnodes),flat(Allnodes,[],Readyforlevel),
			levelasserter(Readyforlevel),check(Move).

check(Move):-		onlevel(L),member(L,[1,3,5]),level(L,Nodes),
			checklevelnodes(Nodes,Move).%not(Winners=[]),search([Winners],Move),
			%generator(Move).

check(Move):-		onlevel(L),member(L,[2,4]),level(L,Nodes),
			checklevelnodes(Nodes,[Initialofit,_,_]),
			decrementonlevel,onlevel(L2),level(L2,Nodes2),
			delete(Nodes2,[_,Initialofit,_],Nodes3),levelasserter(Nodes3),
			reverser,generator(Move).
%check(Move):-onlevel(L),member(L,[2,4]),level(L,Nodes),checklevelnodes(Nodes,Winners),search(Winners,D),

search([],[]).
search([[Initialof,_,_]|Rest],[Thenode|Rest2]):-onlevel(Inlevel),
					search2(Initialof,Thenode,Inlevel),
					search(Rest,Rest2).
search2(Initialof,Thenode,1):-	level(1,Nodes),
			member([PreInitial,Initialof,Theone],Nodes),
			Thenode=[PreInitial,Initialof,Theone],write(Thenode).
search2(Initialof,Thenode,Inlevel):-Inlevel>1,search2(Initialof,Thenode,Inlevel1),Inlevel is Inlevel1-1.

reset:-
retract(turnof(_)),assert(turnof(black)),
retract(onlevel(_)),assert(onlevel(0)),
retract(level(0,_)),assert(level(0,[])),
retract(level(1,_)),assert(level(1,[])),
retract(level(2,_)),assert(level(2,[])),
retract(level(3,_)),assert(level(3,[])),
retract(level(4,_)),assert(level(4,[])),
retract(level(5,_)),assert(level(5,[])).
reset2:-
retract(turnof(_)),
retract(onlevel(_)),
retract(level(0,_)),
retract(level(1,_)),
retract(level(2,_)),
retract(level(3,_)),
retract(level(4,_)),
retract(level(5,_)).
