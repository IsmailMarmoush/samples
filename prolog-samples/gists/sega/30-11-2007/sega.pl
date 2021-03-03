:-use_module(generator).
:-use_module(testing).
%checkwinners([[red,1,fail],[red,5,true],[red,3,fail],[black,7,fail],[black,3,true],[black,9,fail]],black,W).
checkwinners(Nowstate,Against,Winners):-generateagainst(Against,Nowstate,Nodes),
					checkeachnode(Against,Nodes,Winners).%check bestnodes idea

%checkeachnode(black,[[[red,1,true],[red,9,true],[red,3,true],[black,4,true],[black,5,true],[black,6,true]],
%[[red,7,true],[red,2,true],[red,3,true],[black,4,true],[black,5,true],[black,6,true]]],Winners).
checkeachnode(_,[],[]):-!.			
checkeachnode(Against,[Node|Restnodes],WinningNodes):- 
						getpositions(Against,Node,Positions),
						testaline(Positions,_),
						WinningNodes=[Node|Restwinners],
						checkeachnode(Against,Restnodes,Restwinners).
checkeachnode(Against,[Node|Restnodes],WinningNodes):- 
						getpositions(Against,Node,Positions),
						not(testaline(Positions,_)),
						checkeachnode(Against,Restnodes,WinningNodes).
%%%%%%%%%%% piece %%%%%%%%

%	Piece=[Name,Position,State].

%%%%%%% board state %%%%%%%  

%	Board=[Piece|RestPieces].

%%%%%%% nodes generator %%%%%%%%%%
%given a board state , move the with {Name (r or b)} ones every way possible 
%generate a node for each move  
%concatenate the chips with empty squares 
%   Board=[Piece|Restpieces] ,,,  Nodes=[Board|Restboards]. ,,,, Type =red or black  . 
%%%%%%%%%% Path %%%%%%%%%%%%%

%	Path=[InitialNode|Restnodes].
%%%%%%%%%% Tree %%%%%%%%%%%%%

%	Tree=[Path|Restpaths].

%%%%%%%%%% Goal %%%%%%%%%%%%%

%	goal(Board,move).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%  Main program  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%% test for goal %%%%%%%%%
