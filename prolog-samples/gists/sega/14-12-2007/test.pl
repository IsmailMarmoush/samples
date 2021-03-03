:-module(test,[checknodes/3]).
:-use_module(facts).
:-use_module(getmodule).


testnode(Node,Answer):-		turnof(Against),
				getpositions(Against,Node,Positions),
				testaline(Positions,_),
				getstates(Against,Node,States),
				not(member(fail,States)),Answer=yes,!;Answer=no.
testaline([],_).
testaline([N|Rest],Z):-aline(Z),member(N,Z),testaline(Rest,Z).
