:-module(evaluation).
:-export([combtovalue/4,listofvalues/4]).
:-import(rules).
:-op(400,yfx,///). 
% combinations comes from bestsquare with all combinations of a square
combtovalue(Combinations,X,O,Max///N1///Min///N2):-listofvalues(Combinations,X,O,L),
														  mx(L,0,Max),num(Max,L,N1),
														  mn(L,5,Min),num(Min,L,N2).
num(_,[],0):-!.
num(Max,[Max|L],N):-!,num(Max,L,NN),N is NN+1.
num(Max,[H|L1],N):-num(Max,L1,N).
%listofvalues([[2 /// 1, 3 /// 1], [1 /// 2, 1 /// 3], [2 /// 2, 3 /// 3]] ,[3///3 ,4///4,6///6],[ 2///2, 4///5, 4///3],L).
listofvalues([],_,_,[]).
listofvalues([H|Rest],Xlist,Olist,L):-	H=[X1///Y1,X2///Y2],
													getvalue(X1///Y1,Xlist,Olist,V1),
													getvalue(X2///Y2,Xlist,Olist,V2),
													Value is V1+V2,
													L = [Value|T],
													listofvalues(Rest,Xlist,Olist,T).
			
getvalue(X///Y,Xlist,Olist,V):-	(is_member(X///Y,Xlist),V is 1,!);
											(is_member(X///Y,Olist),V is -1,!);
											(V is 0).					
:-end_module(evaluation).