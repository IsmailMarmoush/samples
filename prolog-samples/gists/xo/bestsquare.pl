:-use_module(rules).
:-use_module(gen).
:-use_module(lastfilter).
:-use_module(evaluation).
:-use_module(list).

:-op(400,yfx,///).


all(Xlist,Olist,Limitx,Limity,ONE,TWO):-
								empty(Xlist,Olist,Empty,Limitx,Limity),
								getminmax(Empty,Xlist,Olist,Limitx,Limity,Allsquaresvalues),
								%FILTER WITH MAX VALUES
								maxmax(Allsquaresvalues,_///_///(-1)///_///_///_,_///_///E1///_///_///_),
								delmax(E1,Allsquaresvalues,Newvalues1),
								%FILTER WITH MIN VALUES
								minmin(Newvalues1,_///_///_///_///5///_,_///_///_///_///(E2)///_),
								delmin(E2,Newvalues1,Newvalues2),
								%FILTER WITH  NMAX VALUES
								nmax(Newvalues2,_///_///_///(-1)///_///_,_///_///_///E3///_///_),
								delnmax(E3,Newvalues2,Newvalues3),
								%FILTER WITH  NMAX VALUES
								nmin(Newvalues3,_///_///_///_///_///(-1),_///_///_///_///_///E4),
								delnmin(E4,Newvalues3,Newvalues4),
								%GETTING THE lastfilter
								xyfilter(Newvalues4,Newvalues5),
								%FILTERING THE NMAX
								filternmax(Newvalues5,_///_///_///5///_///_,_///_///_///E5///_///_),
								filterdelnmax(E5,Newvalues5,Newvalues6),
								%FILTERING THE NMIN
								filternmin(Newvalues6,_///_///_///_///_///5,_///_///_///_///_///E6),
								filterdelnmin(E6,Newvalues6,Newvalues7),
								%time(X,Y,Z),Randoms is X+Y+Z,
								%get_time(Z),stamp_date_time(Z,D,'UTC'),D=date(_,_,_,X,Y,Z,_,_,_),Randoms is X+Y+Z,
								shuffle(Newvalues7,Newvalues8),
								random_elem(Newvalues8,Element),
								Element=ONE///TWO///THREE///FOUR///FIVE///SIX.
								
empty(Xlist,Olist,E,Limitx,Limity):-
							append(Xlist,Olist,L),
							genmatrix(Limitx,Limity,All),
							compare_lists(All,L,E).
getminmax([],_,_,_,_,[]).
getminmax([X///Y|Rest],Xlist,Olist,Limitx,Limity,Allsquaresvalues):-
																generator(X///Y,Combinations,Limitx,Limity),
																combtovalue(Combinations,Xlist,Olist,Max///Nmax///Min///Nmin),
																Allsquaresvalues=[X///Y///Max///Nmax///Min///Nmin|Tail],
																getminmax(Rest,Xlist,Olist,Limitx,Limity,Tail).


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
shuffle(Tin, Tout) :-
  shuffle1(Tin, [], Tout).

  shuffle1([], A, A).
  shuffle1(Tin, A, Tout) :-
    length(Tin, L),
    
    N is 1 + integer( random(40) * L ),
    deleteN(N, Elem, Tin, Tx),
    shuffle1(Tx, [Elem|A], Tout).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
random_elem(L, A) :-
   length(L, N),
   R is 1 + integer( random(40) * N ),
   nth_elem(L, A, R).
%%%%%%%%%%%%%%%%%%%%%%%5
%all([1///2],[2///3],3,3,O,T).