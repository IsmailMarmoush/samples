:-import(rules).
:-import(gen).
:-import(evaluation).
:-import(list).
:-op(400,xfx,////).
:-op(400,yfx,///).

bestsq(S1,S2):-bestsquares([3///1 ,5///1],[ 3///7, 5///7],S1,S2).
bestsquares(Xlist,Olist,X1///Y1////M1///N1,X2///Y2////M2///N2):-
								empty(Xlist,Olist,Empty),
								getminmax(Empty,Xlist,Olist,Allattachedmax,Allattachedmin),write(Allattachedmin),nl,
								maximaM(Allattachedmax,_///_////(-1)///_,X1///Y1////M1///N1),
								minimaM(Allattachedmin,_///_////(20)///_,X2///Y2////M2///N2).
								
empty(Xlist,Olist,E):-append(Xlist,Olist,L),genmatrix(7,7,All),compare_lists(All,L,E).

getminmax([],_,_,[],[]).
getminmax([X///Y|Rest],Xlist,Olist,Allattachedmax,Allattachedmin):-
													generator(X///Y,L),
													maximum(L,Xlist,Olist,Max///Nmax),
													minimum(L,Xlist,Olist,(Min)///Nmin),
													Allattachedmax=[X///Y////Max///Nmax |Tailmax],
													Allattachedmin=[X///Y////(Min)///Nmin |Tailmin],
													getminmax(Rest,Xlist,Olist,Tailmax,Tailmin).

