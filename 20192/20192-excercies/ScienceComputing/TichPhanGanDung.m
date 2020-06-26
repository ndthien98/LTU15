% Tinh tich phan ham fun tu a den b, chia lam n hinh thang.
function [value] = TichPhanGanDung(fun,a,b,n);  fa = fun(a);
  fb = fun(b);
  h = (b-a)/n;
  iter = 1:n-1;
  f = fun(iter.*h+a);
  I = h/2*(fa + fb + 2*sum(f));
  value = I;
endfunction
