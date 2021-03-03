function [ x2,y2,arm2_theta_vector ] = arm2_generator( x1,y1,arm1_theta,arm2_length,theta_before,arm2_theta_step,theta_after )

if (arm1_theta >= 180)
    arm2_theta=arm1_theta-180;
else
    arm2_theta=arm1_theta+180;
end

arm2_theta_start= arm2_theta+theta_after;
%arm2_theta_step=5;
arm2_theta_end= arm2_theta+(360-theta_before);

arm2_theta_vector=arm2_theta_start:arm2_theta_step:arm2_theta_end;

[x2,y2]=get_xy ( x1,y1,arm2_length,arm2_theta_vector);             

% now we do filteration of x2,y2 that are under x axis  =>  y<0 
% by deleting the elements of theta that produces this negative y 
% mechanism is :
% find idx where y<0 , delete idx from y , x , theta 
% return the new rest of values
disp(size(x2));
disp(size(y2));
disp(size(arm2_theta_vector));

[i,j]=find(y2>=0);
y2=y2(j);
x2=x2(j);
arm2_theta_vector=arm2_theta_vector(j);


%disp(size(arm2_theta_vector));
% second part is done alhmadllah 

end

