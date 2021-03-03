
:- module(one, [one/1,bye/1]).
%:-import(world_b:solve(_,_)).
one(X):-write(X).
bye(Z):-write('bye bye'),write(Z).
