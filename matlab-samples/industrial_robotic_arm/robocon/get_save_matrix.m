function [ MATRIX ] = update_matrix(  )

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
MATRIX =zeros(max_a1 * max_a2 *max_a3,  9);

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
itr=0;
[x1,y1,arm1_theta] = arm1_generator(arm1_length,arm1_theta_start,arm1_theta_step,arm1_theta_end);
for i=1:1:length(arm1_theta)
    [x2,y2,arm2_theta] = arm2_generator( x1(i),y1(i),arm1_theta(i),arm2_length,arm2_theta_before,arm2_theta_step,arm2_theta_after);
    
    for j=1:1:length(arm2_theta)
        [x3,y3,arm3_theta] = arm3_generator( x2(j),y2(j),arm2_theta(j),arm3_length,arm3_theta_before,arm3_theta_step,arm3_theta_after);
        
        for k=1:1:length(arm3_theta)
            itr=itr+1;
            MATRIX(itr,:)=[floor(x1(i)),floor(y1(i)),arm1_theta(i),floor(x2(j)),floor(y2(j)),arm2_theta(j),floor(x3(k)),floor(y3(k)),arm3_theta(k)];
            disp(abs(x3(k)));
        end
    end
end
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%    filtering the matrix from last thero elements , instead of:
%    plot([zeros(size(MATRIX(1:32240,7)));MATRIX(1:32240,7)],[zeros(size(MATRIX(1:32240,8)));MATRIX(1:32240,8)],'o');
pattern=zeros(1,9);
match=strmatch(pattern,MATRIX);
lastrow=match(1)-1;
MATRIX=MATRIX(1:lastrow,:);
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%% saving file

save('matrix.mat','MATRIX');
disp('alhmdllah');
end

