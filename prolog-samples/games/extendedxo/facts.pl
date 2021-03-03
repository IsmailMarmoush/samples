:-module(facts,[turnof/1,turnasserter/1,reverser/0,
		onlevel/1,incrementonlevel/0,decrementonlevel/0,level/2,flat/3,levelasserter/1,
		numnodes/4,aline/1]).
:-dynamic turnof/1,level/2,onlevel/1.

%computer playes against.
turnof(black).
turnasserter(X):-retract(turnof(_)),assert(turnof(X)).

computer_is(red).
human_is(black).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%   reverser 
reverser:-turnof(X),X=red,retract(turnof(red)),assert(turnof(black)),!;
		turnof(X),X=black,retract(turnof(black)),assert(turnof(red)).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
onlevel(0).
incrementonlevel:-onlevel(X),retract(onlevel(X)),Y is X+1,assert(onlevel(Y)).
decrementonlevel:-onlevel(X),retract(onlevel(X)),Y is X-1,assert(onlevel(Y)).
%asserting levels
level(0,[]).
level(1,[]).
level(2,[]).
level(3,[]).
level(4,[]).
level(5,[]).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

flat([],All,All).
flat([Node|Rest],Node2,All):-append(Node,Node2,Nodes),flat(Rest,Nodes,All).




%numering the nodes
numnodes(_,[],[],0).
numnodes(Initial,[Node|Rest],Newnodes,N):-Newnodes=[[Initial,N,Node]|Restnew],
					  numnodes(Initial,Rest,Restnew,N1),N is N1+1.



levelasserter(Info):-onlevel(Lnumb),retract(level(Lnumb,_)),assert(level(Lnumb,Info)).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%% aline %%%%%
aline([1,2,3]).
aline([4,5,6]).
aline([7,8,9]).
aline([1,4,7]).
aline([1,5,9]).
aline([3,6,9]).
aline([3,5,7]).
aline([2,5,8]).
