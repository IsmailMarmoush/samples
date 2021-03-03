:-module(evaluation).
:-export(maximum/4).
:-op(400,yfx,///). 
%[[2 /// 3, 3 /// 3], [1 /// 2, 1 /// 1], [1 /// 4, 1 /// 5], [2 /// 2, 3 /// 1], [2 /// 4, 3 /// 5], [1 /// 2, 1 /// 4]] 
maximum(Combinations,X,O,Max///N):-listofvalues(Combinations,X,O,L),mx(L,0,Max),num(Max,L,N).
minimum(Combinations,X,O,Min///N):-listofvalues(Combinations,X,O,L),mn(L,10,Min),num(Min,L,N).
%mx([1,6,23,21], 0, Max).num(23,[2,23,1,2,3,23,42],N).
num(_,[],0):-!.
num(Max,[Max|L],N):-!,num(Max,L,NN),N is NN+1.
num(Max,[H|L1],N):-num(Max,L1,N).
mx([], MaxSoFar, MaxSoFar).
mx([Number|Rest], MaxSoFar, Max) :-
       Number > MaxSoFar,
       mx(Rest, Number, Max).
mx([Number|Rest], MaxSoFar, Max) :-
       Number =< MaxSoFar,
       mx(Rest, MaxSoFar, Max).

mn([], MaxSoFar, MaxSoFar). 
mn([Number|Rest], MaxSoFar, Max) :-
       Number < MaxSoFar,
       mn(Rest, Number, Max).
mn([Number|Rest], MaxSoFar, Max) :-
       Number >= MaxSoFar,
       mn(Rest, MaxSoFar, Max).
%maximum([[2 /// 3, 3 /// 3], [1 /// 2, 1 /// 1], [1 /// 4, 1 /// 5], [2 /// 2, 3 /// 1], [2 /// 4, 3 /// 5], [1 /// 2, 1 /// 4]],[1///1,3///3,1///5,2///2],[3///1,1///4,3///5],M///N).

%listofvalues([[2 /// 1, 3 /// 1], [1 /// 2, 1 /// 3], [2 /// 2, 3 /// 3]],[2 /// 1, 3 /// 1],[1 /// 2, 1 /// 3],LofV).
listofvalues([],_,_,[]).
listofvalues([H|Rest],Xlist,Olist,L):-	evaluation(H,Xlist,Olist,Value),write(Value),nl,
													L = [Value|T],
													listofvalues(Rest,Xlist,Olist,T).
													%Max is MM+1,N is NN+1.
evaluation([X1///Y1,X2///Y2],Xlist,Olist,V):-getvalue(X1///Y1,Xlist,Olist,V1),
															getvalue(X2///Y2,Xlist,Olist,V2),
															V is V1+V2.
getvalue(X///Y,Xlist,Olist,V1):-	(is_member(X///Y,Xlist),V1 is 1,!);
											(is_member(X///Y,Olist),
											V1 is -1,!);
											(V1 is 0).			
											
											
:-end_module(evaluation).