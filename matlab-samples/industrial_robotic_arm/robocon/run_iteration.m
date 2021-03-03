function [ THE_MATRIX ] = run_iteration(  )

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


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%% calculation of approximate max size of matrix  %%%%%%%%%
max_a1= (arm1_theta_end-arm1_theta_start)/arm1_theta_step;
max_a2= (360-(arm2_theta_after+arm2_theta_before))/arm2_theta_step;
max_a3= (360-(arm3_theta_after+arm3_theta_before))/arm3_theta_step;

% the maximum of matrix size is:
THE_MATRIX =zeros(max_a1 * max_a2 *max_a3,  9);

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

itr_s=0;
itr_e=0;

[x1,y1,arm1_theta] = arm1_generator(arm1_length,arm1_theta_start,arm1_theta_step,arm1_theta_end);

for i=1:1:length(arm1_theta)
    [x2,y2,arm2_theta] = arm2_generator( x1(i),y1(i),arm1_theta(i),arm2_length,arm2_theta_before,arm2_theta_step,arm2_theta_after);
    
    for j=1:1:length(arm2_theta)
        [x3,y3,arm3_theta] = arm3_generator( x2(j),y2(j),arm2_theta(j),arm3_length,arm3_theta_before,arm3_theta_step,arm3_theta_after);
        
        for k=itr_s:1:length(arm3_theta)
            
            THE_MATRIX(k,:)=[x1(i),y1(i),arm1_theta(i),x2(j),y2(j),arm2_theta(j),x3,y3,arm3_theta];
            
        end
    end
end
    

disp('alhmdllah');



end

