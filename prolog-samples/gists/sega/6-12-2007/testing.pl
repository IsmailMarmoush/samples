:-module(testing,[testaline/2,checkeachnode/3]).
:-use_module(generator).
%%%%% aline %%%%%
aline([1,2,3]).
aline([4,5,6]).
aline([7,8,9]).
aline([1,4,7]).
aline([1,5,9]).
aline([3,6,9]).
aline([3,5,7]).
aline([2,5,8]).

% test positions aline % testaline([Position1,Position2,Position3],_).   testalien([2,5,8],_) yes
testaline([],_).
testaline([N|Rest],Z):-aline(Z),member(N,Z),testaline(Rest,Z).

%checkwinners([[red,1,fail],[red,5,true],[red,3,fail],[black,7,fail],[black,3,true],[black,9,fail]],black,W).
%checkwinners(Nowstate,Against,Winners):-generateagainst(Against,Nowstate,Nodes),
%					checkeachnode(Against,Nodes,Winners).%check bestnodes idea

%checkeachnode(black,[[[red,1,true],[red,9,true],[red,3,true],[black,4,true],[black,5,true],[black,6,true]],
%[[red,7,true],[red,2,true],[red,3,true],[black,4,true],[black,5,true],[black,6,true]]],Winners).
checkeachnode(_,[],[]):-!.			
checkeachnode(Against,[Node|Restnodes],WinningNodes):- % positions true, states true
						getpositions(Against,Node,Positions),
						testaline(Positions,_),
						getstates(Against,Node,States),not(member(fail,States)),
						WinningNodes=[Node|Restwinners],
						checkeachnode(Against,Restnodes,Restwinners).
checkeachnode(Against,[Node|Restnodes],WinningNodes):- % positions fail, states fail
						getpositions(Against,Node,Positions),
						getstates(Against,Node,States),						
						not(testaline(Positions,_)),member(fail,States),
						checkeachnode(Against,Restnodes,WinningNodes).
checkeachnode(Against,[Node|Restnodes],WinningNodes):- % positions true, states fail
						getpositions(Against,Node,Positions),
						getstates(Against,Node,States),						
						testaline(Positions,_),member(fail,States),
						checkeachnode(Against,Restnodes,WinningNodes).
checkeachnode(Against,[Node|Restnodes],WinningNodes):- % positions fail, states true
						getpositions(Against,Node,Positions),
						getstates(Against,Node,States),						
						not(testaline(Positions,_)),not(member(fail,States)),
						checkeachnode(Against,Restnodes,WinningNodes).
