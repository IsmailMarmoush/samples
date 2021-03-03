conc([],L,L).
conc([H|L1],L2,[H|L3]):-conc(L1,L2,L3).%conc(L2,L1,L3);
%goal
%conc(Before,[may|After],[jan,feb,mar,apr,may,jun,jul,aug,sep,oct,nov,dec]).