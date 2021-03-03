:-module(gen).
:-export([generator/2,genmatrix/3]).
:-import(rules). 
:-import(list).
:-op(400,yfx,///).

adding(X1///Y1,X2///Y2,L):-
X1=<7,X1>=1,
X2=<7,X2>=1,
Y1=<7,Y1>=1,
Y2=<7,Y2>=1,
L =[X1///Y1,X2///Y2],!;L=[].

right(X///Y,L)						:-X1 is X+1, X2 is X+2,									adding(X1///Y,X2///Y,L).
left(X///Y,L)						:-X1 is X-1, X2 is X-2,									adding(X1///Y,X2///Y,L).
up(X///Y,L)							:-Y1 is Y-1, Y2 is Y-2,									adding(X///Y1,X///Y2,L).
down(X///Y,L)						:-Y1 is Y+1, Y2 is Y+2,									adding(X///Y1,X///Y2,L).
rightup(X///Y,L)					:-X1 is X+1, X2 is X+2,Y1 is Y-1,Y2 is Y-2,		adding(X1///Y1,X2///Y2,L).
leftup(X///Y,L)					:-X1 is X-1, X2 is X-2,Y1 is Y-1,Y2 is Y-2,		adding(X1///Y1,X2///Y2,L).
rightdown(X///Y,L)				:-X1 is X+1, X2 is X+2,Y1 is Y+1,Y2 is Y+2,		adding(X1///Y1,X2///Y2,L).
leftdown(X///Y,L)					:-X1 is X-1, X2 is X-2,Y1 is Y+1,Y2 is Y+2,		adding(X1///Y1,X2///Y2,L).
centerupdown(X///Y,L)			:-Y1 is Y-1, Y2 is Y+1,									adding(X///Y1,X///Y2,L).
centerrightleft(X///Y,L)		:-X1 is X+1, X2 is X-1,									adding(X1///Y,X2///Y,L).
centercornerright(X///Y,L)		:-X1 is X+1, X2 is X-1,Y1 is Y-1,Y2 is Y+1,		adding(X1///Y1,X2///Y2,L).
centercornerleft(X///Y,L)		:-X1 is X-1, X2 is X+1,Y1 is Y-1,Y2 is Y+1,		adding(X1///Y1,X2///Y2,L).

generator(X///Y,Clist):-genn(X///Y,List),delete([],List,Clist).
genn(X///Y,List):-
right(X///Y,L1),
left(X///Y,L2),
up(X///Y,L3),
down(X///Y,L4),
rightup(X///Y,L5),
leftup(X///Y,L6),
rightdown(X///Y,L7),
leftdown(X///Y,L8),
centerupdown(X///Y,L9),
centerrightleft(X///Y,L10),
centercornerright(X///Y,L11),
centercornerleft(X///Y,L12),
List=[L1,L2,L3,L4,L5,L6,L7,L8,L9,L10,L11,L12].
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
genmatrix(X,Y,L2):-X1 is X+1,Y1 is Y+1,genx(X1,Y1,L),conca(L,[],L2).
genx(1,_,[]):-!.
genx(X,Y,Allx):-X1 is X-1,Y1 is Y,geny(X1,Y,Ally),Allx=[Ally|Rest],genx(X1,Y1,Rest).
geny(X,1,[]):-!.
geny(X,Y,Ally):-X1 is X,Y1 is Y-1,Ally=[X1///Y1|Rest],geny(X1,Y1,Rest).
conca([],L,L).
conca([H|T],L1,N):-reverse(H,H2),append(H2,L1,F),conca(T,F,N).


:-end_module(gen).