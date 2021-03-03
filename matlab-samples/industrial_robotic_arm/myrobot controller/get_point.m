function [ x,y ] = get_point( arm_length, angle )
%GET_POINT Summary of this function goes here
%   Detailed explanation goes here

x=arm_length * cosd(angle);
y=arm_length * sind(angle);

end

