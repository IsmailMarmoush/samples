function  result = main()

digital_in_out=digitalio('parallel','LPT1');
%result=digital_in_out;

sender=addline(digital_in_out,0:7,'out');
%result=sender;

%send data
for i=1:10
   
    putvalue(sender,[0,0,0,0,0,0,0,1]);
    for j=1:50000000
        k2=1;
    end

    putvalue(sender,[0,0,0,0,0,0,1,0]);
    for j=1:50000000
        k1=1;
    end
    
    putvalue(sender,[0,0,0,0,0,1,0,0]);
    for j=1:50000000
        k1=1;
    end
    putvalue(sender,[0,0,0,0,1,0,0,0]);
    for j=1:50000000
        k1=1;
    end

%     putvalue(sender,[0,0,0,0,1,0,0,0]);
%     for j=1:50000000
%         k2=1;
%     end
% 
%     putvalue(sender,[0,0,0,0,0,1,0,0]);
%     for j=1:50000000
%         k1=1;
%     end
%     
%     putvalue(sender,[0,0,0,0,0,0,1,0]);
%     for j=1:50000000
%         k1=1;
%     end
%     putvalue(sender,[0,0,0,0,0,0,0,1]);
%     for j=1:50000000
%         k1=1;
%     end

end

putvalue(sender,[0,0,0,0,0,0,0,0]);
delete(digital_in_out);

%receiver=addline(digital_in_out,[10,11,12,13,15],'in');