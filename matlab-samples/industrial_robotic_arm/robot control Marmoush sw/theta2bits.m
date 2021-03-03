function [bits,direction_bits ] = theta2bits(move_theta,motor_step,reduction_factor )

%%%%%  reduction factor
move_theta = move_theta*reduction_factor;
move_steps = move_theta/motor_step;
move_steps = ceil(move_steps);

direction_bits=0;
if(move_steps>0)
    bits=ones(1,move_steps);
    direction_bits=ones(1,move_steps);
else
    bits=ones(1,move_steps*-1);
    direction_bits=zeros(1,move_steps);
end

end

