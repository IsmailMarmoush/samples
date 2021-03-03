:-module(evaluation).
:-export([maximum/4,minimum/4]).
:-import(rules).
:-op(400,yfx,///). 

maximum(Combinations,X,O,Max///N):-listofvalues(Combinations,X,O,L),mx(L,0,Max),num(Max,L,N).
minimum(Combinations,X,O,Min///N):-listofvalues(Combinations,X,O,L),mn(L,10,Min),num(Min,L,N).

num(_,[],0):-!.
num(Max,[Max|L],N):-!,num(Max,L,NN),N is NN+1.
num(Max,[H|L1],N):-num(Max,L1,N).

listofvalues([],_,_,[]).
listofvalues([H|Rest],Xlist,Olist,L):-	evaluation(H,Xlist,Olist,Value),
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