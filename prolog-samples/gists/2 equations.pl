equation(A1,B1,C1,A2,B2,C2,X,Y):-X is(B1*B2-C2*B1)/(A1*B2-A2*B1),Y is(A1*C2-A2*C1)/(A1*B2-A2*B1).
%hello:-write('hello'),read(B).
go:-	write('PLease enter A1'),	read(A1), 
	write('PLease enter B1'),	read(B1),
	write('PLease enter C1'),	read(C1),
	write('PLease enter A2'),	read(A2),
	write('PLease enter B2'),	read(B2),
	write('PLease enter C2'),	read(C2),
	equation(A1,B1,C1,A2,B2,C2,X,Y),write(X),write(Y).