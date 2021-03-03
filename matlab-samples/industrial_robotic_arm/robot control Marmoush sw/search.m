function [ theta1,theta2,theta3 ] = search(x3,y3)

% load the file directly
file=load('matrix.mat','MATRIX');

% search the file for matching x3,y3
match=strmatch([x3,y3],file.MATRIX(:,7:8));
if(length(match)>0)
    firstmatch=match(1);
    % select theta 3,6 ,9
    theta1=file.MATRIX(firstmatch,3);
    theta2=file.MATRIX(firstmatch,6);
    theta3=file.MATRIX(firstmatch,9);
else
    theta1=0;
    theta2=0;
    theta3=0;
end


end

