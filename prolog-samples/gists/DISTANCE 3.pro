domains
town = symbol
distance = integer

predicates
nondeterm road(symbol,symbol,distance)
nondeterm route(symbol,symbol,distance)

clauses
road(cairo,alex,200).     /*road 500*/    /*road 404*/    
road(suez,cairo,150).    
road(alex,suez,400).    /*road 500*/ 
road(alex,sharm,350).                  /*road 404*/   /*550*/
road(suez,sharm,250).  /*road 500*/    /*850*/

route(T1,T2,D):- road(T1,T2,D).
route(A,C,D):-   road(A,X,D1),road(X,C,D2),D=D1+D2.

route(G,H,D):- road(G,X,D1),road(X,Y,D2),road(Y,H,D3),D=D1+D2+D3,!. /*ma3 ta7eyat your king ;)*/
goal
route(cairo,sharm,Masafa).