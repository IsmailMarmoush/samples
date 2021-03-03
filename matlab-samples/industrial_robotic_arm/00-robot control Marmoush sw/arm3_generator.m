function [ x3,y3,arm3_theta_vector ] = arm3_generator( x2,y2,arm2_theta,arm3_length,theta_before,arm3_theta_step,theta_after)

if (arm2_theta >= 180)
    arm3_theta=arm2_theta-180;
else
    arm3_theta=arm2_theta+180;
end

arm3_theta_start= arm3_theta+theta_after;
%arm3_theta_step=5;
arm3_theta_end= arm3_theta+(360-theta_before);

arm3_theta_vector=arm3_theta_start:arm3_theta_step:arm3_theta_end;

[x3,y3]=get_xy ( x2,y2,arm3_length,arm3_theta_vector);             

% now we do filteration of x3,y3 that are under x axis  where =>  y<0 
% by deleting the elements of theta that produces this negative y 
% mechanism is :
% find idx where y<0 , delete idx from y , x , theta 
% return the new rest of values
disp(size(x3));
disp(size(y3));
disp(size(arm3_theta_vector));

[i,j]=find(y3>=0);
y3=y3(j);
x3=x3(j);
arm3_theta_vector=arm3_theta_vector(j);


% third part is done alhmadllah 



end
