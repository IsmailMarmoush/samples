:-module(gen).
:-export([generator/4,genmatrix/3]).
:-import(rules). 
:-import(list).
:-op(400,yfx,///).

generator(X///Y,Clist,Limitx,Limity):-genn(X///Y,List,Limitx,Limity),delete([],List,Clist).
genn(X///Y,List,Limitx,Limity):-
							right(X///Y,L1,Limitx,Limity),
							left(X///Y,L2,Limitx,Limity),
							up(X///Y,L3,Limitx,Limity),
							down(X///Y,L4,Limitx,Limity),
							rightup(X///Y,L5,Limitx,Limity),
							leftup(X///Y,L6,Limitx,Limity),
							rightdown(X///Y,L7,Limitx,Limity),
							leftdown(X///Y,L8,Limitx,Limity),
							centerupdown(X///Y,L9,Limitx,Limity),
							centerrightleft(X///Y,L10,Limitx,Limity),
							centercornerright(X///Y,L11,Limitx,Limity),
							centercornerleft(X///Y,L12,Limitx,Limity),
							List=[L1,L2,L3,L4,L5,L6,L7,L8,L9,L10,L11,L12].
							
right(X///Y,L,Limitx,Limity)					:-X1 is X+1, X2 is X+2,									adding(X1///Y,X2///Y,L,Limitx,Limity).
left(X///Y,L,Limitx,Limity)					:-X1 is X-1, X2 is X-2,									adding(X1///Y,X2///Y,L,Limitx,Limity).
up(X///Y,L,Limitx,Limity)						:-Y1 is Y-1, Y2 is Y-2,									adding(X///Y1,X///Y2,L,Limitx,Limity).
down(X///Y,L,Limitx,Limity)					:-Y1 is Y+1, Y2 is Y+2,									adding(X///Y1,X///Y2,L,Limitx,Limity).
rightup(X///Y,L,Limitx,Limity)				:-X1 is X+1, X2 is X+2,Y1 is Y-1,Y2 is Y-2,		adding(X1///Y1,X2///Y2,L,Limitx,Limity).
leftup(X///Y,L,Limitx,Limity)					:-X1 is X-1, X2 is X-2,Y1 is Y-1,Y2 is Y-2,		adding(X1///Y1,X2///Y2,L,Limitx,Limity).
rightdown(X///Y,L,Limitx,Limity)				:-X1 is X+1, X2 is X+2,Y1 is Y+1,Y2 is Y+2,		adding(X1///Y1,X2///Y2,L,Limitx,Limity).
leftdown(X///Y,L,Limitx,Limity)				:-X1 is X-1, X2 is X-2,Y1 is Y+1,Y2 is Y+2,		adding(X1///Y1,X2///Y2,L,Limitx,Limity).
centerupdown(X///Y,L,Limitx,Limity)			:-Y1 is Y-1, Y2 is Y+1,									adding(X///Y1,X///Y2,L,Limitx,Limity).
centerrightleft(X///Y,L,Limitx,Limity)		:-X1 is X+1, X2 is X-1,									adding(X1///Y,X2///Y,L,Limitx,Limity).
centercornerright(X///Y,L,Limitx,Limity)	:-X1 is X+1, X2 is X-1,Y1 is Y-1,Y2 is Y+1,		adding(X1///Y1,X2///Y2,L,Limitx,Limity).
centercornerleft(X///Y,L,Limitx,Limity)	:-X1 is X-1, X2 is X+1,Y1 is Y-1,Y2 is Y+1,		adding(X1///Y1,X2///Y2,L,Limitx,Limity).

adding(X1///Y1,X2///Y2,L,Limitx,Limity):-
X1=<Limitx,X1>=1,
X2=<Limitx,X2>=1,
Y1=<Limity,Y1>=1,
Y2=<Limity,Y2>=1,
L =[X1///Y1,X2///Y2],!;L=[].

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
genmatrix(X,Y,L2):-X1 is X+1,Y1 is Y+1,genx(X1,Y1,L),conca(L,[],L2).
			genx(1,_,[]):-!.
			genx(X,Y,Allx):-X1 is X-1,Y1 is Y,geny(X1,Y,Ally),Allx=[Ally|Rest],genx(X1,Y1,Rest).
			geny(X,1,[]):-!.
			geny(X,Y,Ally):-X1 is X,Y1 is Y-1,Ally=[X1///Y1|Rest],geny(X1,Y1,Rest).
conca([],L,L).
conca([H|T],L1,N):-reverse(H,H2),append(H2,L1,F),conca(T,F,N).


:-end_module(gen).