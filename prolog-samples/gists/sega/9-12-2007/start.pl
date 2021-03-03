%:-module(start,generator/0).
:-use_module(generator).
:-use_module(facts).
%play([[red,7,true],[red,2,fail],[red,3,fail],[black,4,true],[black,5,fail],[black,6,true]],red,M).
play(Board,Turnof,_):-	turnasserter(Turnof),reverser,onlevel(L),
				levelasserter([[0,1,Board]]),
				level(L,Nodes),incrementonlevel,
				gen(Nodes,Allnodes),flat(Allnodes,[Flattened]),
				numnodes(1,Flattened,Readyforlevel,_),levelasserter(Readyforlevel).%check,
reset:-
retract(turnof(_)),assert(turnof(black)),
retract(onlevel(_)),assert(onlevel(0)),
retract(level(0,_)),assert(level(0,[])),
retract(level(1,_)),assert(level(1,[])),
retract(level(2,_)),assert(level(2,[])),
retract(level(3,_)),assert(level(3,[])),
retract(level(4,_)),assert(level(4,[])),
retract(level(5,_)),assert(level(5,[])).
