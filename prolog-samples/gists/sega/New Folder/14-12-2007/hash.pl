flat([],All,All).
flat([Node|Rest],Node2,All):-append(Node,Node2,Nodes),flat(Rest,Nodes,All).



decrementonlevel:-onlevel(X),retract(onlevel(X)),Y is X-1,assert(onlevel(Y)).

