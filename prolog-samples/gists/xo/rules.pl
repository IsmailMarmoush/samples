
:-module(rules,[delete/3,
		delmax/3,delnmax/3,delnmin/3,delmin/3,
		filterdelnmin/3,filterdelnmax/3,
		maxmax/3,minmin/3,nmax/3,nmin/3,
		mx/3,mn/3,
		filternmax/3,filternmin/3]). %elhamdolellah
:-use_module(list).
:-op(400,yfx,///).


delete(_,[],[]).
delete(X,[X|L],M):-!,delete(X,L,M).
delete(X,[Y|L1],[Y|L2]):-delete(X,L1,L2).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%   DELETE ALL SQUARES CONTAIN  MAX < E 
delmax(_,[],[]).
delmax(E,[X///Y///Max///Nmax///Min///Nmin|L],M):-Max<E,!,delmax(E,L,M).
delmax(E,[Anything|L1],[Anything|L2]):-delmax(E,L1,L2).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%  DELETE ALL SQUARES CONTAIN  nmax < E 
delnmax(_,[],[]).
delnmax(E,[X///Y///Max///Nmax///Min///Nmin|L],M):-Nmax<E,!,delnmax(E,L,M).
delnmax(E,[Anything|L1],[Anything|L2]):-delnmax(E,L1,L2).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%  DELETE ALL SQUARES CONTAIN  nmax > E         FOR FILTER
filterdelnmax(_,[],[]).
filterdelnmax(E,[X///Y///Max///Nmax///Min///Nmin|L],M):-Nmax>E,!,filterdelnmax(E,L,M).
filterdelnmax(E,[Anything|L1],[Anything|L2]):-filterdelnmax(E,L1,L2).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%  DELETE ALL SQUARES CONTAIN  nmin < E 
delnmin(_,[],[]).
delnmin(E,[X///Y///Max///Nmax///Min///Nmin|L],M):-Nmin<E,!,delnmin(E,L,M).
delnmin(E,[Anything|L1],[Anything|L2]):-delnmin(E,L1,L2).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%  DELETE ALL SQUARES CONTAIN  nmax > E         FOR FILTER
filterdelnmin(_,[],[]).
filterdelnmin(E,[X///Y///Max///Nmax///Min///Nmin|L],M):-Nmin>E,!,filterdelnmin(E,L,M).
filterdelnmin(E,[Anything|L1],[Anything|L2]):-filterdelnmin(E,L1,L2).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%   DELETE ALL VALUES OVER E
delmin(_,[],[]).
delmin((E),[X///Y///Max///Nmax///Min///Nmin|L],M):-Min>E,!,delmin(E,L,M).
delmin((E),[Anything|L1],[Anything|L2]):-delmin(E,L1,L2).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%   GET MAXIMUM OF MAX 	
maxmax([],X///Y///Max///Nmax///Min///Nmin,X///Y///Max///Nmax///Min///Nmin).
maxmax([X1///Y1///Max1///Nmax1///Min1///Nmin1|Rest],X///Y///Max///Nmax///Min///Nmin, V) :-
																	Max1 > Max,
																	maxmax(Rest, X1///Y1///Max1///Nmax1///Min1///Nmin1,V).
maxmax([X1///Y1///Max1///Nmax1///Min1///Nmin1|Rest],X///Y///Max///Nmax///Min///Nmin, V) :-
																	Max1 =< Max,
																	maxmax(Rest, X///Y///Max///Nmax///Min///Nmin, V).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%   GET MAXIMUM OF NMAX 																	
nmax([],X///Y///Max///Nmax///Min///Nmin,X///Y///Max///Nmax///Min///Nmin).
nmax([X1///Y1///Max1///Nmax1///Min1///Nmin1|Rest],X///Y///Max///Nmax///Min///Nmin, V) :-
																	Nmax1 > Nmax,
																	nmax(Rest, X1///Y1///Max1///Nmax1///Min1///Nmin1,V).
nmax([X1///Y1///Max1///Nmax1///Min1///Nmin1|Rest],X///Y///Max///Nmax///Min///Nmin, V) :-
																	Nmax1 =< Nmax,
																	nmax(Rest, X///Y///Max///Nmax///Min///Nmin, V).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%   GET MINIMUM OF NMAX 	FOR THE FILTER $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$																
filternmax([],X///Y///Max///Nmax///Min///Nmin,X///Y///Max///Nmax///Min///Nmin).
filternmax([X1///Y1///Max1///Nmax1///Min1///Nmin1|Rest],X///Y///Max///Nmax///Min///Nmin, V) :-
																	Nmax1 < Nmax,
																	filternmax(Rest, X1///Y1///Max1///Nmax1///Min1///Nmin1,V).
filternmax([X1///Y1///Max1///Nmax1///Min1///Nmin1|Rest],X///Y///Max///Nmax///Min///Nmin, V) :-
																	Nmax1 >= Nmax,
																	filternmax(Rest, X///Y///Max///Nmax///Min///Nmin, V).
																	
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%   GET MAXIMUM OF NMIN 																	
nmin([],X///Y///Max///Nmax///Min///Nmin,X///Y///Max///Nmax///Min///Nmin).
nmin([X1///Y1///Max1///Nmax1///Min1///Nmin1|Rest],X///Y///Max///Nmax///Min///Nmin, V) :-
																	Nmin1 > Nmin,
																	nmin(Rest, X1///Y1///Max1///Nmax1///Min1///Nmin1,V).
nmin([X1///Y1///Max1///Nmax1///Min1///Nmin1|Rest],X///Y///Max///Nmax///Min///Nmin, V) :-
																	Nmin1 =< Nmin,
																	nmin(Rest, X///Y///Max///Nmax///Min///Nmin, V).			
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%   GET MINIMUM OF NMIN 	FOR THE FILTER $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$					
filternmin([],X///Y///Max///Nmax///Min///Nmin,X///Y///Max///Nmax///Min///Nmin).
filternmin([X1///Y1///Max1///Nmax1///Min1///Nmin1|Rest],X///Y///Max///Nmax///Min///Nmin, V) :-
																	Nmin1 < Nmin,
																	filternmin(Rest, X1///Y1///Max1///Nmax1///Min1///Nmin1,V).
filternmin([X1///Y1///Max1///Nmax1///Min1///Nmin1|Rest],X///Y///Max///Nmax///Min///Nmin, V) :-
																	Nmin1 >= Nmin,
																	filternmin(Rest, X///Y///Max///Nmax///Min///Nmin, V).																																																	
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%   GET MINIMUM OF MIN 				
minmin([],X///Y///Max///Nmax///Min///Nmin,X///Y///Max///Nmax///Min///Nmin).
minmin([X1///Y1///Max1///Nmax1///Min1///Nmin1|Rest],X///Y///Max///Nmax///Min///Nmin, V) :-
																	Min1 < Min,
																	minmin(Rest, X1///Y1///Max1///Nmax1///Min1///Nmin1,V).
minmin([X1///Y1///Max1///Nmax1///Min1///Nmin1|Rest],X///Y///Max///Nmax///Min///Nmin, V) :-
																	Min1 >= Min,
																	minmin(Rest, X///Y///Max///Nmax///Min///Nmin, V).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
mx([], MaxSoFar, MaxSoFar).
mx([Number|Rest], MaxSoFar, Max) :-Number > MaxSoFar,mx(Rest, Number, Max).
mx([Number|Rest], MaxSoFar, Max) :-Number =< MaxSoFar,mx(Rest, MaxSoFar, Max).
    
mn([], MaxSoFar, MaxSoFar). 
mn([Number|Rest], MaxSoFar, Max) :-Number < MaxSoFar,mn(Rest, Number, Max).
mn([Number|Rest], MaxSoFar, Max) :-Number >= MaxSoFar,mn(Rest, MaxSoFar, Max).


