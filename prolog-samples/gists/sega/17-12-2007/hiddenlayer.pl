:-module(hiddenlayer,[fillhidden/3]).

%[hn1,hn2,hn3,hn4,hn5,hn6,hn7,hn8]
hneuron(hn1,n1,n2,n3).
hneuron(hn2,n4,n5,n6).
hneuron(hn3,n7,n8,n9).
hneuron(hn4,n1,n4,n7).
hneuron(hn5,n1,n5,n9).
hneuron(hn6,n3,n6,n9).
hneuron(hn7,n3,n5,n7).
hneuron(hn8,n2,n5,n8).

fillhidden(_,[],[]).
fillhidden(Out,[Hn|Rest1],[Hneuron2|Rest2]):-hneuron(Hn,N1,N2,N3),
					member([_,_,N1,O1],Out),
					member([_,_,N2,O2],Out),
					member([_,_,N3,O3],Out),
					getweights(O1,O2,O3,W1,W2,W3),
					hiddenlayerfunction(O1,O2,O3,W1,W2,W3,Hiddenout),
					Hneuron2=[O1,O2,O3,W1,W2,W3,Hn,Hiddenout],
					fillhidden(Out,Rest1,Rest2).

hiddenlayerfunction(I1,I2,I3,W1,W2,W3,Out):-Out is I1*W1+I2*W2+I3*W3.

getweights(I1,I2,I3,W1,W2,W3):-weighting(I1,W1),weighting(I2,W2),weighting(I3,W3).
weighting(I,W):-I=2,W is 1;
		I=1,W is 0.5;
		I=0,W is 0;
		I= -1,W is 0.5;
		I= -2,W is 1.
