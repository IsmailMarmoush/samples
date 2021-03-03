:-use_module(one).
:-use_module(two).
hello2(X,Y,Z):-one(X),two(Y),bye(Z).
