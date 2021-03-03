:- dynamic loc/2.
% Experiments
nextto(house, yard).
nextto(yard, pen).

loc(you, house).

move(Place) :-
  retract( loc(you, _) ),
  assert( loc(you, Place) ).
hi(X):-write('hello ismail',X).