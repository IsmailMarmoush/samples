:-module(del).
:-export([delete/3]).

delete(_,[],[]).
delete(X,[X|L],M):-!,delete(X,L,M).
delete(X,[Y|L1],[Y|L2]):-delete(X,L1,L2).
%delete(1,[2,1,4,1,2,3,4,1,2,3],L).

end_module(del).