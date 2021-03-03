function [  ] = forward_kinematics(  )

l1=10;  l2=5;   l3=2;
theta1=0:10:135;
theta2=0:10:180;
theta3=0:10:180;


x1=zeros(size(theta1));
y1=zeros(size(theta1));

x2=zeros(length(theta1),length(theta2));
y2=zeros(length(theta1),length(theta2));


for i1=1:1:length(theta1)    
    x1(i1)=l1*cosd(theta1(i1)) ;
    y1(i1)=l1*sind(theta1(i1)) ;
    
    for i2=1:1:length(theta1)
        for j2=1:1:length(theta2)
            x2(i2,j2)=x1(i2) + l2*cosd(theta1(i2)+theta2(j2));
            y2(i2,j2)=y1(i2) + l2*sind(theta1(i2)+theta2(j2));
        end
    end
end


plot(x2,y2);    
line([zeros(length(x1)); x1],[zeros(length(y1));y1]);
%plot([zeros(size(x2));x2],[zeros(size(y2));y2]);
%x=l1*cosd(theta1)+ l2*cosd(theta1+theta2)+l3*cosd(theta1+theta2+theta3);
%y=l1*sind(theta1)+ l2*sind(theta1+theta2)+l3*sind(theta1+theta2+theta3);
%plot(x,y)
end

