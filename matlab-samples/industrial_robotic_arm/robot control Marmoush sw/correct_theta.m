function [ new_theta ] = correct_theta( new_theta )
%%%%%  because theta in matrix file is sometimes bigger
if(new_theta>=360)
    new_theta=new_theta-360;
end

%%%%% convert theta into clock , anticlock degree 
%%%%% current_theta should be already converted ! as it was saved
if(new_theta>180)
    new_theta=new_theta-360;
end

end

