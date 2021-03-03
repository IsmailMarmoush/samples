:-module(test,[checklevelnodes/2]).
:-use_module(facts).
:-use_module(getmodule).

checklevelnodes([],_).
checklevelnodes([[Initial,Nodenum,Node]|_],Winningnode):-
			testnode(Node,Answer),Answer=yes,Winningnode=[Initial,Nodenum,Node],!.
checklevelnodes([[_,_,Node]|Rest],N):-
			testnode(Node,Answer),Answer=no,checklevelnodes(Rest,N).


testnode(Node,Answer):-		turnof(Against),
				getpositions(Against,Node,Positions),
				testaline(Positions,_),
				getstates(Against,Node,States),
				not(member(fail,States)),Answer=yes,!;Answer=no.

testaline([],_).
testaline([N|Rest],Z):-aline(Z),member(N,Z),testaline(Rest,Z).
