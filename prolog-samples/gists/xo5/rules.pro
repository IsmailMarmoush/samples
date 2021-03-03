:-module(rules).
:-import(list).
:-export([delete/3,mx/3,mn/3,maximaM/3,minimaM/3,maximaN/3,empty/3]). %elhamdolellah
:-op(400,xfx,////).
:-op(400,yfx,///).

empty(Xlist,Olist,Empty):-genallsquares(X,Y,All),append(Xlist,E1,All),append(Olist,Empty,E1).

delete(_,[],[]).
delete(X,[X|L],M):-!,delete(X,L,M).
delete(X,[Y|L1],[Y|L2]):-delete(X,L1,L2).

maximaM([], X///Y////A///N, X///Y////A///N).
maximaM([X///Y////H///N|T], X1///Y1////A///N1, M) :- H >= A, 	maximaM(T, X///Y////H///N, M).
maximaM([X///Y////H///N|T], X1///Y1////A///N1, M) :- H =< A, 	maximaM(T, X1///Y1////A///N1, M).

minimaM([], X///Y////A///N, X///Y////A///N).
minimaM([X///Y////H///N|T], X1///Y1////A///N1, M) :- H =< A, 	maximaM(T, X///Y////H///N, M).
minimaM([X///Y////H///N|T], X1///Y1////A///N1, M) :- H >= A, 	maximaM(T, X1///Y1////A///N1, M).

maximaN([],X///Y////M///A , X///Y////M///A).
maximaN([X///Y////M///H|T], X1///Y1////M1///A, Max) :- H >= A, 	maximaN(T, X///Y////M///H, Max).
maximaN([X///Y////M///H|T], X1///Y1////M1///A, Max) :- H =< A, 	maximaN(T, X1///Y1////M1///A, Max).


mx([], MaxSoFar, MaxSoFar).
mx([Number|Rest], MaxSoFar, Max) :-Number > MaxSoFar,mx(Rest, Number, Max).
mx([Number|Rest], MaxSoFar, Max) :-Number =< MaxSoFar,mx(Rest, MaxSoFar, Max).
    
mn([], MaxSoFar, MaxSoFar). 
mn([Number|Rest], MaxSoFar, Max) :-Number < MaxSoFar,mn(Rest, Number, Max).
mn([Number|Rest], MaxSoFar, Max) :-Number >= MaxSoFar,mn(Rest, MaxSoFar, Max).

:-end_module(rules).