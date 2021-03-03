function [ side3 ] = get_side( side1,angle,side2 )
%GET_SIDE Summary of this function goes here
%   Detailed explanation goes here

side3=sqrt(power(side1,2)+power(side2,2)-(2*side1*side2*cosd(angle)));

end

