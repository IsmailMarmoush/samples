function [  ] = gen_iteration(  )
%%%%%%%%%%%%%%%%%%%%%%%%%%
arm1_length=10; 
arm1_theta_start=0;
arm1_theta_step=5;
arm1_theta_end=135;
%%%%%%%%%%%%%%%%%%%%%%%%%
arm2_length=10;
arm2_theta_before=90;
arm2_theta_step=5;
arm2_theta_after=90;
%%%%%%%%%%%%%%%%%%%%%%%%%
arm3_length=10;
arm3_theta_before=90;
arm3_theta_step=5;
arm3_theta_after=90;
%%%%%%%%%%%%%%%%%%%%%%%%%

[x1,y1,arm1_theta] = arm1_generator(arm1_length,arm1_theta_start,arm1_theta_step,arm1_theta_end);
[x2,y2,arm2_theta] = arm2_generator( x1(1),y1(1),arm1_theta(1),arm2_length,arm2_theta_before,arm2_theta_step,arm2_theta_after);
[x3,y3,arm3_theta] = arm3_generator( x2(1),y2(1),arm2_theta(1),arm3_length,arm3_theta_before,arm3_theta_step,arm3_theta_after);

[zx1,zy1,zarm1_theta] = arm1_generator(arm1_length,arm1_theta_start,arm1_theta_step,arm1_theta_end);
[zx2,zy2,zarm2_theta] = arm2_generator( zx1(end),zy1(end),zarm1_theta(end),arm2_length,arm2_theta_before,arm2_theta_step,arm2_theta_after);
[zx3,zy3,zarm3_theta] = arm3_generator( zx2(end),zy2(end),zarm2_theta(end),arm3_length,arm3_theta_before,arm3_theta_step,arm3_theta_after);

plot ( [zeros(size(x1));x1],[zeros(size(y1));y1],...
       [ones(size(x2))*x1(1) ; x2],  [ones(size(y2))*y1(1); y2] ,...
       [ones(size(x3))*x2(1) ; x3],  [ones(size(y3))*y2(1); y3] ,...
       [zeros(size(zx1));zx1],[zeros(size(zy1));zy1],...
       [ones(size(zx2))*zx1(end) ; zx2],  [ones(size(zy2))*zy1(end); zy2] ,...
       [ones(size(zx3))*zx2(end) ; zx3],  [ones(size(zy3))*zy2(end); zy3]); 

end

