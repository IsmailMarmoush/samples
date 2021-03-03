:-module(rules).
:-import(list).
:-export([delete/3,mx/3,mn/3,maximaM/3,minimaM/3]). %elhamdolellah
:-op(400,xfx,////).
:-op(400,yfx,///).

delete(_,[],[]).
delete(X,[X|L],M):-!,delete(X,L,M).
delete(X,[Y|L1],[Y|L2]):-delete(X,L1,L2).

maximaM([], X///Y////A///N, X///Y////A///N).
maximaM([X///Y////H///N|T], X1///Y1////A///N1, M) :- H > A, 		maximaM(T, X///Y////H///N, M).
maximaM([X///Y////H///N|T], X1///Y1////A///N1, M) :- H = A,N > N1 ,	maximaM(T, X///Y////H///N, M).
maximaM([X///Y////H///N|T], X1///Y1////A///N1, M) :- H =< A, 		maximaM(T, X1///Y1////A///N1, M).

minimaM([], X///Y////(A)///N, X///Y////(A)///N).
minimaM([X///Y////(H)///N|T], X1///Y1////(A)///N1, M) :- H < A, 		minimaM(T, X///Y////(H)///N, M).
minimaM([X///Y////(H)///N|T], X1///Y1////(A)///N1, M) :- H = A,N >N1, 	minimaM(T, X///Y////(H)///N, M).
minimaM([X///Y////(H)///N|T], X1///Y1////(A)///N1, M) :- H >= A, 		minimaM(T, X1///Y1////(A)///N1, M).

mx([], MaxSoFar, MaxSoFar).
mx([Number|Rest], MaxSoFar, Max) :-Number > MaxSoFar,mx(Rest, Number, Max).
mx([Number|Rest], MaxSoFar, Max) :-Number =< MaxSoFar,mx(Rest, MaxSoFar, Max).
    
mn([], MaxSoFar, MaxSoFar). 
mn([Number|Rest], MaxSoFar, Max) :-Number < MaxSoFar,mn(Rest, Number, Max).
mn([Number|Rest], MaxSoFar, Max) :-Number >= MaxSoFar,mn(Rest, MaxSoFar, Max).

:-end_module(rules).