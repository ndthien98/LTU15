% Kim Dinh Son, Le Khac Tuan, Duong Van Chinh, Pham Van Tien
% Computer Science-55th, School Of Information and Communication Technology,
% Hanoi University of Science and Technology
function [n,CC] = jacobi(L,D,p) 
%  L = Max, D la ma tran sink, source, eps = 10^-p dieu kien dung cap p
%% output: so buoc lap ma tran jacobi va ma tran cua no
%  Initial Conditions
   format long
   eps=10^(-p);
   n=0;
   C=zeros(L,L,2);
   CC= zeros(L,L);
   xx=1;
   for i=1:L
       for j=1:L
           if D(i,j)==1 
               C(i,j,xx)=1;
           else 
               C(i,j)=0;
           end
       end
   end
%%
%  Algorithm Jacobi Iteration
   tic
   while 0~=1
       n=n+1;
       yy=3-xx;
       for i=1:L
           for j=1:L
               if D(i,j)~=0
                   if D(i,j)==1 
                       C(i,j,yy)=1;
                   else
                       if D(i,j)==2
                           C(i,j,yy)=0;
                       else
                           C(i,j,yy)=0;
                       end
                   end
               else
                   up   = C(rem(i-1+L-1,L)+1,j,xx);
                   down = C(rem(i+1+L-1,L)+1,j,xx);
                   left = C(i,rem(j-1+L-1,L)+1,xx);
                   right= C(i,rem(j+1+L-1,L)+1,xx);
                   C(i,j,yy)=0.25*(up+down+left+right);
               end
           end
       end

       % Stopping Condition
       k=0;
       for i=1:L
           for j=1:L
               k=max(k,abs(C(i,j,yy)-C(i,j,xx)));
           end
       end
       xx=yy;
       if (k<eps) 
           break;
       end
       
       % Comment from line 61 to 70 for test_2D
       % print matrix result
       for i=1:L
            for j=1:L
                CC(i,j)=C(i,j,xx);
            end
       end
       
       % Plot
       h = draw(CC,L,n);
       refreshdata(h);
   end
   time = toc;
   fprintf('\tsolve time = %f seconds\n',time);
%%
%  print matrix result  
   for i=1:L
       for j=1:L
           CC(i,j)=C(i,j,xx);
       end
   end
end
