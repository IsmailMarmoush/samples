:-module(lastfilter).
:-import(list).
:-export([xyfilter/2,newlist/3]).
:-op(400,yfx,///).


xyfilter(Biglist,Newlist):-newlist(Biglist,Biglist,Newlist).
newlist(Biglist,[],[]).
newlist(Biglist,Biglist2,Newlist):-
												average(Biglist,Avx,Avy),
												Biglist2=[X///Y///A///B///C///D|Rest2],
												Avnegx is abs(X-Avx), 
												Avnegy is abs(Y-Avy),
												Newlist=[X///Y///Avx///Avnegx///Avy///Avnegy|Rest3],
												newlist(Biglist,Rest2,Rest3).
			
		average(Biglist,Avx,Avy):-	getxy(Biglist,X,Y),
											sumof(X,Sum1),sumof(Y,Sum2),
											length(X,Length1),Avx is Sum1/Length1,
											length(Y,Length2),Avy is Sum2/Length2.
																								
		getxy([],[],[]).
		getxy([X///Y///Avx///Avnegx///Avy///Avnegy|Rest],Av1,Av2):-
												Av1=[X|Restx],
												Av2=[Y|Resty],
												getxy(Rest,Restx,Resty).
		
		sumof([],0).
		sumof([H|T],Sum):-sumof(T,Sum1),Sum is H+Sum1.

:-end_module(lastfilter).