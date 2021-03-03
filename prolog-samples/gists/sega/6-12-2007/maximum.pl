:-module(maximum,[max/4]).
:-use_module(generator).

%max(black,[[[red,7,fail],[red,2,fail],[red,3,fail],[black,4,true],[black,5,fail],[black,6,true]],
%[[red,7,true],[red,2,fail],[red,3,fail],[black,4,true],[black,5,fail],[black,6,true]],
%[[red,7,fail],[red,2,true],[red,3,fail],[black,4,true],[black,5,fail],[black,6,true]],
%[[red,7,fail],[red,2,fail],[red,3,true],[black,4,true],[black,5,fail],[black,6,true]],
%[[red,7,true],[red,2,true],[red,3,true],[black,4,true],[black,5,fail],[black,6,true]]],-4,Max).
max(_,[], A, A).
max(Against,[Node|Rest], A, M) :-calculate(Against,Node,N),N > A,  max(Against,Rest,N, M).
max(Against,[Node|Rest], A, M) :-calculate(Against,Node,N),N =< A, max(Against,Rest, A, M).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
calculate(Against,Node,N3):-getstates(Against,Node,Li),calculate2(Li,N3).
%calculate2([fail,fail,fail],N).
calculate2([],0).
calculate2([H|T],N):-H=true,calculate2(T,N1),N is N1+1.
calculate2([H|T],N):-H=fail,calculate2(T,N1),N is N1-1.

