% the input layer ... facts and function
:-module(inputlayer,[inputlayerfunction/1,inputlayer/2]).

inputlayer([],[]).
inputlayer([H|T],[H2|T2]):-inputlayerfunction(H),H2=H,inputlayer(T,T2).

inputlayerfunction([I1,I2,_,Out]):-Out is I1+I2.
