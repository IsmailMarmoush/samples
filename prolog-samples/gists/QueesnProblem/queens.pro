
template(S,Z):-solution(S,Z).

solution([],[]).

solution([X|Other1],[Y|Other2]):-
solution(Other1,Other2),
member(Y,[1,2,3,4,5,6,7,8]),
noattack(X,Other1,Y,Other2).

noattack(_,[],_,[]).
noattack(X,[X1|Other1],Y,[Y1|Other2]):-
Y =\=Y1,
Y1-Y =\= X1-X,
Y1-Y =\=X-X1,
noattack(X,Other1,Y,Other2).

member(Item,[Item|_]).
member(Item,[_|Rest]):-
member(Item,Rest).