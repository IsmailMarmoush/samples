function [  ] = send_data(theta1,theta2,theta3,theta4)


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
[bits1,direction_bits1 ] = theta2bits(theta1, 1,1 );
[bits2,direction_bits2 ] = theta2bits(theta2, 1,1 );
[bits3,direction_bits3 ] = theta2bits(theta3, 1,1 );
[bits4,direction_bits4 ] = theta2bits(theta4, 1,1 );
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

maxsize=max([length(bits1) , length(bits2), length(bits3),length(bits4)]);

dif1=maxsize-length(bits1);
n1=zeros(1,dif1);
bits1=[bits1 n1];
direction_bits1=[direction_bits1 n1];

dif2=maxsize-length(bits2);
n2=zeros(1,dif2);
bits2=[bits2 n1];
direction_bits2=[direction_bits2 n2];

dif3=maxsize-length(bits3);
n3=zeros(1,dif3);
bits3=[bits3 n3];
direction_bits3=[direction_bits3 n3];

dif4=maxsize-length(bits4);
n4=zeros(1,dif4);
bits4=[bits1 n4];
direction_bits4=[direction_bits4 n4];


digital_io=digitalio('parallel','LPT1');
sender=addline(digital_io,0:7,0,'out');

for i=1:1:length(bits1)
    putvalue(sender,[bits1,bits2,0,0,direction_bits1,direction_bits2,0,0]);
    putvalue(sender,[0,0,0,0,direction_bits1,direction_bits2,0,0]);
end

time=10;
for i=1:1:time
    inlines = addline(digita_io, 0:4, 1, 'in');
    data = getvalue(inlines);
    if (data>0)
       pause(.1);
    end
end
for i=1:1:length(bits2)
    putvalue(sender,[0,0,bits3,bits4,direction_bits3,direction_bits4,0,0]);
    putvalue(sender,[0,0,0,0,direction_bits3,direction_bits4,0,0]);
end

delete(digital_io);
clear('digital_io');


end