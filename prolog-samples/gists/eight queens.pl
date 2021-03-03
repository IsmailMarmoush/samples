:-op(400,xfy,user:(///)).


list=integer*



solution(list)
member(symbol,list)
noattack(symbol,list)



solution([]).
solution([X///Y|Others]):-
solution(Others),
member(Y,[1,2,3,4,5,6,7,8]),
noattack(X///Y,Others).

noattack(_,[]).
noattack(X///Y,[X1///Y1|Others]):-
Y=\=Y1,
Y1-Y=\=X1-X,
Y1-Y=\=X-X1,
noattack(X///Y,Others).

member1(Item,[Item|Rest).
member1(Item,[First|Rest):-
member1(Item,Rest).
