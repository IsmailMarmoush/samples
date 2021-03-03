solve(A,B,C):-D is B*B-4*A*C,reply(A,B,D).
reply(_,_,D):-D<0,write('no sol \n'),!.
reply(A,B,D):-S is sqrt(D),X1 is (-B+S)/(2*A),X2 is (-B-S)/(2*A),write(X1),write('  '),write(X2).
%goal
%solve(9,2,4)..