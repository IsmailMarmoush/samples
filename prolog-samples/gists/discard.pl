discard([],[]):-!.
discard([H|T],T1):-H<0,!,discard(T,T1).
discard([H|T],[H|T1]):-discard(T,T1).
%goal
%discard([1,-3,34,-20,2,30],Y).