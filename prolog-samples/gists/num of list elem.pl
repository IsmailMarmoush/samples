
number([],0).
number([_|T],L):-number(T,M),L is (M+1).
%goal
%number([10,20,30,40,50,60],K).