:-import(rules).
:-import(gen).
:-import(evaluation).
:-import(list).
:-op(400,xfx,////).
:-op(400,yfx,///).
bestsquare(Xlist,Olist,X///Y):-
								empty(Xlist,Olist,Empty),
								getminmax(Empty,Xlist,Olist,Allattachmax,Allattachedmin),
								randomizing(Allattachmax,Allattachedmin,X///Y).

getminmax([],_,_,[],[]).
getminmax([X///Y|Rest],Xlist,Olist,Allattachedmax,Allattachedmin):-
													generator(X///Y,L),
													maximum(L,Xlist,Olist,Max///Nmax),
													minimum(L,Xlist,Olist,Min///Nmin),
													Allattachedmax=[X///Y////Max///Nmax |Tailmax],
													Allattachedmin=[X///Y////Min///Nmin |Tailmin],
													getminmax(Rest,Xlist,Olist,Tailmax,Tailmin).
randomizing(Max,Min,X///Y):-
										maximaM(Max,_///_////0///_,MaxM),
										minimaM(Min,_///_////10///_,MinM),
										%MaxMlist,MinMlist
										maximaN(MaxMlist,_///_////_///0,MaxN),
										maximaN(MinMlist,_///_////_///10,MaxN),
										%MaxNlist,MinNlist
										random_elem(MaxNlist,Tomax),
										random_elem(MinNlist,Tomin),
										maxormin(Tomax,Tomin,X///Y).
										
m(M):-maximaN([(1 /// 1) //// 2 /// 5, (2 /// 3) //// 1 /// 3, (2 /// 2) //// 2 /// 2, (4 /// 5) //// 1 /// 5],_///_////_///0,M).													
%getminmax([1///1,2///3,2///2,4///5],[2///4,1///2,1///3,2///3,4///3],[3///2,3///4,4///3,3///5,6///3],A,A2).
%A = [(1 /// 1) //// 2 /// 1, (2 /// 3) //// 1 /// 3, (2 /// 2) //// 2 /// 2, (4 /// 5) //// 1 /// 5] ;