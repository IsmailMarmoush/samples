writelist([]).
writelist([H|T]):-write(H),write('\n'),writelist(T).
%goal
%writelist([10,20,303,384,320,2]).