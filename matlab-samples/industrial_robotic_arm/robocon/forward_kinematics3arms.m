function [  ] = forward_kinematics(  )

l1=10;  l2=5;   l3=2;
theta1=0:10:135;
theta2=0:10:180;
theta3=0:10:180;


x1=zeros(1,length(theta1));
y1=zeros(1,length(theta1));

x2=zeros(1,length(theta1)*length(theta2));
y2=zeros(1,length(theta1)*length(theta2));

x2=zeros(1,length(theta1)*length(theta2)*length(theta3));
y2=zeros(1,length(theta1)*length(theta2)*length(theta3));

itr=0;
itr2=0;
for i1=1:1:length(theta1) 
    x1(i1)=l1*cosd(theta1(i1)) ;
    y1(i1)=l1*sind(theta1(i1)) ;
    
    
    for i2=1:1:length(theta2)    
        x2(i2+(length(theta2)*itr))=x1(i1) + l2*cosd(theta1(i1)+theta2(i2));
        y2(i2+(length(theta2)*itr))=y1(i1) + l2*sind(theta1(i1)+theta2(i2));
        
%         for i3=1:1:length(theta3)
%             xidx=i3+(length(theta3)*itr2);
%             yidx=i3+(length(theta3)*itr2);
%             x3(xidx)= x2(i2) + l3*cosd(theta1(i1)+theta2(i2)+theta3(i3));
%             y3(yidx)= y2(i2) + l3*sind(theta1(i1)+theta2(i2)+theta3(i3));
%         
%         end
%         itr2=itr2+1;
    end
    itr=itr+1;
end

plot(x1,y1,'-',x2,y2,'-');

%line([zeros(length(x1)); x1],[zeros(length(y1));y1]);

%x=l1*cosd(theta1)+ l2*cosd(theta1+theta2)+l3*cosd(theta1+theta2+theta3);
%y=l1*sind(theta1)+ l2*sind(theta1+theta2)+l3*sind(theta1+theta2+theta3);
%plot(x,y)
end

