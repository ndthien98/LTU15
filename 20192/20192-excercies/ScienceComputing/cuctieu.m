% code của thiên clear;clc;fx = @(x) 0.1.*x.^3 + x.^2 - 2.*xfplot(fx,[1 2]);hold on;function [minx minf] = cuc_tieu(f, a, b, e)  while 1+1==2    x1 = a + (b-a)./2 - e/2;    x2 = a + (b-a)/2 + e/2;    f1 = f(x1);    f2 = f(x2);    a    x1    x2    b    f1    f2    printf("\n==========\n");    if f1<f2      b = x2;    elseif f1>f2      a = x1;    elseif f1==f2      a = x1;      b = x2;    endif;        if abs(a-b)<2.*e      minf = f(x1);      minx = x1;      break;    endif;  endwhile;  
endfunction;[minx minf] = cuc_tieu(fx,1,2,0.1);plot(minx,minf,'ro');minxminf
