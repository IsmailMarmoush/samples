function [ x1,y1,arm1_theta_vector ] = arm1_generator(arm1_length,arm1_theta_start,arm1_theta_step,arm1_theta_end)
% arm1_theta_start=0;
% arm1_theta_step=5;
% arm1_theta_end= 135;
arm1_theta_vector=arm1_theta_start:arm1_theta_step:arm1_theta_end;
[x1,y1]=get_xy ( 0,0,arm1_length,arm1_theta_vector);             
% first part is done alhmadllah 
disp(size(x1));
disp(size(y1));
disp(size(arm1_theta_vector));
end

