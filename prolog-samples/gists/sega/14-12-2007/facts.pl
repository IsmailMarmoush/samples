:-module(facts,[turnof/1,onlevel/1,aline/1,level/2,incrementonlevel/0,
		turnasserter/1,reverser/0,clearlevel/1,levelasserter/2,
		levelappender/3,numnodes/5]).
:-dynamic turnof/1,level/2,onlevel/1.

turnof(black).
onlevel(0).

%%%%% aline %%%%%
aline([1,2,3]).
aline([4,5,6]).
aline([7,8,9]).
aline([1,4,7]).
aline([1,5,9]).
aline([3,6,9]).
aline([3,5,7]).
aline([2,5,8]).

%asserting levels
level(0,[]).
level(1,[]).
level(2,[]).
level(3,[]).
level(4,[]).
level(5,[]).

incrementonlevel:-onlevel(X),retract(onlevel(X)),Y is X+1,assert(onlevel(Y)).

turnasserter(X):-retract(turnof(_)),assert(turnof(X)).

reverser:-turnof(X),X=red,retract(turnof(red)),assert(turnof(black)),!;
	  turnof(X),X=black,retract(turnof(black)),assert(turnof(red)).

clearlevel(L):-retract(level(L,_)),assert(level(L,[])).
levelasserter(Lnumb,Info):-retract(level(Lnumb,_)),assert(level(Lnumb,Info)).

levelappender(Lnumb,Gnodes,Initial):-	level(Lnumb,Nodes),
					numnodes(Initial,Nodes,Gnodes,Newnodes,_),
					append(Nodes,Newnodes,Info),
					levelasserter(Lnumb,Info).
%numering the nodes
numnodes(_,Nodes,[],[],Number):-last(Nodes,Node),nth1(Number,Nodes,Node).
numnodes(Initial,Nodes,[Node|Rest],Newnodes,N):-Newnodes=[[Initial,N,Node]|Restnew],
					  numnodes(Initial,Nodes,Rest,Restnew,N1),N is N1+1.
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

