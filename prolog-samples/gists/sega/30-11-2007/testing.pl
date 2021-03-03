:-module(testing,[testaline/2]).
%%%%% aline %%%%%
aline([1,2,3]).
aline([4,5,6]).
aline([7,8,9]).
aline([1,4,7]).
aline([1,5,9]).
aline([3,6,9]).
aline([3,5,7]).
aline([2,5,8]).

% test aline % testaline([Position1,Position2,Position3],_).   testalien([2,5,8],_) yes
testaline([],_).
testaline([N|Rest],Z):-aline(Z),member(N,Z),testaline(Rest,Z).
