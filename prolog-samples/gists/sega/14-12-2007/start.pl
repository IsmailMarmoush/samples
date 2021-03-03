:-use_module(generator).
:-use_module(test).
:-use_module(facts).
:-use_module(getmodule).
%play([[red,1,true],[red,7,fail],[red,3,true],[black,6,fail],[black,8,true],[black,9,true]],red,M).
%play([[red,1,fail],[red,5,true],[red,9,true],[black,2,true],[black,4,true],[black,6,true]],red,M).
play(Board,Turnof,Move):-	turnasserter(Turnof),reverser,
				levelasserter(0,[[0,1,Board]]),
				generator(1,Move).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
generator(1,Move):-level(0,Nodes),clearlevel(1),gen_test(Nodes,1,Answer,Wnode),answer1(Answer,Wnode,Move).	
generator(2,Move):-level(1,Nodes),clearlevel(2),gen_test(Nodes,2,Answer,Wnode),answer2(Answer,Wnode,Move).
generator(3,Move):-level(2,Nodes),clearlevel(3),gen_test(Nodes,3,Answer,Wnode),answer3(Answer,Wnode,Move).
generator(4,Move):-level(3,Nodes),clearlevel(4),gen_test(Nodes,4,Answer,Wnode),answer4(Answer,Wnode,Move).
generator(5,Move):-L=5,L1 is L-1,level(L1,Nodes),gen_test(Nodes,L,_,Wnode3),getinitial(L1,Wnode3,Move).

answer1(yes,Wnode,Move):-getinitial(0,Wnode,Move).
answer1(no,_,Move):-reverser,generator(2,Move).

answer3(yes,Wnode,Move):-getinitial(2,Wnode,Move).
answer3(no,_,Move):-reverser,generator(4,Move).

answer2(yes,[Initialnumber,_,_],Move):-level(1,Nodes),delete(Nodes,[_,Initialnumber,_],NewNodes),levelasserter(1,NewNodes),reverser,generator(2,Move).
answer2(no,_,Move):-reverser,generator(3,Move).

answer4(yes,[Initialnumber,_,_],Move):-level(3,Nodes),delete(Nodes,[_,Initialnumber,_],NewNodes),levelasserter(3,NewNodes),reverser,generator(4,Move).
answer4(no,_,Move):-reverser,generator(5,Move).


